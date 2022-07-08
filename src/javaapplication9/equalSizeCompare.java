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
public class equalSizeCompare {
    public static void main(String[] args) throws Exception{
        BufferedReader br,br2,br3 = null;
        String fileLine,fileLine2,fileLine3 = "";
        String[] splitted, splitted2 = null;
        int counter = 2;
        String temp = "1234567890";
        
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Tigrigna\\bibleAllFileSplitted_2.csv"));
        br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Amharic\\bibleAllFileSplitted_2.csv"));
        br3 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\allGerundFormat.txt"));
            while ((fileLine = br.readLine()) != null && (fileLine2 = br2.readLine()) != null) {
                
                splitted = fileLine.split(" ");
                splitted2 = fileLine2.split(" ");
                
                if(temp.contains(fileLine2.substring(0,1))){
                    fileLine2 = fileLine2.replaceFirst(splitted2[0]+" ", "");
                }
                System.out.println(fileLine2);
            }
    }
}
