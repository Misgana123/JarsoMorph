/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

/**
 *
 * @author worki
 */
public class conversationAlligner {

    public static void main(String[] args) throws Exception {
        String fileLine = "";
        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\all.txt"));
        while ((fileLine = br.readLine()) != null) {
            if(fileLine.startsWith("\"")){
                continue;
            }
            if(fileLine.endsWith("\"")){
                fileLine = fileLine.substring(1);
            }
            out.println(fileLine);
        }
    }
}
