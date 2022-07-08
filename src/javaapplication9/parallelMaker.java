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
public class parallelMaker {

    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        String fileLine = "";
        BufferedReader br2 = null;
        String fileLine2 = "";
        int counter = 2;
        String verse = "";
        boolean done = false;
        String[] splitted = null;
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Tigrigna\\JWlink_allFileNetFinalForAmharic.csv"));
        br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Amharic\\allFile.txt"));

        while ((fileLine = br.readLine()) != null) {
            done = false;
            if (fileLine.contains("\",\"")) {
                splitted = fileLine.split(",");
                while ((fileLine2 = br2.readLine()) != null) {
                    if(done && fileLine2.contains("\",\"")){
                        done = false;
                        break;
                    }
                    if (fileLine2.startsWith(splitted[0])) {
                        done = true;
                    }
                    if(done){
                        System.out.println(fileLine2);
                    }
                }
                
                br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Amharic\\allFile.txt"));
            }

        }

    }
}
