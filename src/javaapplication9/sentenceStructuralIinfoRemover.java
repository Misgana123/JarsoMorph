/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author worki
 */
public class sentenceStructuralIinfoRemover {
    public static String[] toBeReplaced = {"ሐ","ሑ","ሒ","ሓ","ሔ","ሕ","ሖ","ኋ","ኀ","ኁ","ኂ","ኃ","ኄ","ኅ","ኆ","ኋ",
        "ኸ","ኹ","ኺ","ኻ","ኼ","ኽ","ኾ","ኋ","ጸ","ጹ","ጺ","ጻ","ጼ","ጽ","ጾ","ሠ","ሡ","ሢ","ሣ","ሤ","ሥ","ሦ",
        "ዐ","ዑ","ዒ","ዓ","ዔ","ዕ","ዖ","ኣ"};
        public static String[] replacer ={"ሀ","ሁ","ሂ","ሃ","ሄ","ህ","ሆ","ኋ","ሀ","ሁ","ሂ","ሃ","ሄ","ህ","ሆ","ኋ",
        "ኸ","ሁ","ሂ","ሃ","ሄ","ህ","ሆ","ኋ","ፀ","ፁ","ፂ","ፃ","ፄ","ፅ","ፆ","ሰ","ሱ","ሲ","ሳ","ሴ","ስ","ሶ",
        "አ","ኡ","ኢ","አ","ኤ","እ","ኦ","አ"};
    public static void main(String[] args) throws Exception {
        String fileLine, fileLine2, Line = "";
        String[] splitted, splitted2 = null;
        int notDoneCounter = 0, nounCounter = 0, verbCounter = 0, totalCount = 0;
        String[] notDone = new String[56150], noun = new String[119224], verb = new String[174692];
        String[] nounOriginal = new String[119224], verbOriginal = new String[174692];
        boolean done = false;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\eng-amharicParallelByLineBySentence_3Amharic.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\onAllComputerProcessed.txt"));
        
        while ((fileLine2 = br2.readLine()) != null) {
                    splitted2 = fileLine2.split(" : ");
                        if(splitted2[0].equals("notDone") || splitted2[0].equals("notdone")){
                            notDone[notDoneCounter] = splitted2[1];
                            notDoneCounter++;
                        }else if (splitted2[1].equals("Verb")) {
                            verb[verbCounter] = splitted2[3];
                            verbOriginal[verbCounter] = splitted2[2];
                           verbCounter++;
                        } else {
                            noun[nounCounter] = splitted2[5];
                            nounOriginal[nounCounter] = splitted2[4];
                            nounCounter++;
                        }
                        totalCount++;
                        if(totalCount % 10000 == 0)
                            System.out.println(totalCount);
                }
                System.out.println("theCount: "+notDoneCounter+" : "+verbCounter+" : "+nounCounter);
        
        while ((fileLine = br.readLine()) != null) {
            fileLine = cleanWords(fileLine);
            fileLine = normalizeText(fileLine);
            splitted = fileLine.split(" ");
            Line = "";
            done = true;
            for (int i = 0; i < splitted.length; i++) {
                for(int j=0; j<notDone.length; j++){
                    if(notDone[j].equals(splitted[i])){
                        if(Line.equals("")){
                            Line = splitted[i];
                        }else{
                            Line = Line + " " + splitted[i];
                        }
                        break;
                    }else if(nounOriginal[j].equals(splitted[i])){
                        if(Line.equals("")){
                            Line = noun[j];
                        }else{
                            Line = Line + " " + noun[j];
                        }
                        break;
                    }else if(verbOriginal[j].equals(splitted[i])){
                        if(Line.equals("")){
                            Line = verb[j];
                        }else{
                            Line = Line + " " + verb[j];
                        }
                        break;
                    }
                }
            }
//            Line = Line.replace("Pure", "");
//            Line = Line.replace("  ", " ");
//            Line = Line.replace("  ", " ");
//            Line = Line.replace("--", "-");
//            Line = Line.replace("@-","@");
//            Line = Line.replace("-@", "@");
//            Line = Line.replace(" @@ ", " ");
//            Line = Line.replace(" @@", "");
            
            if(Line.startsWith(" ")){
                Line = Line.substring(1);
            }
            if(Line.endsWith(" ")){
                Line = Line.substring(0,Line.length()-1);
            }
            if(done)
                System.out.println(Line);
            else
                System.out.println("confusing!");

        }
    }
    public static String cleanWords(String string) {

        String[] toBeReplaced = {"?", "።", "!", "]", "[", ":", ".", "_", "-", "፡", "፣", "፤", "\"", "#", "$", "&", "*", "@", "+", ",", "—", "“", "”",
            "(", ")", "<", ">", "|", "/", "{", "}", ";", "`", "~", "%", "^", "=", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "   ", "  ", "  "};
            
        for (int i = 0; i < toBeReplaced.length; i++) {
            string = string.replace(toBeReplaced[i], " ");
        }
        string = string.replace("  ", " ");
        return string;
    }
    public static String normalizeText(String fileLine){
        
               for(int j=0; j<toBeReplaced.length; j++){
                    fileLine = fileLine.replace(toBeReplaced[j], replacer[j]);
               }
               return fileLine;
    }
}
