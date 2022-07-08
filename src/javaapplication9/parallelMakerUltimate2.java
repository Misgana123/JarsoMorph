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
public class parallelMakerUltimate2 {

    static String englishLetters = "abcdefghijklmnopqrstuvwxyz";
    static String[] tempWords = new String[100];
    static float[] tempCount = new float[100];
    static float[] tempRatio = new float[100];
    static float[] tempAdd = new float[100];
    static String[] wordsEngWords = new String[70460];
    static float theEngIndex = 0;
    static float[] wordsEngWordsCount = new float[70460];
    static String[] wordsAmhWords = new String[416375];
    static float[] wordsAmhWordsCount = new float[416375];
    static FileWriter myWriter = null;

    public static String[] toBeReplacedLetterTig = {"ሐ", "ሑ", "ሒ", "ሓ", "ሔ", "ሕ", "ሖ", "ኋ", "ኀ", "ኁ", "ኂ", "ኃ", "ኄ", "ኅ", "ኆ", "ኋ",
        "ጸ", "ጹ", "ጺ", "ጻ", "ጼ", "ጽ", "ጾ", "ሠ", "ሡ", "ሢ", "ሣ", "ሤ", "ሥ", "ሦ",
        "ዐ", "ዑ", "ዒ", "ዓ", "ዔ", "ዕ", "ዖ", "ኣ"};
    public static String[] replacerLetterTig = {"ሀ", "ሁ", "ሂ", "ሃ", "ሄ", "ህ", "ሆ", "ኋ", "ሀ", "ሁ", "ሂ", "ሃ", "ሄ", "ህ", "ሆ", "ኋ",
        "ፀ", "ፁ", "ፂ", "ፃ", "ፄ", "ፅ", "ፆ", "ሰ", "ሱ", "ሲ", "ሳ", "ሴ", "ስ", "ሶ",
        "አ", "ኡ", "ኢ", "አ", "ኤ", "እ", "ኦ", "አ"};

    public static String[] removeDupli(String[] words) {
        String temp = "";
        String[] tempArray = null;
        if (words.length < 2) {
            return words;
        }
        for (int i = 0; i < words.length; i++) {
            if (!temp.contains("@" + words[i] + "@")) {
                temp = temp + "@" + words[i] + "@";
            }
        }
        tempArray = temp.substring(1, temp.length() - 1).split("@");
        return tempArray;
    }

    public static float newParamCalculator(float ratio, float existanceCount, float allCountFirst) {
        float temp = 0;
        if (existanceCount < allCountFirst) {
            temp = existanceCount / (allCountFirst);
        } else {
            temp = allCountFirst / (existanceCount);
        }
        if (existanceCount > 100000) {
            return (ratio * temp) + (ratio * temp * (existanceCount) * (ratio/2 * (1 + (existanceCount / 1000000))) * (ratio/2 * (1 + (existanceCount / 1000000))) * (ratio/2 * (1 + (existanceCount / 1000000))) * (ratio/2 * (1 + (existanceCount / 1000000))) * (ratio/2* (1 + (existanceCount / 1000000))));
        }else if (existanceCount > 10000) {
            return (ratio * temp) + (ratio * temp * (existanceCount) * (ratio/2 * (1 + (existanceCount / 100000))) * (ratio/2 * (1 + (existanceCount / 100000))) * (ratio/2 * (1 + (existanceCount / 100000))) * (ratio/2 * (1 + (existanceCount / 100000))));
        } else if (existanceCount > 1000) {
            return (ratio * temp) + (ratio * temp * (existanceCount) * (ratio/2 * (1 + (existanceCount / 10000))) * (ratio/2 * (1 + (existanceCount / 10000))) * (ratio/2 * (1 + (existanceCount / 10000))));
        } else if (existanceCount > 100) {
            return (ratio * temp) + (ratio * temp * (existanceCount) * (ratio/2 * (1 + (existanceCount / 1000))) * (ratio/2 * (1 + (existanceCount / 1000))));
        } else {
            return (ratio * temp) + (ratio * temp * (existanceCount) * (ratio/2 * (1 + (existanceCount / 100))));
        }

    }
    
