/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;

/**
 *
 * @author worki
 */
public class filesMerger {
    static String amharicLetters = "ኧሁሂሃሄህሆኋለሉሊላሌልሎሏሐሑሒሓሔሕሖኋመሙሚማሜምሞሟሠሡሢሣሤሥሧሷረሩሪራሬርሮሯሰሱሲሳሴስሶሷሸሹሺሻሼሽሾሿቀቁቂቃቄቅቆቋበቡቢባቤብቦቧተቱቲታቴትቶቷ" +
                 "ቸቹቺቻቼችቾቿኀኁኂኃኄኅኆኋነኑኒናኔንኖኗኘኙኚኛኜኝኞኟአኡኢኣኤእኦኣከኩኪካኬክኮኳኸኹኺኻኼኽኾኋወዉዊዋዌውዎዏዐዑዒዓዔዕዖዓዘዙዚዛ" +
                    "ዜዝዞዟዠዡዢዣዤዥዦዧየዩዪያዬይዮያገጉጊጋጌግጎጓጠጡጢጣጤጥጦጧጨጩጪጫጬጭጮጯደዱዲዳዴድዶዷጀጁጂጃጄጅጆጇጰጱጲጳጴጵጶጷጸጹጺጻጼጽጾጿፀፁፂፃፄፅፆጿፈፉፊፋፌፍፎፏፐፑፒፓፔፕፖፗቨቩቪቫቬቭቮቯ";
    public static void main (String[] args) throws Exception{
        BufferedReader br,br2,br3 = null;
        String fileLine,fileLine2,fileLine3 = "";
        String[] replacers = {"ሲያ","ስና", "ስታ", "ስን", "ስት", "ሲ","ሳያ", "ሳላ", "ሳና", "ሳታ", "ሳን", "ሳት", "ሳል", "ሳይ"};
        String all = "";
        File myFile = new File("C:\\Users\\worki\\Music\\all\\allFromOCR.txt");
                    myFile.createNewFile();
        for(int i=0; i<182; i++){
            all = "";
            br = new BufferedReader(new FileReader("C:\\Users\\worki\\Music\\all\\"+(i+1)+".txt"));
            while ((fileLine = br.readLine()) != null) {
                all = all +"\n"+ fileLine;
            }
            all = all+"\n_____________________________";
            FileWriter myWriter = new FileWriter("C:\\Users\\worki\\Music\\all\\allFromOCR.txt", true);
                    myWriter.write(all);
                    myWriter.close();
            System.out.println(i);
            
                    
        }
        
                    
    }
    public static int getLastLetterBegginingPosition(String word) {
        int x;
        x = (amharicLetters.indexOf(word.charAt(word.length() - 1)) % 8);
        return x;
    }
    
}
