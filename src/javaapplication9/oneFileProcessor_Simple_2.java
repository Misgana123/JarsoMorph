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
public class oneFileProcessor_Simple_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        String fileLine = "";
        boolean jump = false;
        String prevFileLine = "";
        int counter = 1;
        String temp = "";
        String verse = "";
        String fileOriginal = "";
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Tigrigna\\bibleAllFile.csv"));

        while ((fileLine = br.readLine()) != null) {
            String[] splitted = fileLine.split(" ");
            if (splitted[0].equals(counter + "")) {
                System.out.println(verse);
                verse = "";
                counter++;
                continue;
            } else {
                if (splitted[0].equals("1")) {
                    System.out.println(verse);
                    verse = "";
                    counter = 2;
                    continue;
                } else {
                    if (fileLine.contains(" " + 1 + " ")) {
                        System.out.println(verse);
                        verse = "";
                        counter = 2;
                        continue;
                    }
                    fileOriginal = fileLine;
                    for (int i = 0; i < splitted.length; i++) {
                        if (splitted[i].equals(counter + "")) {
                            fileLine = fileLine.replace(temp + " ", "");
                            break;
                        }
                        if (i == 0) {
                            temp = splitted[i];
                        } else {
                            temp = temp + " " + splitted[i];
                        }
                    }
                    for(int i=2; i<splitted.length; i++){
                        
                    }

                    if (!fileLine.contains(" " + 2 + " ")) {
                        System.out.println(splitted[0] + " :: " + fileLine + " : " + counter + "\n\n" + fileOriginal);
                    } else {
                        System.out.println(verse);
                        verse = "";
                        counter++;
                    }
                }
            }
            System.out.println(verse);
            verse = "";
        }
        System.out.println(counter);
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