    public static float newParamCalculator2(float ratio, float existanceCount, float allCountFirst, float theEngIndex) {
        float temp = 0, temp2 = 0;
        if (existanceCount < allCountFirst) {
            temp = existanceCount / (allCountFirst);
        } else {
            temp = allCountFirst / (existanceCount);
        }
        if(theEngIndex>allCountFirst){
            temp2 = allCountFirst/theEngIndex;
        }else{
            temp2 = theEngIndex/allCountFirst;
        }
        
        if (allCountFirst > 100000) {
            return (ratio * temp * temp2) + (temp *  (existanceCount) * (ratio * temp2 *(1 + (existanceCount / 1000000))) * (ratio * temp2 *(1 + (existanceCount / 1000000))) * (ratio * temp2 *(1 + (existanceCount / 1000000))) * (ratio * temp2 *(1 + (existanceCount / 1000000))) * (ratio * temp2 *(1 + (existanceCount / 1000000))));
        }else if (allCountFirst > 10000) {
            return (ratio * temp * temp2) + (temp *  (existanceCount) * (ratio * temp2 *(1 + (existanceCount / 100000))) * (ratio * temp2 *(1 + (existanceCount / 100000))) * (ratio * temp2 *(1 + (existanceCount / 100000))) * (ratio * temp2 *(1 + (existanceCount / 100000))));
        } else if (allCountFirst > 1000) {
            return (ratio * temp * temp2) + (temp *  (existanceCount) * (ratio * temp2 *(1 + (existanceCount / 10000))) * (ratio * temp2 *(1 + (existanceCount / 10000))) * (ratio * temp2 *(1 + (existanceCount / 10000))));
        } else if (allCountFirst > 100) {
            return (ratio * temp * temp2) + (temp *  (existanceCount) * (ratio * temp2 *(1 + (existanceCount / 1000))) * (ratio * temp2 *(1 + (existanceCount / 1000))));
        } else {
            return (ratio * temp * temp2) + (temp *  (existanceCount) * (ratio * temp2 *(1 + (existanceCount / 100))));
        }

    }
    public static float newParamCalculator3(float ratio, float existanceCount, float allCountFirst, float theEngIndex) {
        float temp = 0,temp2 = 0;
        if (existanceCount < allCountFirst) {
            temp = existanceCount / (allCountFirst);
        } else {
            temp = allCountFirst / (existanceCount);
        }
        if(theEngIndex>allCountFirst){
            temp2 = allCountFirst/theEngIndex;
        }else{
            temp2 = theEngIndex/allCountFirst;
        }
        if (allCountFirst > 100000) {
            return (ratio * temp * temp2) + (temp * (existanceCount * existanceCount) * (ratio * temp2 *  (1 + (existanceCount / 1000000))) * (ratio * temp2 *  (1 + (existanceCount / 1000000))) * (ratio * temp2 *  (1 + (existanceCount / 1000000))) * (ratio * temp2 *  (1 + (existanceCount / 1000000))) * (ratio * temp2 *  (1 + (existanceCount / 1000000))));
        }else if (allCountFirst > 10000) {
            return (ratio * temp * temp2) + (temp * (existanceCount * existanceCount) * (ratio * temp2 *  (1 + (existanceCount / 100000))) * (ratio * temp2 *  (1 + (existanceCount / 100000))) * (ratio * temp2 *  (1 + (existanceCount / 100000))) * (ratio * temp2 *  (1 + (existanceCount / 100000))));
        } else if (allCountFirst > 1000) {
            return (ratio * temp * temp2) + (temp * (existanceCount * existanceCount) * (ratio * temp2 *  (1 + (existanceCount / 10000))) * (ratio * temp2 *  (1 + (existanceCount / 10000))) * (ratio * temp2 *  (1 + (existanceCount / 10000))));
        } else if (allCountFirst > 100) {
            return (ratio * temp * temp2) + (temp * (existanceCount * existanceCount) * (ratio * temp2 *  (1 + (existanceCount / 1000))) * (ratio * temp2 *  (1 + (existanceCount / 1000))));
        } else {
            return (ratio * temp * temp2) + (temp * (existanceCount * existanceCount) * (ratio * temp2 *  (1 + (existanceCount / 100))));
        }
    }

