/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author worki
 */
public class parallelAlligner {

    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        String fileLine = "";
        BufferedReader br2 = null;
        String fileLine2 = "";
        String[] splitted = null;
        String[] pages = new String[40000];
        String[] pages_2 = new String[40000];
        String[] pagesLinks = new String[40000];
        String[] pages_2Links = new String[40000];
        int counter = -1;

        String[] splitTemp_1 = null;
        String[] splitTemp_2 = null;

        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Tigrigna\\TigrignaFiles\\englishAllNoDuplicate.csv"));
        br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Tigrigna\\TigrignaFiles\\tigregnaAllNoDuplicate.csv"));

        while ((fileLine = br.readLine()) != null) {
            if (fileLine.contains("\",\"")) {
                counter++;
                splitted = fileLine.split("\",\"");
                pages[counter] = fileLine;
                pagesLinks[counter] = splitted[0];
            } else {
                pages[counter] = pages[counter] + "\n" + fileLine;
            }
        }
        System.out.println("doneFirst");
        counter = -1;
        while ((fileLine = br2.readLine()) != null) {
//            fileLine = fileLine.replaceFirst("/en/", "/om/");
//            fileLine = fileLine.replaceFirst("r1", "r112");
//            fileLine = fileLine.replaceFirst("lp-e", "lp-oa");
            if (fileLine.contains("\",\"")) {
                splitted = fileLine.split("\",\"");

                counter++;
                pages_2[counter] = fileLine;
                pages_2Links[counter] = splitted[0];
            } else {
                pages_2[counter] = pages_2[counter] + "\n" + fileLine;
            }
        }
        System.out.println("doneSecond");
        String temp = "";
        for (int i = 0; i < pages.length; i++) {
            if (pages[i] == null) {
                break;
            }
            for (int j = 0; j < pages_2.length; j++) {
                if (pagesLinks[i].equals(pages_2Links[j])) {
                    temp = pages[i];
                    pages[i] = pages[j];
                    pages[j] = temp;
                    break;
                }
            }
        }
        for (int i = 0; i < pages.length; i++) {
            if (pages[i] == null) {
                break;
            }
//            splitted = pages[i].split("\n");
//            splitted = splitted[0].split("\",\"");
//            if (splitted[1].toLowerCase().startsWith("table of contents")) {
//                continue;
//            } else {
                System.out.println(pages[i]);
//            }
            
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
