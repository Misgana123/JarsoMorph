/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author worki
 */
public class calculateSentenceRelatedness {

    static String[] tempRatio = null;

    public static void main(String[] args) throws Exception {
        String fileLine, fileLine2 = "";
        String[] words = new String[292183];
        int counter = 0;
        String[][] splitted = new String[292183][];
        String[] splitRealTemp = null;
        float[][] splittedTemp = new float[292183][];

        String temp = "";
        boolean trigger = true;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\arrayOnFileTemp.txt"));
        FileWriter myWriter = new FileWriter("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\arrayOnFileTemp2.txt", true);

        while ((fileLine = br.readLine()) != null) {
            if (trigger) {
                words[counter] = fileLine;
                trigger = false;
            } else {
                splitted[counter] = fileLine.split("___");
                splittedTemp[counter] = new float[splitted[counter].length];
                for (int i = 0; i < splitted[counter].length - 1; i++) {
                    splitRealTemp = splitted[counter][i].split(" : ");
                    splittedTemp[counter][i] = Float.parseFloat(splitRealTemp[3]);
                }

                insertionSort(splitted[counter], splittedTemp[counter]);
                myWriter.write("\n" + words[counter] + "\n");
                for (int i = 0; i < tempRatio.length; i++) {
                    myWriter.write(tempRatio[i] + "___");
                }
                counter++;
                trigger = true;
            }
            System.out.println(counter);
        }
        myWriter.close();
    }


    public static void insertionSort(String[] arrayRatio, float[] target) {

        tempRatio = new String[arrayRatio.length];

        for (int i = 1; i < target.length; i++) {
            float current = target[i];
            String currentRatio = arrayRatio[i];
            int j = i - 1;
            while (j >= 0 && current < target[j]) {
                target[j + 1] = target[j];
                arrayRatio[j + 1] = arrayRatio[j];
                j--;
            }
            target[j + 1] = current;
            arrayRatio[j + 1] = currentRatio;
        }

        for (int i = arrayRatio.length - 1; i >= 0; i--) {
            tempRatio[(arrayRatio.length - 1) - i] = arrayRatio[i];
        }

    }
}
