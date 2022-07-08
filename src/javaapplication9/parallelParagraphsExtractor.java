
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class parallelParagraphsExtractor {
    static String fileLine = "";
    static BufferedReader br = null;
    static FileWriter myWriter;
    public static void main(String[] args) throws Exception{
        myWriter = new FileWriter("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\amharicEngParallelByParagraphOnlyParallelEng.txt", true);
        String[] splitted = null, splitted2 = null, splitted3 = null, splitted4 = null;
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\English\\files\\amharicEngParallelByParagraph.txt"));
        while ((fileLine = br.readLine()) != null) {
            if(fileLine.equals("")){
             continue;   
            }
            splitted = fileLine.split(" ___ ");
            splitted2 = splitted[0].split(" : ");
            splitted4 = splitted[1].split(" : ");
            splitted3 = splitted2[1].split(" - ");
            
            if(Integer.parseInt(splitted3[0]) == Integer.parseInt(splitted3[1])){
                write("_______--_______"+splitted4[1],true);
            }
            
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
}
