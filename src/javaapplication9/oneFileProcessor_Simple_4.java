/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author worki
 */
public class oneFileProcessor_Simple_4 {

    static File myFile = new File("C:\\Users\\worki\\Desktop\\final\\temp5.txt");

    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        String fileLine = "";
        String[] splitted = null;
        int counter = 0;
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\finalTemplateVerbs.txt"));
        myFile.createNewFile();
        FileWriter myWriter = new FileWriter("C:\\Users\\worki\\Desktop\\final\\temp5.txt");
        while ((fileLine = br.readLine()) != null) {
            splitted = fileLine.split(" : ");
            fileLine = "";
            for (int i = 0; i < splitted.length; i++) {
                if (i == 0) {
                    fileLine = splitted[0];
                } else if (i == 1) {
                    fileLine = fileLine + "\",\"" + splitted[i].substring(2);
                } else {
                    fileLine = fileLine + "\",\"" + splitted[i];
                }
            }
            writeFile("(\"" + fileLine + "\"),\n", myWriter);
        }
        myWriter.close();
    }

    public static void writeFile(String string, FileWriter myWriter) throws Exception {
        myWriter.write(string);

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
