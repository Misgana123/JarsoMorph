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
public class oneFileProcessor_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        String fileLine = "";
        String history = "";
        boolean restart = false;
        boolean opened = false;
        int counter = 0;
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Tigrigna\\tigrignaOldBible_AllClean_2.csv"));

        while ((fileLine = br.readLine()) != null) {
            counter ++;
//            if (fileLine.contains("“")) {
//                opened = true;
//                counter = 0;
//            }
            if(fileLine.startsWith("(") && fileLine.endsWith(")")){
                System.out.println(fileLine);
            }
            if (fileLine.contains("”")) {
                opened = false;
            }
            if(counter>=10){
                opened = false;
            }
            if(!history.equals("") && (isNumeric(fileLine.substring(0,1)) || fileLine.startsWith("("))){
//                System.out.println(history+" : "+fileLine.substring(0,1)+" : "+isNumeric(fileLine.substring(0,1)));
                System.out.println(history);
            }
            history = "";
            if (!opened && !(fileLine.contains("\",\"") || fileLine.contains("።") || fileLine.contains("፤") || fileLine.contains("፣")
                    || fileLine.contains("“") || fileLine.contains("፦") || fileLine.contains("!") || fileLine.contains("?")
                    || fileLine.contains("\"") || fileLine.contains("”") || fileLine.contains("፥")) && !isNumeric(fileLine.substring(0,1))) {
                history = fileLine;
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
