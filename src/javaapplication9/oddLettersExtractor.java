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

public class oddLettersExtractor {
    static String amharicLetters = "ኧሁሂሃሄህሆኋለሉሊላሌልሎሏሐሑሒሓሔሕሖኋመሙሚማሜምሞሟሰሱሲሳሴስሶሷሠሡሢሣሤሥሧሷረሩሪራሬርሮሯሸሹሺሻሼሽሾሿቀቁቂቃቄቅቆቋበቡቢባቤብቦቧተቱቲታቴትቶቷ"
            + "ቸቹቺቻቼችቾቿኀኁኂኃኄኅኆኋነኑኒናኔንኖኗኘኙኚኛኜኝኞኟአኡኢኣኤእኦኣከኩኪካኬክኮኳኸኹኺኻኼኽኾኋወዉዊዋዌውዎዏዐዑዒዓዔዕዖዓዘዙዚዛ"
            + "ዜዝዞዟዠዡዢዣዤዥዦዧየዩዪያዬይዮያገጉጊጋጌግጎጓጠጡጢጣጤጥጦጧጨጩጪጫጬጭጮጯደዱዲዳዴድዶዷጀጁጂጃጄጅጆጇጰጱጲጳጴጵጶጷፀፁፂፃፄፅፆጿጸጹጺጻጼጽጾጿፈፉፊፋፌፍፎፏፐፑፒፓፔፕፖፗቨቩቪቫቬቭቮቯ";
    public static void main(String[] args) throws Exception{
        String fileLine = "";
        String[] splitted = null;
        String temp = "";
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\theDictionary.txt"));

        while ((fileLine = br.readLine()) != null) {
            splitted = fileLine.split("");
            for(int i=0; i<splitted.length; i++){
                if(!temp.contains(splitted[i]) && !amharicLetters.contains(splitted[i])){
                    System.out.println(splitted[i]);
                    temp = temp + splitted[i];
                }
            }
            
        }
    }
}
