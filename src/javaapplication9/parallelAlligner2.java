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
public class parallelAlligner2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        String fileLine = "";
        BufferedReader br2 = null;
        String fileLine2 = "";
        String[] splitted = null;
        String[] pages = new String[7346];
        String[] pages_2 = new String[32870];
        String[] pagesLinks = new String[7346];
        String[] pages_2Links = new String[32870];
        int counter = -1;

        String[] splitTemp_1 = null;
        String[] splitTemp_2 = null;

        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\JWlinkOromiffa_allFile.csv"));
        br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\engForOromiffa.txt"));

        while ((fileLine = br.readLine()) != null) {

            if (fileLine.contains("\",\"")) {
                counter++;
                splitted = fileLine.split("\",\"");
                pages[counter] = fileLine;
                pagesLinks[counter] = splitted[0];
                System.out.println(splitted[0]);
            } else {
                pages[counter] = pages[counter] + "\n" + fileLine;
            }
        }
        System.out.println("doneFirst"+" : "+counter);
        counter = -1;
        while ((fileLine = br2.readLine()) != null) {
//            fileLine = fileLine.replaceFirst("/am/", "/en/");
//            fileLine = fileLine.replaceFirst("/r93/", "/r1/");
//            fileLine = fileLine.replaceFirst("/lp-am/", "/lp-e/");
            if (fileLine.contains("\",\"")) {
                splitted = fileLine.split("\",\"");
                counter++;
                pages_2[counter] = fileLine;
                pages_2Links[counter] = splitted[0];
                
            } else {
                pages_2[counter] = pages_2[counter] + "\n" + fileLine;
                
            }
        }
        System.out.println("doneSecond: "+counter);
        String temp, tempLink = "";
        FileWriter myWriter = new FileWriter("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\engForOromiffa.txt", true);
        for (int i = 0; i < pages.length; i++) {
            
            for (int j = 0; j < pages_2.length; j++) {

                if (pagesLinks[i].equals(pages_2Links[j]) && i != j) {
//                        System.out.println(pages[i]);
//                    temp = pages_2[j];
//                    tempLink = pages_2Links[j];
//                    pages_2[j] = pages_2[i];
//                    pages_2Links[j] = pages_2Links[i];
//                    pages_2[i] = temp;
//                    pages_2Links[i] = tempLink;
//                    myWriter.write(pages_2[j] + "\n");
                    break;
                }
            }
        }
        myWriter.close();

//        for (int i = 0; i < pages.length; i++) {
//            if (pages[i] == null) {
//                continue;
//            }
////            splitted = pages[i].split("\n");
////            splitted = splitted[0].split("\",\"");
////            if (splitted[1].toLowerCase().startsWith("table of contents")) {
////                continue;
////            } else {
////            System.out.println(pages[i]);
////            }
//
//        }
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
