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
public class oneFileProcessor_Simple {

    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        String fileLine = "";
        boolean jump = false;
        String prevFileLine = "";
        int counter = 2;
        String temp = "";
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Tigrigna\\JW_NTonlyTigrigna_AllFile.csv"));

        while ((fileLine = br.readLine()) != null) {
            temp = "";
            counter = 2;
            String[] splitted = fileLine.split("\",\"");
            String[] splitted2 = splitted[1].split(" ");
            splitted[1] = splitted[1].replaceFirst(splitted2[0]+" ", "");
            splitted2 = splitted[1].split(" ");
            for(int i=0; i<splitted2.length; i++){
                if(splitted2[i].equals(counter+"")){
                    System.out.println(temp);
                    counter++;
                    temp = "";
                }else{
                    if(temp.equals(""))
                        temp = splitted2[i];
                    else
                        temp = temp + " " + splitted2[i];
                }
            }
            System.out.println(temp);
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
