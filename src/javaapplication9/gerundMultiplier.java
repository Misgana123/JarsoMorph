package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;
import static javaapplication9.JavaApplication9.amharicLetters;

public class gerundMultiplier {
    static BufferedReader br = null;
    static String fileLine = "";
    public static void main(String[] args) throws Exception{
        
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\allGerundFormat.txt"));
        
        while ((fileLine = br.readLine()) != null) {
            if(fileLine.startsWith("መ")){
                
                if(getLastLetterBegginingPosition(fileLine.charAt(1)+"") == 5){
//                    fileLine = "ማስ" + justChangeLetter(fileLine.charAt(1),0) + fileLine.substring(2);
                }else{
//                    fileLine = fileLine.replaceFirst("መ", "ማስ");
                    fileLine = "ማ" + fileLine.substring(1);
                    System.out.println(fileLine);
                }
//                System.out.println(fileLine);
            }
        }
        
    }
    public static int getLastLetterBegginingPosition(String word) {
        int x;
        x = (amharicLetters.indexOf(word.charAt(word.length() - 1)) % 8);
        return x;
    }
    public static char justChangeLetter(char theChar, int to) {
        int x = amharicLetters.indexOf(theChar) - amharicLetters.indexOf(theChar) % 8;
        char toBeReturned = amharicLetters.charAt(x + to);
        if (x == 0 && to == 0) {
            toBeReturned = 'ኸ';
        }
        return toBeReturned;
    }
}
