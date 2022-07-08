/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class compareWordsWithProcessedWords {

    public static void main(String[] args) throws Exception {
        String fileLine, fileLine2 = "";
        String[] splitted, splitted2 = null;
        String[] processed = new String[350065];
        int counter = 0;
        boolean done = false;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\leftAllFileWords.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\onAllComputerProcessed.txt"));
        while ((fileLine2 = br2.readLine()) != null) {
//            System.out.println(fileLine2);
            splitted2 = fileLine2.split(" : ");
            if (splitted2[0].equals("notdone") || splitted2[0].equals("notDone")) {
                processed[counter] = splitted2[1];
                counter++;
            } else {
                if (splitted2[1].equals("Verb")) {
                    processed[counter] = splitted2[2];
                    counter++;
                } else {
                    processed[counter] = splitted2[4];
                    counter++;
                }
            }
        }
        while ((fileLine = br.readLine()) != null) {
            done = false;
            splitted = fileLine.split(" : ");
            for(int i=0; i<processed.length; i++){
                if(splitted[0].equals(processed[i])){
                    done = true;
                    break;
                }
            }
            if (!done) {
                System.out.println(fileLine);
            }
        }
    }
}
