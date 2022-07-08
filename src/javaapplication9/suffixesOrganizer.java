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
public class suffixesOrganizer {
    public static void main(String[] args) throws Exception{
        myWriter = new FileWriter("C:\\Users\\Misgana\\Desktop\\One\\classOnePrefsuffixesNetOrganized.txt", true);
        BufferedReader br = null;
        int counter = 0;
        String[] splitted = null;
        String[][] suffixes = new String[45][];
        String[] theSuffixes = new String[5000];
        String[] theCount = new String[5000];
        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\One\\classOnePrefsuffixesNet.txt"));
            String fileLine = "";
            while ((fileLine = br.readLine()) != null) {
                suffixes[counter] = fileLine.split("__");
                counter++;
            }
            System.out.println("doneThree");
            for(int i=0; i<suffixes.length; i++){
                for(int j=0; j<suffixes[i].length; j++){
                    for(int k=0; k<theSuffixes.length; k++){
                        if(theSuffixes[k] == null){
                            theSuffixes[k] = suffixes[i][j];
                            theCount[k] = "-"+i+"-";
                            break;
                        }else if(theSuffixes[k].equals(suffixes[i][j]) && !theCount[k].contains("-"+i+"-")){
                            theCount[k] = theCount[k]+i+"-";
                            break;
                        }
                    }
                }
            }
            System.out.println("doneTwo");
            String[] temp = null;
            for(int k=0; k<theSuffixes.length; k++){
                if(theSuffixes[k] == null){
                    continue;
                }if(theSuffixes[k].equals("null")){
                    continue;
                }
                temp = theSuffixes[k].split("-");
//                out.println("(\"\",\""+temp[0]+"\",\""+temp[1]+"\",\""+theCount[k]+"\")");
                out.println("(\""+temp[0]+"\",\""+temp[1]+"\",\""+temp[2]+"\",\""+theCount[k]+"\")");
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
