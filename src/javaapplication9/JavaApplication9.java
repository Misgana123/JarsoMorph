/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author worki
 */
public class JavaApplication9 {

    static String amharicLetters = "ኧሁሂሃሄህሆኋለሉሊላሌልሎሏሐሑሒሓሔሕሖኋመሙሚማሜምሞሟሠሡሢሣሤሥሧሷረሩሪራሬርሮሯሰሱሲሳሴስሶሷሸሹሺሻሼሽሾሿቀቁቂቃቄቅቆቋበቡቢባቤብቦቧተቱቲታቴትቶቷ"
            + "ቸቹቺቻቼችቾቿኀኁኂኃኄኅኆኋነኑኒናኔንኖኗኘኙኚኛኜኝኞኟአኡኢኣኤእኦኣከኩኪካኬክኮኳኸኹኺኻኼኽኾኋወዉዊዋዌውዎዏዐዑዒዓዔዕዖዓዘዙዚዛ"
            + "ዜዝዞዟዠዡዢዣዤዥዦዧየዩዪያዬይዮያገጉጊጋጌግጎጓጠጡጢጣጤጥጦጧጨጩጪጫጬጭጮጯደዱዲዳዴድዶዷጀጁጂጃጄጅጆጇጰጱጲጳጴጵጶጷጸጹጺጻጼጽጾጿፀፁፂፃፄፅፆጿፈፉፊፋፌፍፎፏፐፑፒፓፔፕፖፗቨቩቪቫቬቭቮቯ";

