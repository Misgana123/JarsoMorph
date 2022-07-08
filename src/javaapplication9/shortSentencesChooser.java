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
public class shortSentencesChooser {
    public static void main(String[] args) throws Exception{

        BufferedReader br = null;
        String fileLine = "";
        BufferedReader br2 = null;
        String fileLine2 = "";
        float counter = 0;
        String[] splitted = null;
        String[] splitted2 = null;
        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Videos\\nounsNet.txt"));
            br2 = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Videos\\nounsEnglish.txt"));
           
            String originalFileLine = "";
            while ((fileLine = br.readLine()) != null && (fileLine2 = br2.readLine()) != null) {
//                splitted = fileLine.split(" ");
//                splitted2 = fileLine2.split(" ");
//                if(splitted.length >7 || splitted2.length >7 || fileLine.equals("") || fileLine2.equals("")){
//                    continue;
//                }
                out.println(fileLine.replace("','',''", "','"+fileLine2+"',''"));
            }
            
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
