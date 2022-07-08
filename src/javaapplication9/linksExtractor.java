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
public class linksExtractor {
    
    public static void main (String[] args) throws Exception{
        BufferedReader br = null;
        String fileLine = "";
        String netWords = "";
        
            br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\ethioReporter\\ethioReporterKiburMinisterLinks.csv"));

            while ((fileLine = br.readLine()) != null) {
                fileLine = fileLine.substring(fileLine.indexOf(",")+1);
                System.out.println(fileLine);
            }
    }
    
}
