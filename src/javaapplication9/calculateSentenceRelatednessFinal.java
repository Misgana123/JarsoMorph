/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author worki
 */
public class calculateSentenceRelatednessFinal {

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

    public static void main(String[] args) throws Exception {

        String fileLine = "", fileLine2 = "";
        int counter = 0, counterOne = 0, counterTwo = 0, batchCounter = 0;
        String[] splitted = null, splittedTwo = null, splittedThree = null;
        String batch = "";
        amhWords = new String[87826];
        relatedEnglish = new String[87826][10];
        relatedEnglishRatio = new float[87826][10];
        amhWordRelatedTotal = new float[87826];

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\wordsRelation.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Downloads\\Compressed\\amharicParallelData\\CCAligned v1\\amharic.txt"));
        BufferedReader br3 = new BufferedReader(new FileReader("C:\\Users\\worki\\Downloads\\Compressed\\amharicParallelData\\CCAligned v1\\english.txt"));

        while ((fileLine = br.readLine()) != null) {

            if (counter % 2 == 0) {
                splitted = fileLine.split(" : ");
                amhWords[counterOne] = splitted[0];
                counterOne++;
            } else {
                fileLine = fileLine.toLowerCase();
                splitted = fileLine.split("___");
                for (int i = 0; i < splitted.length; i++) {
                    try {
                        splittedTwo = splitted[i].split(" : ");
                        relatedEnglish[counterTwo][i] = splittedTwo[0];
                        relatedEnglishRatio[counterTwo][i] = Float.parseFloat(splittedTwo[3]);
                        amhWordRelatedTotal[counterTwo] = amhWordRelatedTotal[counterTwo] + relatedEnglishRatio[counterTwo][i];
                    } catch (Exception e) {
                        System.out.println(splitted[i]);
                    }
                }
                counterTwo++;
            }
            counter++;
        }
        System.out.println("doneOne");
        while ((fileLine = br2.readLine()) != null && (fileLine2 = br3.readLine()) != null) {

            System.out.println(fileLine + " : " + fileLine2 + " : "
                    + processor(fileLine, fileLine2));
        }
    }

    public static float processor(String fileLine, String fileLine2) throws Exception {
        String[] splittedTwo = null, splittedThree = null;

        float ratio = 0, ratioTotal = 0;
        int valid = 0;
        fileLine = cleanWords(fileLine);
        fileLine2 = cleanWords(fileLine2);
        fileLine = fileLine.toLowerCase();
        fileLine2 = fileLine2.toLowerCase();
        String[] splitted = fileLine.split(" ");
        String[] splitted2 = fileLine2.split(" ");
        float lengthOne = splitted.length;
        float lengthTwo = splitted2.length;
        float ratioOne = lengthOne/lengthTwo;
        float ratioTwo = lengthTwo/lengthOne;

        splittedTwo = splitUnique(fileLine);
        splittedThree = splitUnique(fileLine2);

        if (splittedTwo == null || splittedThree == null) {
            return 0;
        }

        for (int i = 0; i < splittedTwo.length; i++) {
            for (int j = 0; j < amhWords.length; j++) {
                if (splittedTwo[i].equals(amhWords[j])) {
                    valid++;
                    ratio = 0;
                    for (int k = 0; k < splittedThree.length; k++) {
                        for (int n = 0; n < 10; n++) {
                            if (splittedThree[k].equals(relatedEnglish[j][n])) {
                                ratio = ratio + relatedEnglishRatio[j][n];
                                break;
                            }
                        }
                    }
                    ratio = ratio / amhWordRelatedTotal[j];
                    ratioTotal = ratioTotal + ratio;

                    break;
                }
            }
        }
        if (splitted.length > splitted2.length) {
            
            return (ratioTotal / (valid)) * (ratioTwo);
        } else {
//            System.out.println("theCase: "+(ratioOne));
            return (ratioTotal / (valid)) * (ratioOne);
        }

    }

    public static String[] splitUnique(String string) {
        while (string.startsWith(" ")) {
            string = string.substring(1);
        }
        while (string.endsWith(" ")) {
            string = string.substring(0, string.length() - 1);
        }
        if (string.equals("")) {
            return null;
        }
        String[] splitted = string.split(" ");
        String temp = "";
        for (int i = 0; i < splitted.length; i++) {
            if (!temp.contains("@" + splitted[i] + "@") && !string.equals("")) {
                temp = temp + "@" + splitted[i] + "@";
            }
        }

        temp = temp.substring(1, temp.length() - 1);
        return temp.split("@@");

    }

    public static String cleanWords(String string) {

        String[] toBeReplaced = {"?", "።", "!", "]", "[", ":", ".", "_", "-", "፡", "፣", "፤", "\"", "#", "$", "&", "*", "@", "+", ",", "—", "“", "”",
            "(", ")", "<", ">", "|", "/", "{", "}", ";", "`", "~", "%", "^", "=", "‘", "“", "”", "።", "–", "፦"};
        for (int i = 0; i < toBeReplaced.length; i++) {
            string = string.replace(toBeReplaced[i], " " + toBeReplaced[i] + " ");

        }
        string = string.replace("’ ", " ");

        string = string.replace("  ", " ");
        return string;
    }
}
