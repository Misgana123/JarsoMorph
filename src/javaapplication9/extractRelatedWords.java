/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

/**
 *
 * @author Misgana
 */
public class extractRelatedWords {

    public static void main(String[] args) throws Exception {
        String fileLine, fileLine2, fileLine3, fileLine4 = "";
        String[] splitted = null;
        String[] splitted2 = null;
        String[] words = new String[13504];
        String[][] relations = new String[13504][200];
        int[][] relationsCount = new int[13504][200];
        String temp = "";
        boolean done = false;
        int counter = 0;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\nounsOnDbAmhOneWordNet.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\nounsOnDbAmh.txt"));
        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        while ((fileLine = br.readLine()) != null) {
            temp = "";
            words[counter] = fileLine;
            while ((fileLine2 = br2.readLine()) != null) {
                if (!fileLine2.contains(",")) {
                    continue;
                }
                if (fileLine2.startsWith(fileLine + ",") || fileLine2.endsWith("," + fileLine)
                        || fileLine2.contains("," + fileLine + ",")) {
                    splitted = fileLine2.split("[,]");

                    for (int i = 0; i < splitted.length; i++) {
                        if (splitted[i].equals(fileLine) || splitted[i].equals("")) {
                            continue;
                        }
                        for (int j = 0; j < relations[counter].length; j++) {
                            if (relations[counter][j] == null || relations[counter][j].equals("")) {
                                relations[counter][j] = splitted[i];
                                break;
                            } else if (relations[counter][j].equals(splitted[i])) {
                                relationsCount[counter][j] = relationsCount[counter][j] + 1;
//                                out.println(fileLine+" : "+relations[counter][j]+" : "+relationsCount[counter][j]);
                                break;
                            }
                        }
                    }
//                    System.out.println("");
                }

            }
            br2 = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\nounsOnDbAmh.txt"));
            counter++;
            if (counter % 100 == 0) {
                System.out.println(counter);
            }
        }
        int[] simpleSort = {5, 4, 3, 2, 1, 0};
        for (int i = 0; i < relations.length; i++) {
            out.println("The Title: " + words[i]);
//            String[] theWord = insertionSort(relationsCount[i], relations[i]);
//            int[] theCount = insertionSortCount(relationsCount[i]);
            for (int k = 0; k < simpleSort.length; k++) {
                for (int j = 0; j < relationsCount[i].length; j++) {
                    if (relations[i][j] == null) {
                        break;
                    }
                    if (relationsCount[i][j] == simpleSort[k]) {
                        out.print("- " + relations[i][j] + " (" + relationsCount[i][j] + ") ");
                    }
                }
            }

            out.println();
        }
    }

    public static String[] insertionSort(int[] array, String[] words) {
        int size = array.length;

        for (int step = 1; step < size; step++) {
            int key = array[step];
            String keyWord = words[step];
            int j = step - 1;
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                words[j + 1] = words[j];
                --j;
            }
            array[j + 1] = key;
            words[j + 1] = keyWord;

        }
        return words;
    }

    public static int[] insertionSortCount(int[] array) {
        int size = array.length;

        for (int step = 1; step < size; step++) {
            int key = array[step];
            int j = step - 1;

            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }

            array[j + 1] = key;
        }
        return array;
    }
}
