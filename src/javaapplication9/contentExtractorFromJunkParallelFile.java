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
public class contentExtractorFromJunkParallelFile {

    public static void main(String[] args) throws Exception {
        String fileLine, fileLine2 = "";
        String[] splitted = null;
        boolean cut = false;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Tigrigna\\TigrignaFiles\\en-ti.tmx_7\\en-ti.tmx_7"));

        while ((fileLine = br.readLine()) != null) {
            cut = false;
            if (fileLine.startsWith("      <tuv xml:lang=\"ti\">")) {
                fileLine = fileLine.substring(30, fileLine.indexOf("</seg></tuv>"));
//                splitted = fileLine.split("");
//                for (int i = 0; i < splitted.length; i++) {
//                    if (splitted[i].equals("(")) {
//                        cut = true;
//                    } else if (splitted[i].equals(")")) {
//                        cut = false;
//                        continue;
//                    }
//                    if (!cut) {
//                        System.out.print(splitted[i]);
//                    }
//                }
                System.out.println(fileLine);
//                System.out.println(fileLine.substring(30, fileLine.indexOf("</seg></tuv>")));
            }
        }
    }
}
