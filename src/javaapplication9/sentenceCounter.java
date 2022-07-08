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
public class sentenceCounter {
    public static void main (String[] args) throws Exception{
        BufferedReader br,br2 = null;
        String fileLine,fileLine2 = "";
        String[] splitted, splitted2 = null;
        
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\parellel\\sampleAmharic3.txt"));
        br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\parellel\\sampleTigrigna3.txt"));
            
        while ((fileLine = br.readLine()) != null && (fileLine2 = br2.readLine()) != null) {
//             splitted = fileLine.split("\\።|\\?");
//             splitted2 = fileLine2.split("\\።|\\፧");
//             if(splitted.length == splitted2.length){
//                 for(int i=0; i<splitted.length; i++){
//                     System.out.println(splitted2[i]);
//                 }
//             }
            System.out.println(fileLine+"	"+fileLine2);
        }
    }
}
