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
public class oneFileProcessor_Simple_3 {

    static String amharicLetters = "ኧሁሂሃሄህሆኋለሉሊላሌልሎሏሐሑሒሓሔሕሖኋመሙሚማሜምሞሟሰሱሲሳሴስሶሷሠሡሢሣሤሥሧሷረሩሪራሬርሮሯሸሹሺሻሼሽሾሿቀቁቂቃቄቅቆቋበቡቢባቤብቦቧተቱቲታቴትቶቷ"
            + "ቸቹቺቻቼችቾቿኀኁኂኃኄኅኆኋነኑኒናኔንኖኗኘኙኚኛኜኝኞኟአኡኢኣኤእኦኣከኩኪካኬክኮኳኸኹኺኻኼኽኾኋወዉዊዋዌውዎዏዐዑዒዓዔዕዖዓዘዙዚዛ"
            + "ዜዝዞዟዠዡዢዣዤዥዦዧየዩዪያዬይዮያገጉጊጋጌግጎጓጠጡጢጣጤጥጦጧጨጩጪጫጬጭጮጯደዱዲዳዴድዶዷጀጁጂጃጄጅጆጇጰጱጲጳጴጵጶጷፀፁፂፃፄፅፆጿጸጹጺጻጼጽጾጿፈፉፊፋፌፍፎፏፐፑፒፓፔፕፖፗቨቩቪቫቬቭቮቯ";

    public static void main(String[] args) throws Exception {
        BufferedReader br = null;
        String fileLine = "";
        String[] splitted = null;
        boolean done = false;
        int counter = 0;
        int lastCounter1 = 0, larstcounter2 = 0;
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Downloads\\Compressed"
                + "\\amharicParallelData\\data-master_2\\data-master\\amharic\\parallel"
                + "\\nmsu-say\\amharic-english\\newspapers\\newsAll.txt"));

        while ((fileLine = br.readLine()) != null) {
            done = false;
            splitted = fileLine.split("");
            lastCounter1++;
            for (int i = 0; i < splitted.length; i++) {
//                if (amharicLetters.contains(splitted[i])) {
                if(counter%2 == 1){
                    while(fileLine.startsWith(" ")){
                        fileLine = fileLine.substring(1);
                    }
                    System.out.println(fileLine);
                    done = true;
                    break;
                }

            }
            if (!done) {
                
            }
            counter++;
        }

    }

}
