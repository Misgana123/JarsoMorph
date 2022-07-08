/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author worki
 */
public class writeFile {
    public static void main (String[] args) throws Exception{
        BufferedReader br = null;
        String fileLine = "";
        String netWords = "urls\n";
        int counter = 0;
        int counter2 = 0;
        
            br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Somali\\JWlinks.csv"));

            while ((fileLine = br.readLine()) != null) {
                counter++;
                if(counter==198){
                    counter2++;
                    counter = 0;
                    netWords = netWords + fileLine;
                    File myFile = new File("C:\\Users\\worki\\Desktop\\JWlinks\\Somali\\JWlink_"+counter2+".csv");
                    myFile.createNewFile();
                    FileWriter myWriter = new FileWriter("C:\\Users\\worki\\Desktop\\JWlinks\\Somali\\JWlink_"+counter2+".csv");
                    System.out.println("JWlink_"+counter2+".csv");
                    myWriter.write(netWords);
                    myWriter.close();
                    netWords = "urls\n";
                }
                netWords = netWords + fileLine +"\n";
            }
    }
}