    public static void main(String[] args) throws Exception {
        BufferedReader br, br2, br3 = null;
        String fileLine, fileLine2, fileLine3 = "";
        String[] replacers = {"የሚያ", "የምና", "የምታ", "የምን", "የምት", "የሚ", "የማያ", "የማላ", "የማና", "የማታ", "የማን", "የማት", "የማል", "የማይ"};
        String netWords = "";
        int counter = 0;
        String all = "";
        String[] splitted = null;
        String[] splitted2 = null;
        String[] links = new String[9432];
        String notNeeded = "";
        String backMemory = "";
        String temp = "";
        String[] theLinks = new String[9182];
        String[] contents = new String[9182];

//            br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\JWlinks\\Tigrigna\\JWlink_allFileNotNetParellelByLine.csv"));
        br2 = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\JWlinks\\English\\files\\amharicEngForEngNoDuplicaate2_WithoutError_Eng.txt"));
//            br3 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\allGerundFormat.txt"));
//            while ((fileLine = br.readLine()) != null) {
//                if(fileLine.startsWith("\"https://wol.jw.org/")){
//                    splitted = fileLine.split(",");
//                    if(backMemory.equals("")){
//                        theLinks[0] = backMemory;
//                        contents[0] = netWords;
//                        counter++;
//                    }else{
//                        theLinks[counter] = backMemory;
//                        contents[counter] = netWords;
//                        counter++;
//                    }
//                    backMemory = splitted[0];
////                    if(!netWords.contains(notNeeded))
////                        System.out.println(netWords);
//                    netWords = "";
//                    netWords = fileLine;
//                    
//                }else{
//                    netWords = netWords+"\n"+fileLine;
//                }
//            }
        counter = 0;
        backMemory = "";
        FileWriter myWriter = new FileWriter("C:\\Users\\Misgana\\Desktop\\JWlinks\\English\\files\\amharicEngForEngNoDuplicaate2_WithoutError_Eng2.txt", true);
        while ((fileLine = br2.readLine()) != null) {
//                if(fileLine.startsWith("\"https://wol.jw.org/")){
            counter++;
//                    System.out.println(counter);
//                }
            if (fileLine.equals("_______________________________")) {
                myWriter.write("\n" + fileLine);
                continue;
            }
            splitted = fileLine.split("\\.");
            for (int i = 0; i < splitted.length; i++) {
//                if (splitted[i].contains(" ")) {
                    if (i == splitted.length - 1) {
                        if(splitted.length==1){
                            myWriter.write("\n" + splitted[i]+splitted.length+" : "+i+" : One");
                        }
                        else if (splitted[i].contains(" ")) {
                            myWriter.write("\n" + splitted[i]+splitted.length+" : "+i+" : Two");
                        }else{
                            myWriter.write(splitted[i]+splitted.length+" : "+i+" : Three");
                        }
                        
                    } else {
                        if (splitted[i + 1].contains(" ") && (splitted[i].length() > 5 
                                || splitted[i].equals(""))) {
                            myWriter.write("\n" + splitted[i] + "."+splitted.length+" : "+i+" : Four");
                        } else {
                            myWriter.write(splitted[i] + "."+splitted.length+" : "+i+" : Five"); 
                        }
                    }
//                } else {
//                    if (i == splitted.length - 1) {
//                        myWriter.write("\n" + splitted[i]);
//                    } else {
//                        myWriter.write("\n" + splitted[i] + ".");
//                    }
//                }
            }
//                if(splitted.length > 1){
//                    splitted2 = splitted[1].split(" : ");
////                    System.out.println(splitted[0]+" : "+splitted[1]);
//                    myWriter.write(splitted2[0]+"\n");
//                    if(counter%100 == 0){
//                        System.out.println(counter);
//                    }
//                }
////                    fileLine = fileLine.replace("am", "ti");
////                    fileLine = fileLine.replace("r93", "r119");
//                    splitted = fileLine.split(",");
////                    for(int i=0; i<links.length; i++){
////                        if(links[i].equals(backMemory)){
////                            System.out.println(netWords);
////                            break;
////                        }
////                    }
////                    if(!temp.contains("|"+backMemory+"|")){
////                    String[] tempor = netWords.split("።");
////                    String[] tempor2 = contents[counter].split("።");
//                    
////                    System.out.println(backMemory+" : "+theLinks[counter]);
////                    if(tempor.length == tempor2.length){
////                        System.out.println(netWords);
////                    }
////                    if(counter-1 >=0 && !backMemory.equals(theLinks[counter]))
////                        System.out.println(backMemory);
////                    }
////                    else
////                        System.out.println(backMemory);
////                    System.out.println(splitted[0]);
//                    if(temp.contains("|"+backMemory+"|")){
//                        System.out.println(netWords);
//                    }
//                    temp = temp+"|"+backMemory+"|";
//                    backMemory = splitted[0];
////                    if(!netWords.contains(notNeeded))
////                        System.out.println(netWords);
//                    
//                    netWords = "";
//                    netWords = fileLine;
//                    counter++;
//                    
//                }else{
//                    netWords = netWords+"\n"+fileLine;
//                }

//                if(fileLine.startsWith("\"https://wol.jw.org/")){
//                    splitted = fileLine.split("\",\"");
//                    System.out.println(splitted[0]+"\"");
//                }
//                else{
//                    System.out.println(fileLine);
//                }
//                splitted = fileLine.split("	");
//                if(splitted.length != 2)
//                    System.out.println(fileLine);
//                if(fileLine.startsWith("ሲያ")){
//                    fileLine = "አ"+fileLine.substring(2);
//                }else{
//                    fileLine = fileLine.substring(1);
//                }
//                fileLine = fileLine.substring(0,fileLine.length()-1) + 
//                        justChangeLetter(fileLine.charAt(fileLine.length()-1),6);
//                System.out.println(fileLine);
//                splitted = fileLine.split("\",\"");
//                System.out.println(splitted[1]);
//                if(!fileLine.endsWith("ን")){
//                    System.out.println(fileLine);
//                }
//                else{
//                    System.out.println(fileLine);
//                }
//                String[] splitted = fileLine2.split("");
//                for(int i=2; i<splitted.length; i++){
//                    
//                        if(splitted.length > 2 && getLastLetterBegginingPosition(splitted[i])==5){
////                            System.out.println(fileLine.replace(splitted[i]+splitted[i-1], splitted[i]));
//                            System.out.println(fileLine2);
//                        }
//                    
//                }
//                for(int i=0; i<replacers.length; i++){
//                    if(fileLine.startsWith(replacers[i])){
//                        if(fileLine.endsWith("ና")){
//                            fileLine = fileLine.substring(0,fileLine.length()-1);
//                        }
//                        System.out.println(fileLine);
//                        break;
//                    }
//                }
//                if(!fileLine.contains("-")){
//                    System.out.println(fileLine);
//                }
//                if(fileLine.equals(""))
//                    continue;
//                while(fileLine.endsWith(" ")){
//                    fileLine = fileLine.substring(0,fileLine.length()-1);
//                }
//                String[] splitted = fileLine.split("	");
//                System.out.println(splitted[4]);
//                if(fileLine.length()>2){
//                    System.out.println(fileLine);
//                }
//                if(!fileLine.endsWith("ዊ")){
//                    System.out.println(fileLine);
//                }
//                if(fileLine.length()>=3&&(fileLine.charAt(fileLine.length()-1)=='ች' ||fileLine.charAt(fileLine.length()-1)=='ቹ')&&
//                        getLastLetterBegginingPosition(fileLine.substring(0,fileLine.length()-1))== 6){
//                            
//                }
//                if((fileLine.length()>=2 && getLastLetterBegginingPosition(fileLine)== 6) && !fileLine.endsWith("ዎ")
//                        && !fileLine.startsWith("የ")){
//                    System.out.println(fileLine);
//                }
//                if((fileLine.length()>=2 && getLastLetterBegginingPosition(fileLine.substring(0,fileLine.length()-1))== 7)
//                        && fileLine.endsWith("ል")){
//                    System.out.println(fileLine);
//                }
//                
//                if(fileLine.charAt(fileLine.length()-1) == fileLine.charAt(fileLine.length()-2) && 
//                        getLastLetterBegginingPosition(fileLine) == 5){
//                    System.out.println(fileLine);
//                }
//                while(fileLine.startsWith(" ")){
//                    fileLine = fileLine.substring(1);
//                }
//                while(fileLine.endsWith(" ")){
//                    fileLine = fileLine.substring(0,fileLine.length()-1);
//                }
//                if(fileLine.startsWith("__")){
//                    fileLine = "\"";
//                }
//                System.out.println(fileLine);
//                if(fileLine.contains("\",\"")){
//                    splitted = fileLine.split(",");
//                    System.out.println(splitted[1]);
//                }else{
//                    System.out.println(fileLine);
//                }
//                if(fileLine.startsWith("      <tuv xml:lang=\"am\">")){
//                    fileLine = fileLine.substring(30,fileLine.indexOf("</seg></tuv>"));
//                    System.out.println(fileLine);
//                }
        }
        myWriter.close();
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
