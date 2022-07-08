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
public class parallelMakerUltimate {

    static String englishLetters = "abcdefghijklmnopqrstuvwxyz";
    static String[] tempWords = new String[100];
    static float[] tempCount = new float[100];
    static float[] tempRatio = new float[100];
    static float[] tempAdd = new float[100];
    static String[] wordsEngWords = new String[54148];
    static float[] wordsEngWordsCount = new float[54148];
    static String[] wordsAmhWords = new String[292183];
    static float[] wordsAmhWordsCount = new float[292183];
    static float temp2 = 0;
    static String[][] wordsAmh = new String[292183][100];
    static float[][] wordsAmhCount = new float[292183][100];
    static float[][] wordsAmhCountRatio = new float[292183][100];
    static float[][] additionalPrameter = new float[292183][100];

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
        float anotherTemp = 0;
        if (existanceCount < allCountFirst) {
            temp = existanceCount / allCountFirst;
        } else {
            temp = allCountFirst / existanceCount;
        }
        if (allCountFirst < temp2) {
            anotherTemp = allCountFirst / temp2;
        } else {
            anotherTemp = temp2 / allCountFirst;
        }
        return ((temp * existanceCount) * (ratio * anotherTemp));

    }

    public static void main(String[] args) throws Exception {

        int counter = 0;
        int counter2 = 0;
        String fileLine = "";
        String memory = "";
        String fileLine2 = "";
        String fileLine3 = "";
        String[] splitted = null;
        String[] splitted2 = null;
        String[] splitted3 = null;

        boolean done = false;
        String temp = null;

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\eng-amharicParallelByLineBySentenceAmhWords.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\eng-amharicParallelByLineBySentence.txt"));
        BufferedReader br3 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\eng-amharicParallelByLineBySentenceEngWords.txt"));
//        BufferedReader br3 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\parellel\\amharicEnglishParellel3.txt"));
        while ((fileLine = br.readLine()) != null) {
            splitted = fileLine.split(" : ");
            wordsAmhWords[counter] = splitted[0].toLowerCase();
            wordsAmhWordsCount[counter] = Integer.parseInt(splitted[1]);
            counter++;
        }
        counter = 0;
        while ((fileLine = br3.readLine()) != null) {
            splitted = fileLine.split(" : ");
            wordsEngWords[counter] = splitted[0].toLowerCase();
            wordsEngWordsCount[counter] = Integer.parseInt(splitted[1]);
            counter++;
        }
        counter = 0;
        while ((fileLine2 = br2.readLine()) != null) {
            try {
                if (fileLine2.length() < 3) {
                    continue;
                }
                splitted = fileLine2.split("	");
                fileLine2 = splitted[0];
                fileLine3 = splitted[1];
//                fileLine2 = cleanWords(fileLine2).toLowerCase();
                splitted2 = fileLine2.split(" ");
//                splitted2 = removeDupli(splitted2);
//                fileLine3 = cleanWords(fileLine3).toLowerCase();
                splitted3 = fileLine3.split(" ");
//                splitted3 = removeDupli(splitted3);
                temp = "";
                for (int i = 0; i < splitted2.length; i++) {
                    if (temp.contains("|" + splitted2[i] + "|")) {
                        continue;
                    } else {
                        temp = temp + "|" + splitted2[i] + "|";
                    }
                    for (int j = 0; j < wordsAmhWords.length; j++) {
                        if (splitted2[i].equals(wordsAmhWords[j])) {
                            for (int a = 0; a < splitted3.length; a++) {

//                                if (splitted3[a].equals("the") || splitted3[a].equals("of") || splitted3[a].equals("a")
//                                        || splitted3[a].equals("an")) {
//                                    continue;
//                                }
                                for (int k = 0; k < wordsAmh[j].length; k++) {
                                    if (wordsAmh[j][k] == null) {

                                        wordsAmh[j][k] = splitted3[a];
                                        wordsAmhCount[j][k] = 1.0f;
                                        wordsAmhCountRatio[j][k] = calculateRatio(wordsAmh[j][k], wordsAmhCount[j][k]);
                                        additionalPrameter[j][k] = newParamCalculator(wordsAmhCountRatio[j][k], wordsAmhCount[j][k], wordsAmhWordsCount[j]);
                                        if (k != wordsAmh[j].length - 1) {
                                            break;
                                        }
                                    } else if (wordsAmh[j][k].equals(splitted3[a])) {

                                        wordsAmhCount[j][k] = wordsAmhCount[j][k] + 1.0f;
                                        wordsAmhCountRatio[j][k] = calculateRatio(wordsAmh[j][k], wordsAmhCount[j][k]);
                                        additionalPrameter[j][k] = newParamCalculator(wordsAmhCountRatio[j][k], wordsAmhCount[j][k], wordsAmhWordsCount[j]);
                                        if (k != wordsAmh[j].length - 1) {
                                            break;
                                        }
                                    }
                                    if (k == wordsAmh[j].length - 1) {
                                        insertionSort(wordsAmhCountRatio[j], wordsAmhCount[j], wordsAmh[j], additionalPrameter[j], wordsAmhCount[j]);
                                        wordsAmh[j] = tempWords;
                                        wordsAmhCountRatio[j] = tempRatio;
                                        wordsAmhCount[j] = tempCount;
                                        additionalPrameter[j] = tempAdd;

                                        for (int b = 0; b < wordsAmh[j].length; b++) {
                                            if (wordsAmhCount[j][b] == 1) {
                                                wordsAmh[j][b] = null;
                                                wordsAmhCount[j][b] = 0;
                                                wordsAmhCountRatio[j][b] = 0;
                                                additionalPrameter[j][b] = 0;
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
                if (counter % 100 == 0) {
                    System.out.println(counter);
                }
//                if (counter != 0 && counter % 30000 == 0) {
//                    writeArrayOnFile();
//                    for (int j = 0; j < wordsAmh.length; j++) {
//                        System.out.println(wordsAmhWords[j] + " : ");
//                        for (int i = 0; i < 6; i++) {
//                            if (wordsAmh[j][i] != null) {
//                                System.out.print(wordsAmh[j][i] + " : " + wordsAmhCount[j][i] + " : "
//                                        + wordsAmhCountRatio[j][i] + " : " + additionalPrameter[j][i] + " ___ ");
//                            }
//                        }
//                        System.out.println("____________");
//                    }
//                }
                counter++;
            } catch (Exception e) {
                System.out.println("theFileLine: " + fileLine2 + " : " + memory);
                e.printStackTrace();
            }
            memory = fileLine;
        }
        writeArrayOnFile();
//        for (int j = 0; j < wordsAmh.length; j++) {
//            System.out.println(wordsAmhWords[j] + " : ");
//            for (int i = 0; i < 10; i++) {
//                if (wordsAmh[j][i] != null) {
//                    System.out.print(wordsAmh[j][i] + " : " + wordsAmhCount[j][i] + " : "
//                            + wordsAmhCountRatio[j][i] + " : " + additionalPrameter[j][i] + " ___ ");
//                }
//            }
//            System.out.println("____________");
//        }

    }

    public static void writeArrayOnFile() throws Exception {
        FileWriter myWriter = new FileWriter("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\arrayOnFileTemp.txt", true);

        for (int j = 0; j < wordsAmh.length; j++) {
            myWriter.write("\n" + wordsAmhWords[j] + "\n");
            for (int i = 0; i < 100; i++) {
                if (wordsAmh[j][i] != null) {
                    myWriter.write(wordsAmh[j][i] + " : " + wordsAmhCount[j][i] + " : "
                            + wordsAmhCountRatio[j][i] + " : " + additionalPrameter[j][i] + " ___ ");
                }
            }
        }
        myWriter.close();
    }

//    public static float calculateSentenceRelatedness(String fileLine) {
//        String[] splitted = fileLine.split("	");
//        String[] splitted1 = splitted[0].split(" ");
//        String[] splitted2 = splitted[1].split(" ");
//        float allAdd = 0;
//        for (int i = 0; i < splitted1.length; i++) {
//            for (int j = 0; j < wordsAmhWords.length; j++) {
//                if(splitted[i].equals(wordsAmhWords[j])){
//                    float foundRatio = 0;
//                    for(int k=0; k < 100; k++){
//                        for(int n=0; n<splitted2.length; n++){
//                            if(splitted2[n].equals(wordsAmh[j][k])){
//                                foundRatio = additionalPrameter[j][k];
//                            }
//                        }
//                        allAdd = allAdd + additionalPrameter[j][k];
//                    }
//                }
//            }
//        }
//
//    }
    public static float calculateRatio(String word, float count) {
        for (int i = 0; i < wordsEngWords.length; i++) {
            if (wordsEngWords[i].equals(word)) {
                if (count > wordsEngWordsCount[i]) {
                    System.out.println("theError: " + word + " : " + count + " : " + wordsEngWordsCount[i]);
                }
//                if (wordsEngWordsCount[i] < 8) {
//                    return 0;
//                }
                temp2 = wordsEngWordsCount[i];
                return count / wordsEngWordsCount[i];

            }
        }
        return 0;
    }

    public static String cleanWords(String string) {

        String[] toBeReplaced = {"?", "።", "!", "]", "[", ":", ".", "_", "-", "፡", "፣", "፤", "\"", "#", "$", "&", "*", "@", "+", ",", "—", "“", "”",
            "(", ")", "<", ">", "|", "/", "{", "}", ";", "`", "~", "%", "^", "=", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "   ", "  ", "  "};
        for (int i = 0; i < toBeReplaced.length; i++) {
            string = string.replace(toBeReplaced[i], " ");
        }
//            String[] splitted = string.split(" ");
//            for(int i=0; i<splitted.length; i++){
//                if(splitted[i].contains("a") || splitted[i].contains("e") || splitted[i].contains("i")
//                        ||splitted[i].contains("o") || splitted[i].contains("u")){
//                    string = string.replace(splitted[i], "");
//                }
//            }
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
