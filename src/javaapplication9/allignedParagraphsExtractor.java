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
public class allignedParagraphsExtractor {

    public static String[] toBeReplacedLetter = {"ሐ", "ሑ", "ሒ", "ሓ", "ሔ", "ሕ", "ሖ", "ኋ", "ኀ", "ኁ", "ኂ", "ኃ", "ኄ", "ኅ", "ኆ", "ኋ",
        "ኸ", "ኹ", "ኺ", "ኻ", "ኼ", "ኽ", "ኾ", "ኋ", "ጸ", "ጹ", "ጺ", "ጻ", "ጼ", "ጽ", "ጾ", "ሠ", "ሡ", "ሢ", "ሣ", "ሤ", "ሥ", "ሦ",
        "ዐ", "ዑ", "ዒ", "ዓ", "ዔ", "ዕ", "ዖ", "ኣ"};
    public static String[] replacerLetter = {"ሀ", "ሁ", "ሂ", "ሃ", "ሄ", "ህ", "ሆ", "ኋ", "ሀ", "ሁ", "ሂ", "ሃ", "ሄ", "ህ", "ሆ", "ኋ",
        "ኸ", "ሁ", "ሂ", "ሃ", "ሄ", "ህ", "ሆ", "ኋ", "ፀ", "ፁ", "ፂ", "ፃ", "ፄ", "ፅ", "ፆ", "ሰ", "ሱ", "ሲ", "ሳ", "ሴ", "ስ", "ሶ",
        "አ", "ኡ", "ኢ", "አ", "ኤ", "እ", "ኦ", "አ"};
    static FileWriter myWriter = null;
    static String[] amhWords = null;
//    static String[][] relatedEnglish = null;
//    static float[][] relatedEnglishRatio = null;
//    static float[] amhWordRelatedTotal = null;
    static int[][] index = new int[100][];
    static String[][] theLine = new String[3071][];
    static String[][] leftCasesAmh = new String[2412][];
    static String[][] leftCasesEng = new String[2412][];
    static int[][] leftCasesFirstInd = new int[2412][];
    static int[][] leftCasesSecondInd = new int[2412][];
    static float[][] leftCasesValue = new float[2412][];

