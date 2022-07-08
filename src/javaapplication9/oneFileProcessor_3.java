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
public class oneFileProcessor_3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        String fileLine = "";
        int counter = 1;
        int prevCounter = 1;
        int versePosition = 0;
        String history = "";
        String[] splitted = null;
        int tempCount = 0;
        boolean multiple = false;
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Tigrigna\\tigrignaOldBible_AllClean_2.csv"));

        while ((fileLine = br.readLine()) != null) {
            if (fileLine.contains("\",\"")) {
                counter = 1;
                continue;
            }
            if (!fileLine.contains(counter + "")) {
                history = history + " " + fileLine;
                continue;
            }
            while (history.startsWith(" ")) {
                history = history.substring(1);
            }
            while (history.endsWith(" ")) {
                history = history.substring(0, history.length() - 1);
            }

            while (customContains(fileLine, counter + "")) {
                history = history + " " + fileLine.substring(0, customIndex(fileLine, counter + ""));

//                history = history.replaceFirst(prevCounter + "", "");
                while (history.startsWith(" ")) {
                    history = history.substring(1);
                }
                while (history.endsWith(" ")) {
                    history = history.substring(0, history.length() - 1);
                }
                int endVerse = counter + 1;
                if (customContainsLeft(fileLine,counter+"-")) {
                    
                    endVerse = getEndVerse(counter,fileLine);
//                    System.out.println(counter+"-"+endVerse+ " : "+(endVerse-counter)+" : "+fileLine);
                    if(endVerse-counter>1){
                        for(int i=1; i<endVerse-counter; i++){
                            history = history+"\nEmpty";
                        }
                    }
                    multiple  = true;
                }else{
                    multiple = false;
                }
                System.out.println(history);
                history = "";
                fileLine = fileLine.substring(customIndex(fileLine, counter + ""));
                prevCounter = counter;
                counter = endVerse;
            }
            history = fileLine;

        }
    }
    public static int getEndVerse(int prevCounter, String fileLine){
        int beginIndex = customIndex(fileLine,prevCounter+"-");
        for(int i=beginIndex+(prevCounter+"-").length(); i<fileLine.length(); i++){
            if(isNumeric(fileLine.charAt(i)+"")){
                continue;
            }else{
//                System.out.println(fileLine.substring(beginIndex+(prevCounter+"-").length(),i));
                return Integer.parseInt(fileLine.substring(beginIndex+(prevCounter+"-").length(),i));
            }
        }
        return -1;
    }
    public static boolean customContainsLeft(String input, String target) {
        
        for (int i = 0; i < input.length() - target.length(); i++) {
            if (input.substring(i, i + target.length()).equals(target)) {

                if (i == 0) {
                    return true;
                }
                if (isNumeric(input.charAt(i - 1) + "")) {
                    continue;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean customContains(String input, String target) {
        if (target.length() >= 2) {
            return input.contains(target);
        }
        for (int i = 0; i < input.length() - target.length(); i++) {
            if (input.substring(i, i + target.length()).equals(target)) {

                if (i == 0 && !isNumeric(input.charAt(i + target.length()) + "")) {
                    return true;
                } else if (i == 0) {
                    return false;
                }
                if (i == input.length() && !isNumeric(input.charAt(i - 1) + "")) {
                    return true;
                } else if (i == input.length()) {
                    return false;
                }
                if (isNumeric(input.charAt(i - 1) + "") || isNumeric(input.charAt(i + target.length()) + "")) {
                    continue;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static int customIndex(String input, String target) {
        if (target.length() >= 2) {
            return input.indexOf(target);
        }
        for (int i = 0; i < input.length() - target.length(); i++) {
            if (input.substring(i, i + target.length()).equals(target)) {

                if (i == 0 && !isNumeric(input.charAt(i + target.length()) + "")) {
                    return i;
                }
                if (i == input.length() && !isNumeric(input.charAt(i - 1) + "")) {
                    return i;
                }
                if (isNumeric(input.charAt(i - 1) + "") || isNumeric(input.charAt(i + target.length()) + "")) {
                    continue;
                } else {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int countString(String input, String target) {
        int index = input.indexOf(target);
        int count = 0;
        while (index != -1) {
            count++;
            input = input.substring(index + 1);
            index = input.indexOf(target);
        }
        return count;
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
