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
public class parallelMakerUltimate3 {

    static String englishLetters = "abcdefghijklmnopqrstuvwxyz";
    static String[] tempWords = new String[100];
    static float[] tempCount = new float[100];
    static float[] tempRatio = new float[100];
    static float[] tempAdd = new float[100];
    static String[] wordsEngWords = new String[32548];
    static float[] wordsEngWordsCount = new float[32548];
    static String[] wordsAmhWords = new String[87065];
    static float[] wordsAmhWordsCount = new float[87065];

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
        if (allCountFirst > 10000) {
            return (ratio * temp) + (temp * (existanceCount) * (ratio * (1 + (existanceCount / 100000))) * (ratio * (1 + (existanceCount / 100000))) * (ratio * (1 + (existanceCount / 100000))) * (ratio * (1 + (existanceCount / 100000))));
        } else if (allCountFirst > 1000) {
            return (ratio * temp) + (temp * (existanceCount) * (ratio * (1 + (existanceCount / 10000))) * (ratio * (1 + (existanceCount / 10000))) * (ratio * (1 + (existanceCount / 10000))));
        } else if (allCountFirst > 100) {
            return (ratio * temp) + (temp * (existanceCount) * (ratio * (1 + (existanceCount / 1000))) * (ratio * (1 + (existanceCount / 1000))));
        } else {
            return (ratio * temp) + (temp * (existanceCount) * (ratio * (1 + (existanceCount / 100))));
        }
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

        String[][] wordsAmh = new String[87065][100];
        float[][] wordsAmhCount = new float[87065][100];
        float[][] wordsAmhCountRatio = new float[87065][100];
        float[][] additionalPrameter = new float[87065][100];
        String[][] amharicSentences = new String[282952][];
        String[][] englishSentences = new String[282952][];
        boolean done = false;
        String temp = null;

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\oromifaEnglishParallelByLineWords.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\oromifaEnglishParallelByLineBySentence.txt"));
        BufferedReader br4 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\EnglishOromifaParallelByLineBySentence.txt"));
        BufferedReader br3 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\EnglishOromifaParallelByLineWords.txt"));

        while ((fileLine = br.readLine()) != null) {
            splitted = fileLine.split(" : ");
            wordsAmhWords[counter] = splitted[0];
            wordsAmhWordsCount[counter] = Integer.parseInt(splitted[1]);
            counter++;
        }
        System.out.println("doneOne");
        counter = 0;
        while ((fileLine = br3.readLine()) != null) {
            splitted = fileLine.split(" : ");
            wordsEngWords[counter] = splitted[0];
            wordsEngWordsCount[counter] = Integer.parseInt(splitted[1]);
            counter++;
        }
        counter = 0;
        System.out.println("doneTwo");
        while ((fileLine2 = br2.readLine()) != null && (fileLine3 = br4.readLine()) != null) {
            fileLine2 = fileLine2.toLowerCase();
            fileLine3 = fileLine3.toLowerCase();
            fileLine2 = cleanWords(fileLine2);
            fileLine3 = cleanWords(fileLine3);
            amharicSentences[counter] = fileLine2.split(" ");
            englishSentences[counter] = fileLine3.split(" ");
            counter ++;
        }
        System.out.println("doneThree");
        for (int n = 0; n < wordsAmhWords.length; n++) {
            for(int j=0; j<amharicSentences.length; j++){
            
                
                splitted2 = amharicSentences[j];
                splitted3 = englishSentences[j];

                for (int i = 0; i < splitted2.length; i++) {
                    
                    if (splitted2[i].equals(wordsAmhWords[n])) {
                        
                        for (int a = 0; a < splitted3.length; a++) {
                            for (int k = 0; k < wordsAmh[n].length; k++) {
                                if (wordsAmh[n][k] == null) {

                                    wordsAmh[n][k] = splitted3[a];
                                    wordsAmhCount[n][k] = 1.0f;
                                    wordsAmhCountRatio[n][k] = calculateRatio(wordsAmh[n][k], wordsAmhCount[n][k]);
                                    additionalPrameter[n][k] = newParamCalculator(wordsAmhCountRatio[n][k], wordsAmhCount[n][k], wordsAmhWordsCount[n]);
                                    break;
                                } else if (wordsAmh[n][k].equals(splitted3[a])) {

                                    wordsAmhCount[n][k] = wordsAmhCount[n][k] + 1.0f;
                                    wordsAmhCountRatio[n][k] = calculateRatio(wordsAmh[n][k], wordsAmhCount[n][k]);
                                    additionalPrameter[n][k] = newParamCalculator(wordsAmhCountRatio[n][k], wordsAmhCount[n][k], wordsAmhWordsCount[n]);

                                    break;
                                }
                                if (k >= wordsAmh[n].length - 1) {
                                    insertionSort(wordsAmhCountRatio[n], wordsAmhCount[n], wordsAmh[n], additionalPrameter[n], additionalPrameter[n]);
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
            }

            System.out.println(wordsAmhWords[n] + " : ");
            for (int i = 0; i < 10; i++) {
                if (wordsAmh[n][i] != null) {
                    System.out.print(wordsAmh[n][i] + " : " + wordsAmhCount[n][i] + " : "
                            + wordsAmhCountRatio[n][i] + " : " + additionalPrameter[n][i] + " ___ ");
                }
            }
            System.out.println("____________");
        }

    }

    public static void writeArrayOnFile(String[][] wordsAmh, String[][] wordsAmhCount, String[][]  wordsAmhCountRatio,
            String[][] additionalPrameter) throws Exception {
        FileWriter myWriter = new FileWriter("C:\\Users\\worki\\Desktop\\arrayOnFileTemp.txt", true);

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

    public static float calculateRatio(String word, float count) {
        for (int i = 0; i < wordsEngWords.length; i++) {
            if (wordsEngWords[i].equals(word)) {
                if (wordsEngWordsCount[i] < 8) {
                    return 0;
                }
                return count / wordsEngWordsCount[i];
            }
        }
        return 0;
    }

    public static String cleanWords(String string) {

//        String[] toBeReplaced = {"?", "።", "!", "]", "[", ":", ".", "_", "-", "፡", "፣", "፤", "\"", "#", "$", "&", "*", "@", "+", ",", "—", "“", "”",
//            "(", ")", "<", ">", "|", "/", "{", "}", ";", "`", "~", "%", "^", "=", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "   ", "  ", "  "};
        String[] toBeReplaced = {"?", "።", "!", "]", "[", ":", ".", "_", "-", "፡", "፣", "፤", "\"", "#", "$", "&", "*", "@", "+", ",", "—", "“", "”",
            "(", ")", "<", ">", "|", "/", "{", "}", ";", "`", "~", "%", "^", "="};
        for (int i = 0; i < toBeReplaced.length; i++) {
            string = string.replace(toBeReplaced[i], " "+toBeReplaced[i]+" ");
        }
//            String[] splitted = string.split(" ");
//            for(int i=0; i<splitted.length; i++){
//                if(splitted[i].contains("a") || splitted[i].contains("e") || splitted[i].contains("i")
//                        ||splitted[i].contains("o") || splitted[i].contains("u")){
//                    string = string.replace(splitted[i], "");
//                }
//            }
        string = string.replace("  ", " ");
        string = string.replace("  ", " ");
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
