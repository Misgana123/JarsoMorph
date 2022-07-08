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
public class sqlQueryConcatinator {

    public static void main(String[] args) throws Exception{
        myWriter = new FileWriter("C:\\Users\\Misgana\\Desktop\\Six\\sixSqlQuery.txt", true);
        BufferedReader br = null;
        BufferedReader br2 = null;
        BufferedReader br3 = null;
        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\Six\\classSixStems.txt"));
            br2 = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\Six\\classSixStemsGerund.txt"));
            br3 = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\Six\\classSixSuffixesRepresentation.txt"));

            String fileLine = "",fileLine2 = "", fileLine3 = "";
            int counter =0;
            String query = "insert into verbs values ";
            while ((fileLine = br.readLine()) != null && (fileLine2 = br2.readLine()) != null 
                    && (fileLine3 = br3.readLine()) != null) {
                query = query + "(\""+fileLine+"\",\""+fileLine2+"\",4,"+fileLine3+"),\n";
            }
            myWriter.write(query);
            myWriter.close();
            br.close();
            br2.close();
            br3.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
