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
public class parallelErrorCheck {
    public static void main(String[] args) throws Exception{
        BufferedReader br,br2 = null;
        String fileLine,fileLine2 = "";
        String[] splitted, splitted2 = null;
        String[] mainSplit = null;
        int counter = 0;
        
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\Oro-EngParallelByLine.txt"));
            while ((fileLine = br.readLine()) != null) {
                mainSplit = fileLine.split("	");
                splitted = mainSplit[0].split("\\.");
                splitted2 = mainSplit[1].split("\\.");
                if(splitted.length == splitted2.length){
                    for(int i=0; i<splitted.length; i++){
                        System.out.println(splitted[i]+"	"+splitted2[i]);
                    }
                }
            }
    } 
}
