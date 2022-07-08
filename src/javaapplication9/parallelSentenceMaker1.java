package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class parallelSentenceMaker1 {

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

    public static float[] cyclicArrayRotate(float[] array) {
        for (int i = array.length - 2; i >= 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = array[array.length - 1];
        return array;
    }

    public static int[] cyclicArrayRotate_2(int[] array) {
        for (int i = array.length - 2; i >= 0; i--) {
            array[i + 1] = array[i];
        }
        array[0] = array[array.length - 1];
        return array;
    }

    public static float[][] cleanPath(String[] first, float[][] path) {
        for (int n = 0; n < first.length; n++) {
            for (int i = 0; i < path.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (index[i][index[i].length - 1] == index[j][index[j].length - 1]) {
                        if (path[i].length > 1) {
                            if ((((path[i][path[i].length - 1] - path[i][path[i].length - 2]) * first[i].split(" ").length)
                                    > ((path[j][path[j].length - 1] - path[j][path[j].length - 2]) * first[j].split(" ").length))
                                    || Float.isNaN(path[j][path[j].length - 1])) {
                                path[j] = cyclicArrayRotate(path[j]);
                                path[j][0] = 0;
                                index[j] = cyclicArrayRotate_2(index[j]);

                            } else {
                                path[i] = cyclicArrayRotate(path[i]);
                                path[i][0] = 0;
                                index[i] = cyclicArrayRotate_2(index[i]);
                            }
                        } else {
                            if (((path[i][path[i].length - 1] * first[i].split(" ").length)
                                    > (path[j][path[j].length - 1] * first[j].split(" ").length))
                                    || Float.isNaN(path[j][path[j].length - 1])) {
                                path[j] = cyclicArrayRotate(path[j]);
                                path[j][0] = 0;
                                index[j] = cyclicArrayRotate_2(index[j]);

                            } else {
                                path[i] = cyclicArrayRotate(path[i]);
                                path[i][0] = 0;
                                index[i] = cyclicArrayRotate_2(index[i]);
                            }
                        }
                    }
                }
            }
        }
        return path;
    }

    public static void finalReorder(float[][] path, int[][] index, String[] first, String[] second) {
        int prevJ = -1;
        for (int i = 0; i < path.length; i++) {

            prevJ = index[i][path.length - 1];
        }
    }

    public static void longestPath(String[] first, String[] second) throws Exception {
        float[][] path = new float[first.length][second.length];
        int prevJ = 0;
        for (int i = 0; i < first.length; i++) {
            if (first[i].equals("")) {
                continue;
            }
            for (int j = 0; j < second.length; j++) {
                if (second[j].equals("")) {
                    continue;
                }
                path[i][j] = (processor(first[i], second[j], i, j, first.length, prevJ));
            }
        }
        index = new int[path.length][];
        for (int i = 0; i < path.length; i++) {
            index[i] = new int[path[i].length];
            path[i] = insertionSort(path[i], i);
        }

        path = cleanPath(first, path);

        for (int i = 0; i < path.length; i++) {
            if (first[i].equals("")) {
                continue;
            }
            write((path[i][path[i].length - 1] + " : " + i + " - " + index[i][index[i].length - 1]
                    + " ___ " + first[i] + " : " + second[index[i][index[i].length - 1]]), true);
        }
        write("\n___________________________", true);
    }

    public static float[] insertionSort(float[] target, int arrayIndex) {

        for (int i = 0; i < target.length; i++) {
            index[arrayIndex][i] = i;
        }
        for (int i = 1; i < target.length; i++) {
            float current = target[i];
            int currentIndex = index[arrayIndex][i];
            int j = i - 1;
            while (j >= 0 && current < target[j]) {
                target[j + 1] = target[j];
                index[arrayIndex][j + 1] = index[arrayIndex][j];
                j--;
            }
            target[j + 1] = current;
            index[arrayIndex][j + 1] = currentIndex;
        }

        return target;

    }

    public static void main(String[] args) throws Exception {
        String fileLine = "", fileLine2 = "";
        int counter = 0, counterOne = 0, counterTwo = 0, batchCounter = 0;
        String[] splitted = null, splittedTwo = null, splittedThree = null;
        String batch = "";
        amhWords = new String[87823];
        relatedEnglish = new String[87823][10];
        relatedEnglishRatio = new float[87823][10];
        amhWordRelatedTotal = new float[87823];
        String[] amharicBatch = new String[50000];
        String[] englishBatch = new String[50000];
        myWriter = new FileWriter("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\amharicEngForEngNoDuplicaate2.txt", true);
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\wordsRelation.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\amharicForEngNoDuplicaate.txt"));
        BufferedReader br3 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\engForamharicNoDuplicaate.txt"));

        while ((fileLine = br.readLine()) != null) {

            if (counter % 2 == 0) {
                splitted = fileLine.split(" : ");
                amhWords[counterOne] = splitted[0];
                counterOne++;
            } else if (counter % 2 == 1) {
                fileLine = fileLine.toLowerCase();
                splitted = fileLine.split("___");
                for (int i = 0; i < splitted.length; i++) {
                    try {
                        splittedTwo = splitted[i].split(" : ");
                        relatedEnglish[counterTwo][i] = splittedTwo[0];
                        relatedEnglishRatio[counterTwo][i] = Float.parseFloat(splittedTwo[3]);
                        amhWordRelatedTotal[counterTwo] = amhWordRelatedTotal[counterTwo] + relatedEnglishRatio[counterTwo][i];
                    } catch (Exception e) {
                        System.out.println(fileLine);
                    }
                }
                counterTwo++;
            }
            counter++;
        }
        System.out.println("Done One");
        while ((fileLine = br2.readLine()) != null) {
            fileLine = fileLine.toLowerCase();
            if (fileLine.startsWith("\"https://wol.jw.org/en/wol")) {
                splitted = fileLine.split("\",\"");
                amharicBatch[batchCounter] = batch;
                batchCounter++;
                batch = splitted[1];
                continue;
            } else {
                batch = batch + "\n" + fileLine;
            }
        }
        System.out.println("Done Two");
        br2.close();
        batchCounter = 0;
        batch = "";
        while ((fileLine = br3.readLine()) != null) {
            fileLine = fileLine.toLowerCase();
            if (fileLine.startsWith("\"https://wol.jw.org/en/wol")) {
                splitted = fileLine.split("\",\"");
                englishBatch[batchCounter] = batch;
                batchCounter++;
                batch = splitted[1];
                continue;
            } else {
                batch = batch + "\n" + fileLine;
            }
        }
        System.out.println("Done Three");
        for (int i = 0; i < amharicBatch.length; i++) {
            amharicBatch[i] = amharicBatch[i].replace("\n\n", "\n");
            englishBatch[i] = englishBatch[i].replace("\n\n", "\n");
            splittedTwo = amharicBatch[i].split("\n");
            splittedThree = englishBatch[i].split("\n");

            longestPath(splittedTwo, splittedThree);

//            if (splittedTwo.length > splittedThree.length) {
//            } else if (splittedTwo.length == splittedThree.length) {
//
//                longestPath(splittedTwo, splittedThree);
//                for (int j = 0; j < splittedTwo.length; j++) {
//                    if (splittedTwo[j].equals("") || splittedThree[j].equals("")) {
//                        continue;
//                    }
////                    System.out.println(splittedTwo[j] + "\t" + splittedThree[j] + " : " + processor(splittedTwo[j], splittedThree[j]));
//                }
//            } else {
//            }
        }

    }

    public static float processor(String fileLine, String fileLine2, int theI, int theJ, int theLength, int prevJ) throws Exception {
        String[] splittedTwo = null, splittedThree = null;

        float ratio = 0, ratioTotal = 0;
        int valid = 0;
        fileLine = cleanWords(fileLine);
        fileLine2 = cleanWords(fileLine2);
        fileLine = normalizeLetter(fileLine);
        fileLine2 = normalizeLetter(fileLine2);

        splittedTwo = splitUnique(fileLine);
        splittedThree = splitUnique(fileLine2);

        if (splittedTwo == null || splittedThree == null) {
            return 0;
        }
        int interval = 0;
        if (theI > theJ) {
            interval = 1 + ((theI - theJ) / 2);
        } else {
            interval = 1 + ((theJ - theI) / 2);
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
        return (ratioTotal / (valid * interval));

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

}
