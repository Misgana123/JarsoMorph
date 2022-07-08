/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

/**
 *
 * @author Misgana
 */
public class adjectivesExtractor {

    public static void main(String[] args) throws Exception {
        String fileLine = "";
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\NMSUAdjNouns.txt"));
        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        while ((fileLine = br.readLine()) != null) {

            if (fileLine.contains("፡")) {
                continue;
            }
            String[] splitted = fileLine.split("\t");
            if (splitted.length < 3) {
                out.println("");
            } else {
                out.println(splitted[2]);
            }
        }
    }
}