    public static void main(String[] args) throws Exception {
        String[] words = new String[310116];
        int[] count = new int[310116];
        int counter = 0;
        int counter2 = 0;
        String fileLine = "";
        String memory = "";
        String fileLine2 = "";
        String fileLine3 = "";
        String[] splitted = null;
        String[] splitted2 = null;
        String[] splitted3 = null;

        myWriter = new FileWriter("C:\\Users\\worki\\Desktop\\JWlinks\\Tigrigna\\TigrignaFiles\\wordsRelationTigEng8.txt", true);

        String[][] wordsAmh = new String[416375][100];
        float[][] wordsAmhCount = new float[416375][100];
        boolean[][] touched = new boolean[416375][100];
        float[][] wordsAmhCountRatio = new float[416375][100];
        float[][] additionalPrameter = new float[416375][100];
        String[][] amharicSentences = new String[338700][];
        String[][] englishSentences = new String[338700][];
        boolean done = false;
        String temp = null;

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Tigrigna\\TigrignaFiles\\allTigForEngParallelWords.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Tigrigna\\TigrignaFiles\\allTigForEngParallel.txt"));
        BufferedReader br4 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Tigrigna\\TigrignaFiles\\allEngForTigParallel.txt"));
        BufferedReader br3 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Tigrigna\\TigrignaFiles\\allEngForTigParallelWords.txt"));

        while ((fileLine = br.readLine()) != null) {
            splitted = fileLine.split(" : ");
            wordsAmhWords[counter] = normalizeLetter(splitted[0]);
            wordsAmhWordsCount[counter] = Integer.parseInt(splitted[1]);
            counter++;
        }
        System.out.println("doneOne");
        counter = 0;
        while ((fileLine = br3.readLine()) != null) {
            splitted = fileLine.split(" : ");
            wordsEngWords[counter] = splitted[0].toLowerCase();
            wordsEngWordsCount[counter] = Integer.parseInt(splitted[1]);
            counter++;

        }
        System.out.println("doneTwo");
        counter = 0;
        while ((fileLine2 = br2.readLine()) != null && (fileLine3 = br4.readLine()) != null) {
            fileLine2 = normalizeLetter(fileLine2);
            fileLine3 = fileLine3.toLowerCase();
            fileLine2 = cleanWords(fileLine2);
            fileLine3 = cleanWords(fileLine3);
            amharicSentences[counter] = fileLine2.split(" ");
            englishSentences[counter] = fileLine3.split(" ");
            counter++;
        }
        System.out.println("doneThree");
        for (int n = 0; n < wordsAmhWords.length; n++) {
            for (int j = 0; j < amharicSentences.length; j++) {

//                if (fileLine2.length() < 3) {
//                    continue;
//                }
                splitted2 = amharicSentences[j];
                splitted3 = englishSentences[j];

                for (int i = 0; i < splitted2.length; i++) {

                    if (splitted2[i].equals(wordsAmhWords[n])) {

                        for (int a = 0; a < splitted3.length; a++) {
                            for (int k = 0; k < wordsAmh[n].length; k++) {
                                if (wordsAmh[n][k] == null) {

                                    wordsAmh[n][k] = splitted3[a];
                                    wordsAmhCount[n][k] = 1.0f;
                                    touched[n][k] = true;

                                    break;
                                } else if (wordsAmh[n][k].equals(splitted3[a])) {

                                    wordsAmhCount[n][k] = wordsAmhCount[n][k] + 1.0f;
                                    touched[n][k] = true;
//                                    System.out.println("theWord: " + wordsAmhWords[n] + " : " + wordsAmhCount[n][k]);

                                    break;
                                }
                                if (k >= wordsAmh[n].length - 1) {
//                                    for (int t = 0; t < wordsAmh[n].length; t++) {
//                                        if (touched[n][t]) {
//                                            wordsAmhCountRatio[n][t] = calculateRatio(wordsAmh[n][t], wordsAmhCount[n][t]);
//                                            additionalPrameter[n][t] = newParamCalculator(wordsAmhCountRatio[n][t], wordsAmhCount[n][t], wordsAmhWordsCount[n]);
//                                            touched[n][t] = false;
//                                        }
//                                    }
                                    insertionSort(wordsAmhCountRatio[n], wordsAmhCount[n], wordsAmh[n], additionalPrameter[n], wordsAmhCount[n]);
                                    wordsAmh[n] = tempWords;
                                    wordsAmhCountRatio[n] = tempRatio;
                                    wordsAmhCount[n] = tempCount;
                                    additionalPrameter[n] = tempAdd;

                                    for (int b = 0; b < wordsAmh[n].length; b++) {
                                        if (wordsAmhCount[n][b] == 1) {
                                            wordsAmh[n][b] = null;
                                            wordsAmhCount[n][b] = 0;
                                            wordsAmhCountRatio[n][b] = 0;
                                            additionalPrameter[n][b] = 0;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }

                }
//                if (j % 1000 == 0) {
//                    System.out.println("theCount: " + j);
//                }
            }

            write(wordsAmhWords[n] + " : \n", true);
            System.out.println(wordsAmhWords[n] + " : ");
            for (int t = 0; t < wordsAmh[n].length; t++) {
                if (touched[n][t]) {
                    wordsAmhCountRatio[n][t] = calculateRatio(wordsAmh[n][t], wordsAmhCount[n][t]);
                    
                    additionalPrameter[n][t] = newParamCalculator3(wordsAmhCountRatio[n][t], wordsAmhCount[n][t], wordsAmhWordsCount[n],theEngIndex);
//                    System.out.println("mayBeError: "+wordsAmhWordsCount[n]+" : "+theEngIndex+ " : "+wordsAmh[n][t]+ " - "+additionalPrameter[n][t]);
                    touched[n][t] = false;
                }
            }
            insertionSort(wordsAmhCountRatio[n], wordsAmhCount[n], wordsAmh[n], additionalPrameter[n], additionalPrameter[n]);
            wordsAmh[n] = tempWords;
            wordsAmhCountRatio[n] = tempRatio;
            wordsAmhCount[n] = tempCount;
            additionalPrameter[n] = tempAdd;
            for (int i = 0; i < 10; i++) {
                if (wordsAmh[n][i] != null) {
                    if (i < 9) {
                        write(wordsAmh[n][i] + " : " + wordsAmhCount[n][i] + " : "
                                + wordsAmhCountRatio[n][i] + " : " + additionalPrameter[n][i] + "___", false);
                        System.out.print(wordsAmh[n][i] + " : " + wordsAmhCount[n][i] + " : "
                                + wordsAmhCountRatio[n][i] + " : " + additionalPrameter[n][i] + "___");
                    } else {
                        write(wordsAmh[n][i] + " : " + wordsAmhCount[n][i] + " : "
                                + wordsAmhCountRatio[n][i] + " : " + additionalPrameter[n][i], false);
                        System.out.print(wordsAmh[n][i] + " : " + wordsAmhCount[n][i] + " : "
                                + wordsAmhCountRatio[n][i] + " : " + additionalPrameter[n][i]);
                    }
                }
            }
            write("", true);
            System.out.println("");

        }
        myWriter.close();

    }

    public static void write(String line, boolean newLine) throws Exception {

        if (newLine) {
            myWriter.write("\n" + line);
        } else {
            myWriter.write(line);
        }

    }

    public static String normalizeLetter(String word) throws Exception {
        for (int j = 0; j < toBeReplacedLetterTig.length; j++) {
            word = word.replace(toBeReplacedLetterTig[j], replacerLetterTig[j]);
        }
        return word;
    }

    public static void writeArrayOnFile(String[][] wordsAmh, String[][] wordsAmhCount, String[][] wordsAmhCountRatio,
            String[][] additionalPrameter) throws Exception {
        FileWriter myWriter = new FileWriter("C:\\Users\\worki\\Desktop\\arrayOnFileTemp.txt", true);

        for (int j = 0; j < wordsAmh.length; j++) {
            myWriter.write(wordsAmhWords[j] + "\n");
            for (int i = 0; i < 100; i++) {
                if (wordsAmh[j][i] != null) {
                    myWriter.write(wordsAmh[j][i] + " : " + wordsAmhCount[j][i] + " : "
                            + wordsAmhCountRatio[j][i] + " : " + additionalPrameter[j][i] + " ___ ");
                }
            }
        }
        myWriter.close();
    }

    public static float calculateRatio(String word, float count) {
        for (int i = 0; i < wordsEngWords.length; i++) {
            if (wordsEngWords[i].equals(word)) {
                theEngIndex = wordsEngWordsCount[i];
//                if (wordsEngWordsCount[i] < 4) {
//                    return 0;
//                }
                return count / wordsEngWordsCount[i];
            }
        }
        return 0;
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

    public static void insertionSort(float[] arrayRatio, float[] arrayCount, String[] words, float[] addParam, float[] target) {
        tempWords = new String[100];
        tempCount = new float[100];
        tempRatio = new float[100];
        tempAdd = new float[100];

        for (int i = 1; i < target.length; i++) {
            float current = target[i];
            float currentCount = arrayCount[i];
            float currentRatio = arrayRatio[i];
            float currentAdd = addParam[i];
            String currentStr = words[i];
            int j = i - 1;
            while (j >= 0 && current < target[j]) {
                target[j + 1] = target[j];
                words[j + 1] = words[j];
                arrayCount[j + 1] = arrayCount[j];
                arrayRatio[j + 1] = arrayRatio[j];
                addParam[j + 1] = addParam[j];
                j--;
            }
            target[j + 1] = current;
            words[j + 1] = currentStr;
            arrayCount[j + 1] = currentCount;
            arrayRatio[j + 1] = currentRatio;
            addParam[j + 1] = currentAdd;
        }

        for (int i = words.length - 1; i >= 0; i--) {
            tempWords[(words.length - 1) - i] = words[i];
            tempRatio[(arrayRatio.length - 1) - i] = arrayRatio[i];
            tempCount[(arrayCount.length - 1) - i] = arrayCount[i];
            tempAdd[(addParam.length - 1) - i] = addParam[i];
        }

    }
}
