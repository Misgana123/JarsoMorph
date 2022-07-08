/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author worki
 */
public class parallelMaker_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        String fileLine = "";
        BufferedReader br2 = null;
        String fileLine2 = "";
        String[] splitted = null;
        String[] pages = new String[361586];
        String[] pages_2 = new String[361586];
        int counter = -1;

        String[] splitTemp_1 = null;
        String[] splitTemp_2 = null;

        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\amharicForEngParallelByLine.txt"));
        br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\engForamharicParallelByLine.txt"));

        while ((fileLine = br.readLine()) != null) {
//            if (fileLine.contains("\",\"")) {
                counter++;
//                splitted = fileLine.split("\",\"");
//                pages[counter] = splitted[1];
                pages[counter] = fileLine;
//            } else {
//                pages[counter] = pages[counter] + "\n" + fileLine;
//            }
        }
        counter = -1;
        while ((fileLine = br2.readLine()) != null) {
//            if (fileLine.contains("\",\"")) {
                counter++;
//                splitted = fileLine.split("\",\"");
//                pages_2[counter] = splitted[1];
                pages_2[counter] = fileLine;
//            } else {
//                pages_2[counter] = pages_2[counter] + "\n" + fileLine;
//            }
        }
         FileWriter myWriter = new FileWriter("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\eng-amharicParallelByLineBySentence.txt", true);
        for (int i = 0; i < pages.length; i++) {
            try{
            splitTemp_1 = pages[i].split("።");
            splitTemp_2 = pages_2[i].split("\\.");
            if (splitTemp_1.length == splitTemp_2.length) {
//                System.out.println(pages_2[i]);
                for(int j=0; j<splitTemp_1.length; j++){
                    myWriter.write(splitTemp_1[j]+"\t"+splitTemp_2[j].toLowerCase()+"\n");
//                    myWriter.write(splitTemp_2[j]+"\n");
                    
                }
            }
            }catch(Exception e){
                System.out.println("theErrorMustBe: "+pages[i]+"\n\n : \n\n"+pages_2[i]);
            }
        }
        myWriter.close();

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
