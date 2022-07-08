/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;

/**
 *
 * @author worki
 */
public class OneFileProcessor2 {

    static FileWriter myWriter = null;
    static String[] vowels = {"a", "e", "i", "o", "u"};
    static String amharicLetters = "ኧሁሂሃሄህሆኋለሉሊላሌልሎሏሐሑሒሓሔሕሖኋመሙሚማሜምሞሟሠሡሢሣሤሥሦሧረሩሪራሬርሮሯሰሱሲሳሴስሶሷሸሹሺሻሼሽሾሿቀቁቂቃቄቅቆቋበቡቢባቤብቦቧተቱቲታቴትቶቷ"
            + "ቸቹቺቻቼችቾቿኀኁኂኃኄኅኆኋነኑኒናኔንኖኗኘኙኚኛኜኝኞኟአኡኢኣኤእኦኣከኩኪካኬክኮኳኸኹኺኻኼኽኾኋወዉዊዋዌውዎዏዐዑዒዓዔዕዖዓዘዙዚዛ"
            + "ዜዝዞዟዠዡዢዣዤዥዦዧየዩዪያዬይዮያገጉጊጋጌግጎጓጠጡጢጣጤጥጦጧጨጩጪጫጬጭጮጯደዱዲዳዴድዶዷጀጁጂጃጄጅጆጇጰጱጲጳጴጵጶጷጸጹጺጻጼጽጾጿፀፁፂፃፄፅፆጿፈፉፊፋፌፍፎፏፐፑፒፓፔፕፖፗቨቩቪቫቬቭቮቯ";
    

    public static boolean containsVowel(String txt) {
        for (int i = 0; i < vowels.length; i++) {
            if (txt.contains(vowels[i])) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        String fileLine = "";
        BufferedReader br2 = null;
        String fileLine2 = "";
        String[] splitted = null;
        int length = 0;
        PrintStream out = new PrintStream(System.out, true, "UTF-8");
        br = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\final\\newGenderFormat.txt"));
        br2 = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\final\\newGenderFormat.txt"));
        myWriter = new FileWriter("C:\\Users\\Misgana\\Desktop\\Three\\theThreeProcessedGerund.txt", true);

        while ((fileLine = br.readLine()) != null && (fileLine2 = br2.readLine()) != null) {
//            if(fileLine.startsWith("እ0")){
//                fileLine = "3"+fileLine.substring(2);
//            }
//            myWriter.write("\n"+fileLine);
//            if (!(!fileLine.startsWith("እ") && !fileLine.startsWith("ት") && !fileLine.startsWith("ይ")
//                    && !isNumeric(fileLine.charAt(1)+""))) {
//                myWriter.write("\n"+fileLine2);
//            }

//            if (!fileLine.startsWith("ያ")) {
                out.println(fileLine.substring(0,fileLine.length()-1)+justChangeLetter(fileLine.charAt(fileLine.length()-1),3));
//            }
//                  else{
//                  out.println(fileLine2);
//              }
//            String temp = "";
//            if (fileLine.startsWith("_______--_______")) {
//                write("\n_______--_______", false);
//                fileLine = fileLine.replaceFirst("_______--_______", "");
//            }
//
//            splitted = fileLine.split("\\.");
//            for (int i = 0; i < splitted.length; i++) {
//                if (!(splitted[i].equals("") || splitted[i].equals(" "))) {
//                    if (splitted[i].length() < 5 || !splitted[i].contains(" ") 
//                            || !containsVowel(splitted[i])) {
//                        if (i != splitted.length - 1) {
//                            write(splitted[i] + ".", false);
//                        } else {
//                            write(splitted[i], false);
//                        }
//
//                    } else {
//                        if (i != splitted.length - 1) {
//                            write(splitted[i] + ".", true);
//                        } else {
//                            write(splitted[i], true);
//                        }
//                    }
//                }
//            }
//            splitted = fileLine.split("\t");
//            while(fileLine.startsWith(" ")){
//                fileLine = fileLine.substring(1);
//            }while(fileLine.endsWith(" ")){
//                fileLine = fileLine.substring(0,fileLine.length()-1);
//            }
//            System.out.println(cleanWords(fileLine));
//            if(splitted[0].contains("a")||splitted[0].contains("e")||
//                    splitted[0].contains("i")||splitted[0].contains("o")||splitted[0].contains("u")){
//                
//            }else if(splitted[0].length() > 5 && (splitted[0].contains("1") || splitted[0].contains("2")
//                    ||splitted[0].contains("0") || splitted[0].contains("9"))){
//                
//            }else if(fileLine.contains("⁠")){
//                
//            }
//            else{
//                System.out.println(fileLine);
//            }
//            while(splitted[1].startsWith(" ")){
//                splitted[1] = splitted[1].substring(1);
//            }while (splitted[1].endsWith(" ")){
//                splitted[1] = splitted[1].substring(0,splitted[1].length()-1);
//            }
//            for (int i = 0; i < splitted.length; i++) {
//                if (splitted[i].contains("/wal/")) {
//                    System.out.println(splitted[i]);
//                }
//            }
        }
        myWriter.close();
    }

    public static void write(String line, boolean newLine) throws Exception {
        if (newLine) {
            myWriter.write(line + "\n");
        } else {
            myWriter.write(line);
        }

    }

    public static String cleanWords(String string) {

        String[] toBeReplaced = {"?", "።", "!", "]", "[", ":", ".", "_", "-", "፡", "፣", "፤", "\"", "#", "$", "&", "*", "@", "+", ",", "—", "“", "”",
            "(", ")", "<", ">", "|", "/", "{", "}", ";", "`", "~", "%", "^", "=", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "   ", "  ", "  "};
        for (int i = 0; i < toBeReplaced.length; i++) {
            string = string.replace(toBeReplaced[i], " ");
        }
//            String[] splitted = string.split(" ");
//            for(int i=0; i<splitted.length; i++){
//                if(splitted[i].contains("a") || splitted[i].contains("e") || splitted[i].contains("i")
//                        ||splitted[i].contains("o") || splitted[i].contains("u")){
//                    string = string.replace(splitted[i], "");
//                }
//            }
        string = string.replace("  ", " ");
        string = string.replace("  ", " ");
        return string;
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
