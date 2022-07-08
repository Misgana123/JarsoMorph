/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

/**
 *
 * @author worki
 */
public class conversationOrdering {

    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        String fileLine = "";
        String conversation = "";
        int counter = 0;
        String temp = "";
        boolean ignore = true;
        boolean first = false;
        boolean last = false;

        br = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\kiburMinisterAllFileWithoutLink.txt"));
        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        while ((fileLine = br.readLine()) != null) {
            String[] splitted = fileLine.split("");
            if (fileLine.contains("\"")) {
                for (int i = 0; i < splitted.length; i++) {
                    if (splitted[i].equals("\"")) {
                        counter++;
                        if (counter % 4 == 3) {
                            ignore = false;
                            first = true;
                            break;
                        }
                        if (counter % 4 == 0) {
                            ignore = true;
                            last = true;
                            break;
                        }
                    }
                }
            }
            fileLine = fileLine.replace("\"", "");
            if (!ignore) {
                if (first) {
//                        System.out.println(fileLine.substring(fileLine.indexOf(",")+1));
                    first = false;
                } else {
                    out.println(fileLine);
                }
            }
            if (last) {
                out.println(fileLine);
                last = false;
            }
        }
    }

}
