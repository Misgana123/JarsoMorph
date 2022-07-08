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
public class oneFileProcessor_4 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        String fileLine = "";
        int counter = 0;
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Amharic\\allFileTirignaParellel.csv"));

        while ((fileLine = br.readLine()) != null) {
            if(fileLine.contains("\",\"")){
                String[] splitted = fileLine.split("\",\"");
                
                System.out.println(splitted[0]);
            }
        }
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
