package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;

public class extractSampleVerbs {

    public static void main(String[] args) throws Exception {
        String fileLine, fileLine2, fileLine3, fileLine4 = "";
        String[] splitted = null;
        String[] splitted2 = null;
        String temp = "";
        boolean done = false;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\gerundToPastToPerceptionChangePattern.txt"));
        BufferedReader br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\allGerundFormatWithout_tNum.txt"));
        BufferedReader br3 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\allPastFormatNum.txt"));
        BufferedReader br4 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\allPastFormat.txt"));

        while ((fileLine = br.readLine()) != null) {
            done = false;
            splitted = fileLine.split(":");
            if (temp.contains("|" + splitted[0] + "|")) {

            } else {
                temp = temp + "|" + splitted[0] + "|";
                splitted2 = splitted[0].split("-");
                while ((fileLine2 = br2.readLine()) != null && (fileLine3 = br3.readLine()) != null
                        && (fileLine4 = br4.readLine()) != null) {
                    if (fileLine2.equals(splitted2[0]) && fileLine3.equals(splitted2[1])) {
                        System.out.println(splitted[0]);
                        done = true;
                        break;
                    }
                }
//                if(!done)
//                    System.out.println(fileLine);
                br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\allGerundFormatWithout_tNum.txt"));
                br3 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\allPastFormatNum.txt"));
                br4 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\allPastFormat.txt"));

            }

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
