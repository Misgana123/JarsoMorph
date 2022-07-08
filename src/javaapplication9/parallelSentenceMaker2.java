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
public class parallelSentenceMaker2 {

    public static String[] toBeReplacedLetter = {"ሐ", "ሑ", "ሒ", "ሓ", "ሔ", "ሕ", "ሖ", "ኋ", "ኀ", "ኁ", "ኂ", "ኃ", "ኄ", "ኅ", "ኆ", "ኋ",
        "ኸ", "ኹ", "ኺ", "ኻ", "ኼ", "ኽ", "ኾ", "ኋ", "ጸ", "ጹ", "ጺ", "ጻ", "ጼ", "ጽ", "ጾ", "ሠ", "ሡ", "ሢ", "ሣ", "ሤ", "ሥ", "ሦ",
        "ዐ", "ዑ", "ዒ", "ዓ", "ዔ", "ዕ", "ዖ", "ኣ"};
    public static String[] replacerLetter = {"ሀ", "ሁ", "ሂ", "ሃ", "ሄ", "ህ", "ሆ", "ኋ", "ሀ", "ሁ", "ሂ", "ሃ", "ሄ", "ህ", "ሆ", "ኋ",
        "ኸ", "ሁ", "ሂ", "ሃ", "ሄ", "ህ", "ሆ", "ኋ", "ፀ", "ፁ", "ፂ", "ፃ", "ፄ", "ፅ", "ፆ", "ሰ", "ሱ", "ሲ", "ሳ", "ሴ", "ስ", "ሶ",
        "አ", "ኡ", "ኢ", "አ", "ኤ", "እ", "ኦ", "አ"};
    static FileWriter myWriter = null;
    static String[] amhWords = null;
    static String[][] relatedEnglish = null;
    static float[][] relatedEnglishRatio = null;
    static float[] amhWordRelatedTotal = null;
    static int[][] index = new int[100][];
    public static void write(String line, boolean newLine) throws Exception {
        if (newLine) {
            myWriter.write("\n" + line);
        } else {
            myWriter.write(line);
        }
    }
    public static void main(String[] args) throws Exception {
        String fileLine = "", fileLine2 = "";
        int counter = 1, counterOne = 0, counterTwo = 0, batchCounter = 0, counterTemp = 0;
        String[] splitted = null, splittedTwo = null, splittedThree = null, splittedFour = null;
        String batch = "";
        amhWords = new String[87826];
        relatedEnglish = new String[87826][10];
        relatedEnglishRatio = new float[87826][10];
        amhWordRelatedTotal = new float[87826];
        String[] amharicBatch = new String[370527];
        String[] englishBatch = new String[370527];
        String[] batchSplittedAmh = null;
        String[] batchSplittedEng = null;
        myWriter = new FileWriter("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\englishAmharicParallelTestBoth.txt", true);
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\amharicEngParallelByParagraphOnlyParallelEngAmh2.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\amharicEngParallelByParagraphOnlyParallelAmh.txt"));
        BufferedReader br3 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\amharicEngParallelByParagraphOnlyParallelEng.txt"));
        while ((fileLine = br2.readLine()) != null) {
            if (fileLine.startsWith("_______--_______")) {
                splitted = fileLine.split("_______--_______");
                amharicBatch[batchCounter] = batch;
                batchCounter++;
                batch = splitted[1];
                continue;
            } else {
                batch = batch + "\n" + fileLine;
            }
        }
        System.out.println("Done One");
        br2.close();
        batchCounter = 0;
        batch = "";
        while ((fileLine = br3.readLine()) != null) {
            fileLine = fileLine.toLowerCase();
            if (fileLine.startsWith("_______--_______")) {
                splitted = fileLine.split("_______--_______");
                englishBatch[batchCounter] = batch;
                batchCounter++;
                batch = splitted[1];
                continue;
            } else {
                batch = batch + "\n" + fileLine;
            }
        }
        br3.close();
        System.out.println("doneTwo");
        while ((fileLine = br.readLine()) != null) {
            try {
                batchSplittedAmh = amharicBatch[counter].split("\n");
                batchSplittedEng = englishBatch[counter].split("\n");
                if (fileLine.equals("")) {
                    continue;
                }
                if (fileLine.equals("___________________________")) {
                    counter++;
                    counterTemp = 0;
                    continue;
                }
                splitted = fileLine.split(" ___ ");
                splittedTwo = splitted[0].split(" : ");
                splittedFour = splitted[1].split(" : ");
                splittedThree = splittedTwo[1].split(" - ");
                if (Integer.parseInt(splittedThree[0]) == Integer.parseInt(splittedThree[1])) {
                    if (!splittedTwo[0].equals("0.0")) {
                        write(splittedFour[0]+" : "+splittedFour[1],true);
                    }
                } else if (Integer.parseInt(splittedThree[0]) > Integer.parseInt(splittedThree[1])) {

                } else {
//                    if (counterTemp == 0) {
//                        System.out.println(fileLine + " ___ " + batchSplittedAmh[counterTemp] + " : " + counterTemp);
//                    }else{
//                        
//                    }
                }
                counterTemp++;
            } catch (Exception e) {
                System.out.println("theFileLine: " + fileLine + " : " + batchSplittedAmh[counterTemp - 1]);
                e.printStackTrace();
            }
        }
        myWriter.close();
    }
}
