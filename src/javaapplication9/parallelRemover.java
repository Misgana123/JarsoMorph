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
public class parallelRemover {

    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        String fileLine = "";
        BufferedReader br2 = null;
        String fileLine2 = "";
        int counter = 2;
        String verse = "";
        boolean done = false;
        String[] splitted = null;
        boolean ignore = false;
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Tigrigna\\JWlink_allFileNetFinalForAmharic.csv"));
        br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\temp6.txt"));

        while ((fileLine = br.readLine()) != null) {
            done = false;
            if (fileLine.contains("\",\"")) {
                splitted = fileLine.split(",");
                while ((fileLine2 = br2.readLine()) != null) {
                    if(fileLine2.equals(splitted[0])){
                        ignore = true;
                        break;
                    }
                    ignore = false;
                }
                
                br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\temp6.txt"));
            }
            if(!ignore){
                System.out.println(fileLine);
            }

        }

    }
}
