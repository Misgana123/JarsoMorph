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
public class calculateSentenceRelatedness2 {

    static String[] tempRatio = null;

    public static void main(String[] args) throws Exception {
        String fileLine, fileLine2 = "";
        String[] words = new String[87065];
        float[] totalResult = new float[87065];
        int counter = 0;
        String[][] splitted = new String[87065][];
        float[][] splittedTemp = new float[87065][];
        String[][] splittedWordTemp = new String[87065][];

        String temp = "";
        boolean trigger = true;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\wordsRelation.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Downloads\\Compressed\\amharicParallelData\\GoURMET-crawled.en-am\\GoURMET-crawled\\GoURMET-crawled.am-en.txt"));
        BufferedReader br3 = new BufferedReader(new FileReader("C:\\Users\\worki\\Downloads\\Compressed\\amharicParallelData\\GoURMET-crawled.en-am\\GoURMET-crawled\\GoURMET-crawled.am-en.txt"));

        while ((fileLine = br.readLine()) != null) {
            if (fileLine.startsWith(" ")) {
                fileLine = fileLine.substring(1);
            }

            if (trigger) {
                words[counter] = fileLine;
//                    System.out.println("hereWords: "+fileLine);
                trigger = false;
                continue;
            } else {

                splitted[counter] = fileLine.split("___");
                splittedTemp[counter] = new float[splitted[counter].length];
                splittedWordTemp[counter] = new String[splitted[counter].length];
                for (int i = 0; i < splitted[counter].length - 1; i++) {

                    String[] splitRealTemp = splitted[counter][i].split(" : ");

//                        System.out.println("theLength: "+splitted[counter].length);
//                        System.out.println("theFile Line"+" : "+fileLine+" : "+splitRealTemp[3]);
                    splittedTemp[counter][i] = Float.parseFloat(splitRealTemp[3].replace(" ", ""));
                    splittedWordTemp[counter][i] = splitRealTemp[0].replace(" ", "");
                    totalResult[counter] = totalResult[counter] + splittedTemp[counter][i];

                }

                counter++;
                trigger = true;
            }
            if (counter % 1000 == 0) {
                System.out.println(counter);
            }
        }
        System.out.println("doneStepOne");
        String[] anotherSplitted = null;
        String[] amhSplitted = null;
        String[] tigSplitted = null;
        float[] tigSplittedRatio = null;
        boolean done = false;
        while ((fileLine = br2.readLine()) != null && (fileLine2 = br3.readLine()) != null) {
            done = false;
            int index1 = 0, index2 = 0, index3 = 0;
            amhSplitted = fileLine.split(" ");
            tigSplitted = fileLine2.split(" ");
            tigSplittedRatio = new float[tigSplitted.length];
            float totalSentenceRatio = 0;
            for (int i = 0; i < amhSplitted.length; i++) {
                for (int j = 0; j < words.length; j++) {
                    if (amhSplitted[i].equals(words[j])) {
//                        System.out.println("notEvenHere: "+amhSplitted[i]);
                        index1 = i;
                        index2 = j;
                        boolean doneTemp = false;
                        for (int k = 0; k < splitted[index2].length; k++) {
                            for (int n = 0; n < tigSplitted.length; n++) {
                                if (tigSplitted[n].equals(splittedWordTemp[index2][k])) {
                                    tigSplittedRatio[n] = splittedTemp[index2][k] / totalResult[index2];
                                    totalSentenceRatio = totalSentenceRatio + tigSplittedRatio[n];
                                    System.out.println("theCase: " + amhSplitted[index1] + " : " + tigSplitted[n]
                                            + " : " + tigSplittedRatio[n] + " : " + splittedTemp[index2][k] + " : " + totalResult[index2]);
                                    doneTemp = true;
                                    break;
                                }
                            }
                            if (doneTemp) {
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            System.out.println("theCase: " +fileLine+" : "+ fileLine2 + " : " + (totalSentenceRatio / amhSplitted.length));
            if (done) {

            }

        }
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
