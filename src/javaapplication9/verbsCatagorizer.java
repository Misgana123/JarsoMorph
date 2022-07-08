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
public class verbsCatagorizer {
    public static void main (String[] args) throws Exception{
        String fileLine = "";
        String[] ends = new String[10000];
        int[] endsCount = new int[10000];
        String[] splitted = null;
        int counter = 0;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\finalTemplateVerbs.txt"));
        
        while ((fileLine = br.readLine()) != null) {
            splitted = fileLine.split(" : ");
            counter++;
            for(int i=0; i<ends.length; i++){
                if(ends[i] == null){
//                    ends[i] = splitted[1].charAt(splitted[1].length()-1)+"";
                    ends[i] = splitted[1].substring(splitted[1].length()-2);
                    endsCount[i] = 1;
                    break;
                }if(splitted[1].endsWith(ends[i])){
                    endsCount[i] = endsCount[i]+1;
                    break;
                }
            }
            if(counter % 100000 == 0)
                System.out.println(counter);
        }
        for(int i=0; i<ends.length; i++){
            if(ends[i] == null){
                break;
            }else{
                System.out.println(ends[i]+ " : "+endsCount[i]);
            }
        }
    }
}
