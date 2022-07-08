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
public class suffixRepresentation {

    public static void main(String[] args) throws Exception{
        myWriter = new FileWriter("C:\\Users\\Misgana\\Desktop\\One\\classOneSuffixesRepresentation.txt", true);
        BufferedReader br = null;
        BufferedReader br2 = null;
        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\One\\classOnePrefsuffixesNet.txt"));
            br2 = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\One\\classOnePrefsuffixes.txt"));

            String fileLine = "";
            String[] suffixReps = new String[335];
            int counter =0;
            while ((fileLine = br.readLine()) != null) {
                suffixReps[counter] = fileLine;
                counter++;
            }
            while ((fileLine = br2.readLine()) != null) {
                for(int i=0; i<suffixReps.length; i++){
                    if(fileLine.equals(suffixReps[i])){
                        myWriter.write(i+"\n");
                        break;
                    }
                }
            }
            myWriter.close();
            br.close();
            br2.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
