/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author worki
 */
public class oneFileProcessor {

    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        String fileLine = "";
        int counter = 0;
        boolean go = false;
        boolean isDouble = false;
        int x = 0;
        String[] verses = null;
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Tigrigna\\bibleOldTig_AllTigrignaOnly.csv"));

        while ((fileLine = br.readLine()) != null) {
//            if(fileLine.contains("\",\"")){
//                counter++;
//                if(counter % 2 == 0){
//                    go = false;
//                }else{
//                    go = true;
//                }
//            }
//            if(go)
//                System.out.println(fileLine);
            if (fileLine.contains("\",\"")) {
                counter = 0;
            }

            counter++;
            if (counter % 2 == 0) {
                go = true;
            } else {
                go = false;
                if (fileLine.contains("-")) {
                    if (fileLine.contains("\",\"")) {
                        String[] splitted = fileLine.split("\",\"");
                        isDouble = true;
                        verses = splitted[1].split("-");
                        x = Integer.parseInt(verses[1]) - Integer.parseInt(verses[0]);
                    } else {
                        isDouble = true;
                        verses = fileLine.split("-");
                        x = Integer.parseInt(verses[1]) - Integer.parseInt(verses[0]);
                    }
                }

            }
            if (!go) {
                if (fileLine.contains("\",\"")) {
                    String[] splitted = fileLine.split("\",\"");
                    
                    if (!isDouble) {
                        System.out.println(fileLine);
                    } else {
                        System.out.println(splitted[0]+"\",\""+Integer.parseInt(verses[0]));
                        for (int i = Integer.parseInt(verses[0])+1; i <= Integer.parseInt(verses[1]); i++) {
                            System.out.println(i);
                        }
                        isDouble = false;
                    }
                } else {
                    if (!isDouble) {
                        System.out.println(fileLine);
                    } else {
                        for (int i = Integer.parseInt(verses[0]); i <= Integer.parseInt(verses[1]); i++) {
                            System.out.println(i);
                        }
                        isDouble = false;
                    }
                }
            }
//            if (go && !isDouble) {
//                System.out.println(fileLine);
//            } else if (go) {
//                System.out.println(fileLine);
//                for (int i = 0; i < x; i++) {
//                    System.out.println("Empty");
//                }
//                isDouble = false;
//            }
        }
    }

}