    public static void main(String[] args) throws Exception {
        String fileLine = "";
        String[] splitted, splittedTwo, splittedThree, splittedFour;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\mormon\\amharicEngForEngMormon.txt"));
        amhWords = new String[87823];
//        relatedEnglish = new String[87823][10];
//        relatedEnglishRatio = new float[87823][10];
//        amhWordRelatedTotal = new float[87823];
        int counter = 0, counterOne = 0, counterTwo = 0, counterTemp = 0;
        myWriter = new FileWriter("C:\\Users\\Misgana\\Desktop\\amharicEngForEngMormonFalseUnderTwo.txt", true);
//        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\wordsRelation.txt"));

//        while ((fileLine = br2.readLine()) != null) {
//
//            if (counter % 2 == 0) {
//                splitted = fileLine.split(" : ");
//                amhWords[counterOne] = splitted[0];
//                counterOne++;
//            } else if (counter % 2 == 1) {
//                fileLine = fileLine.toLowerCase();
//                splitted = fileLine.split("___");
//                for (int i = 0; i < splitted.length; i++) {
//                    try {
//                        splittedTwo = splitted[i].split(" : ");
//                        relatedEnglish[counterTwo][i] = splittedTwo[0];
//                        relatedEnglishRatio[counterTwo][i] = Float.parseFloat(splittedTwo[3]);
//                        amhWordRelatedTotal[counterTwo] = amhWordRelatedTotal[counterTwo] + relatedEnglishRatio[counterTwo][i];
//                    } catch (Exception e) {
//                        System.out.println(fileLine);
//                    }
//                }
//                counterTwo++;
//            }
//            counter++;
//        }
        System.out.println("doneOne");
        String temp = "";
        String[] splittedBatch = null;
        counter = 0;
        while ((fileLine = br.readLine()) != null) {
            if (fileLine.equals("")) {
                continue;
            }
            if (fileLine.equals("___________________________")) {
                splittedBatch = temp.split("\n");
                theLine[counter] = splittedBatch;
                leftCasesAmh[counter] = new String[splittedBatch.length];
                leftCasesEng[counter] = new String[splittedBatch.length];
                leftCasesFirstInd[counter] = new int[splittedBatch.length];
                leftCasesSecondInd[counter] = new int[splittedBatch.length];
                leftCasesValue[counter] = new float[splittedBatch.length];
                for (int i = 0; i < splittedBatch.length; i++) {
//                    System.out.println(splittedBatch[i]);
                    splitted = splittedBatch[i].split(" ___ ");
                    splittedTwo = splitted[0].split(" : ");
                    splittedFour = splitted[1].split(" : ");
                    splittedThree = splittedTwo[1].split(" - ");
                    leftCasesAmh[counter][i] = splittedFour[0];
                    leftCasesEng[counter][i] = splittedFour[1];
                    leftCasesFirstInd[counter][i] = Integer.parseInt(splittedThree[0]);
                    leftCasesSecondInd[counter][i] = Integer.parseInt(splittedThree[1]);
                    leftCasesValue[counter][i] = Float.parseFloat(splittedTwo[0]);
                }
                counter++;
                counterTemp = 0;
                temp = "";
                continue;
            }
            if (temp.equals("")) {
                temp = fileLine;
            } else {
                temp = temp + "\n" + fileLine;
            }
            counterTemp++;
//            System.out.println(counter);
        }
        System.out.println("doneTwo");
        boolean done = true;
        boolean onlyOne = false;
        for (int i = 0; i < leftCasesAmh.length; i++) {
            done = true;
            int interval = 0,intervalPrev = 0;
            float count1 = 0, count2 = 0;
            String corruptions = "";
            float ratio = 0;
            if (leftCasesFirstInd[i] == null) {
                continue;
            }
            
//            interval = leftCasesFirstInd[i][(leftCasesFirstInd[i].length / 4)] - leftCasesSecondInd[i][(leftCasesFirstInd[i].length / 4)];
            for (int j = 0; j < leftCasesAmh[i].length; j++) {
                if (leftCasesAmh[i].length >= 1) {
//                    if (leftCasesFirstInd[i][j] - leftCasesSecondInd[i][j] != interval) {
//                        count1++;
//                        if (corruptions.equals("")) {
//                            corruptions = "" + j;
//                        } else {
//                            corruptions = corruptions + "_" + j;
//                        }
//                    } else {
//                        count2++;
//                    }
                    interval = leftCasesFirstInd[i][j] - leftCasesSecondInd[i][j];
                    if(interval == intervalPrev){
                        count1++;
                        temp = temp + "\n" + theLine[i][j];
                    }else{
                        if(count1 < 2){
                            System.out.println(temp);
                            myWriter.append("\n"+temp);
                        }
                        count1 = 0;
                        temp = theLine[i][j];
                    }
                    intervalPrev = interval;
                }
            }
            System.out.println("___________________");
            boolean not = false;
            if ((leftCasesAmh[i].length >= 4) && ( count1/count2  < 0.4)) {
                String[] splittedCorruption = corruptions.split("_");
                for (int j = 0; j < leftCasesAmh[i].length; j++) {
                    not = false;
                    for (int c = 0; c < splittedCorruption.length && c>1; c++) {
                        if (j == Integer.parseInt(splittedCorruption[c])) {
//                            System.out.println(theLine[i][j]+" : "+(count2 / count1));
                            not = true;
                        }
                    }
                    if (!not) {
//                        System.out.println(theLine[i][j]);
                    }
                }
//                System.out.println("___________________");
            }

        }
//        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\amharicEngForEngNoDuplicaate2NotRight.txt"));
//        while ((fileLine = br.readLine()) != null) {
//            try {
//                if (fileLine.equals("")) {
//                    continue;
//                }
//                if (fileLine.equals("___________________________")) {
//                    counter++;
//                    counterTemp = 0;
//                    continue;
//                }
//
//                splitted = fileLine.split(" ___ ");
//                splittedTwo = splitted[0].split(" : ");
//                splittedFour = splitted[1].split(" : ");
//                splittedThree = splittedTwo[1].split(" - ");
//                if (Integer.parseInt(splittedThree[0]) == Integer.parseInt(splittedThree[1])) {
//                    if (splittedTwo[0].equals("0.0")) {
////                        System.out.println(splittedFour[0]+" : "+splittedFour[1]);
////                        System.out.println(fileLine);
//                    }
//                } else if (Integer.parseInt(splittedThree[0]) != Integer.parseInt(splittedThree[1])) {
//                    if (Integer.parseInt(splittedThree[0]) - Integer.parseInt(splittedThree[1]) == 2
//                            || Integer.parseInt(splittedThree[0]) - Integer.parseInt(splittedThree[1]) == -2) {
//                        System.out.println(fileLine);
//                    }
////                    System.out.println(fileLine);
//                } else {
//                }
//                counterTemp++;
//            } catch (Exception e) {
//                System.out.println("theFileLine: " + fileLine);
//                e.printStackTrace();
//            }
//        }
    }

//    public static float processor(String fileLine, String fileLine2, int theI, int theJ, int theLength, int prevJ) throws Exception {
//        String[] splittedTwo = null, splittedThree = null;
//
//        float ratio = 0, ratioTotal = 0;
//        int valid = 0;
//        fileLine = cleanWords(fileLine);
//        fileLine2 = cleanWords(fileLine2);
//        fileLine = normalizeLetter(fileLine);
//        fileLine2 = normalizeLetter(fileLine2);
//
//        splittedTwo = splitUnique(fileLine);
//        splittedThree = splitUnique(fileLine2);
//
//        if (splittedTwo == null || splittedThree == null) {
//            return 0;
//        }
//        int interval = 0;
//        if (theI > theJ) {
//            interval = 1 + ((theI - theJ) / 2);
//        } else {
//            interval = 1 + ((theJ - theI) / 2);
//        }
//        for (int i = 0; i < splittedTwo.length; i++) {
//            for (int j = 0; j < amhWords.length; j++) {
//                if (splittedTwo[i].equals(amhWords[j])) {
//                    valid++;
//                    ratio = 0;
//                    for (int k = 0; k < splittedThree.length; k++) {
//                        for (int n = 0; n < 10; n++) {
//                            if (splittedThree[k].equals(relatedEnglish[j][n])) {
//                                ratio = ratio + relatedEnglishRatio[j][n];
//                                break;
//                            }
//                        }
//                    }
//                    ratio = ratio / amhWordRelatedTotal[j];
//                    ratioTotal = ratioTotal + ratio;
//
//                    break;
//                }
//            }
//        }
//        return (ratioTotal / (valid * interval));
//
//    }

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

//        String[] toBeReplaced = {"?", "።", "!", "]", "[", ":", ".", "_", "-", "፡", "፣", "፤", "\"", "#", "$", "&", "*", "@", "+", ",", "—", "“", "”",
//            "(", ")", "<", ">", "|", "/", "{", "}", ";", "`", "~", "%", "^", "=", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "   ", "  ", "  "};
        String[] toBeReplaced = {"?", "።", "!", "]", "[", ".", "_", "-", "፡", "፣", "፤", "\"", "#", "$", "&", "*", "@", "+", ",", "—", "“", "”",
            "(", ")", "<", ">", "|", "/", "{", "}", ";", "`", "~", "%", "^", "=", "   ", "  ", "  "};
        for (int i = 0; i < toBeReplaced.length; i++) {
            string = string.replace(toBeReplaced[i], " ");
        }

        string = string.replace("  ", " ");
        string = string.replace("  ", " ");
        return string;
    }

    public static String normalizeLetter(String word) throws Exception {
        for (int j = 0; j < toBeReplacedLetter.length; j++) {
            word = word.replace(toBeReplacedLetter[j], replacerLetter[j]);
        }
        return word;
    }
}
