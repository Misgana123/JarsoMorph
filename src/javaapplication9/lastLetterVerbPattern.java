/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;
import static javaapplication9.fullVerbAnalyser.justChangeLetter;

/**
 *
 * @author worki
 */
public class lastLetterVerbPattern {

    public static void main(String[] args) throws Exception {
        int counter = 0;
        boolean done = false;
        String[] allWords = new String[1946256];
        String[] allWordsRoot = new String[1946256];
        String[] allCoreWords = new String[1946256];
        String[] allCoreWordsRoot = new String[1946256];
        String[] allSubNobj = new String[1946256];
        String[] allWordsClass = new String[1946256];
        boolean doneClass = false;
        String fileLine = "";
        String[] splitted2 = null;
        String temp = "";
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\temp4.txt"));

        while ((fileLine = br.readLine()) != null) {
            splitted2 = fileLine.split(" : ");
            allWords[counter] = splitted2[1].substring(2);
            allCoreWords[counter] = splitted2[0];
            allSubNobj[counter] = splitted2[2];
            allWordsClass[counter] = splitted2[3];
            allCoreWordsRoot[counter] = rootWordProcessor(allCoreWords[counter]);
            allWordsRoot[counter] = rootWordProcessor_2(allWords[counter], allCoreWords[counter], allCoreWordsRoot[counter]);
            counter++;
        }
        System.out.println(temp);
    }

    public static String rootWordProcessor(String word) {
        String rootWord = "";

        if (word.startsWith("መ")) {
            rootWord = "@";
            word = word.substring(1);
        } else if (word.startsWith("ማ")) {
            rootWord = "#";
            word = word.substring(1);
        }
        String[] x = word.split("");

        for (int i = 0; i < x.length; i++) {
            rootWord = rootWord + justChangeLetter(x[i].charAt(0), 5);
        }
        return rootWord;
    }

    public static String rootWordProcessor_2(String word, String coreWord, String coreWordRoot) {
        String rootWord = "";
        String rootWordAdd = "";
        coreWordRoot = coreWordRoot.substring(1);

        if (word.startsWith("ተተ") || word.startsWith("ተት") || word.startsWith("ተታ") || (word.startsWith("ተ") && !coreWord.startsWith("መተ")
                && !coreWord.startsWith("መት"))) {
            rootWordAdd = "!";
            word = word.substring(1);
        }

        if (word.startsWith("አ")) {
            rootWordAdd = "$";
            word = word.substring(1);
        }
        String[] x = word.split("");

        for (int i = 0; i < coreWordRoot.length() && i < word.length(); i++) {
            if(i == coreWordRoot.length()-1){
                
            }
            if (justChangeLetter(x[i].charAt(0), 5) != coreWordRoot.charAt(i)) {
                System.out.println("HelloError: "+word+ " : "+coreWord);
            }
        }
        return rootWordAdd + rootWord;
    }
}
