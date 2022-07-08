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
public class gerundWithout_tGenerator {
    public static void main(String[] args) throws Exception{
        BufferedReader br,br2 = null;
        String fileLine,fileLine2 = "";
        String[] splitted, splitted2 = null;
        
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\allGerundFormat.txt"));
        br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\allPastFormat.txt"));
        
            while ((fileLine = br.readLine()) != null && (fileLine2 = br2.readLine()) != null) {
                if(fileLine.endsWith("ት") && !fileLine2.endsWith("ተ")){
                    System.out.println(fileLine.substring(0,fileLine.length()-1));
                }else{
                    System.out.println(fileLine);
                }
            }
    }
}
