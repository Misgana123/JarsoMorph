package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class concatenateStrings {

    static FileWriter myWriter = null;

    public static void main(String[] args) throws Exception {
        String fileLine, fileLine2 = "";
        String[] splitted = null;
        String[] splitted2 = null;
        String temp = "";
        boolean done = false;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\oromifaEnglishParallelByLineBySentence.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\EnglishOromifaParallelByLineBySentence.txt"));
        myWriter = new FileWriter("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\oromifaEnglishParallelBySentence.txt", true);
        while ((fileLine = br.readLine()) != null && (fileLine2 = br2.readLine()) != null) {
//            if(fileLine.contains("\",\"")){
//                splitted = fileLine.split("\",\"");
//                fileLine = splitted[1];
//                splitted = fileLine2.split("\",\"");
//                fileLine2 = splitted[1];
//            }  
            write(fileLine + "	" + fileLine2,true);
        }
        myWriter.close();

    }
    public static void write(String line, boolean newLine) throws Exception {
        if (newLine) {
            myWriter.write("\n" + line);
        } else {
            myWriter.write(line);
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
