/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import static javaapplication9.verbsMinimizer.myWriter;

/**
 *
 * @author Misgana
 */
public class wordReorder {
    public static void main(String[] args) throws Exception{
        String fileContent = "";
        myWriter = new FileWriter("C:\\Users\\Misgana\\Desktop\\Three\\theThreeProcessed2.txt", true);
        BufferedReader br = null;
        BufferedReader br2 = null;
        boolean done = false;
        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        String fileLine = "", fileLine2 = "";
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\Six\\theSixProcessedGerund.txt"));
            br2 = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\Six\\temp.txt"));
             while ((fileLine = br.readLine()) != null && (fileLine2 = br2.readLine()) != null) {
                 if(!fileLine.equals(fileLine2)){
                     out.println(fileLine2);
                 }
             }
        }catch(Exception e){
            
        }
    }
}
