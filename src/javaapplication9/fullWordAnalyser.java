/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;
import static javaapplication9.JavaApplication9.amharicLetters;

/**
 *
 * @author worki
 */
public class fullWordAnalyser {

    static String amharicLetters = "ኧሁሂሃሄህሆኋለሉሊላሌልሎሏሐሑሒሓሔሕሖኋመሙሚማሜምሞሟሠሡሢሣሤሥሧሷረሩሪራሬርሮሯሰሱሲሳሴስሶሷሸሹሺሻሼሽሾሿቀቁቂቃቄቅቆቋበቡቢባቤብቦቧተቱቲታቴትቶቷ"
            + "ቸቹቺቻቼችቾቿኀኁኂኃኄኅኆኋነኑኒናኔንኖኗኘኙኚኛኜኝኞኟአኡኢኣኤእኦኣከኩኪካኬክኮኳኸኹኺኻኼኽኾኋወዉዊዋዌውዎዏዐዑዒዓዔዕዖዓዘዙዚዛ"
            + "ዜዝዞዟዠዡዢዣዤዥዦዧየዩዪያዬይዮያገጉጊጋጌግጎጓጠጡጢጣጤጥጦጧጨጩጪጫጬጭጮጯደዱዲዳዴድዶዷጀጁጂጃጄጅጆጇጰጱጲጳጴጵጶጷጸጹጺጻጼጽጾጿፀፁፂፃፄፅፆጿፈፉፊፋፌፍፎፏፐፑፒፓፔፕፖፗቨቩቪቫቬቭቮቯ";
    public static String[] toBeReplacedLetter = {"ሐ", "ሑ", "ሒ", "ሓ", "ሔ", "ሕ", "ሖ", "ኋ", "ኀ", "ኁ", "ኂ", "ኃ", "ኄ", "ኅ", "ኆ", "ኋ",
        "ኸ", "ኹ", "ኺ", "ኻ", "ኼ", "ኽ", "ኾ", "ኋ", "ጸ", "ጹ", "ጺ", "ጻ", "ጼ", "ጽ", "ጾ", "ሠ", "ሡ", "ሢ", "ሣ", "ሤ", "ሥ", "ሦ",
        "ዐ", "ዑ", "ዒ", "ዓ", "ዔ", "ዕ", "ዖ", "ኣ"};
    public static String[] replacerLetter = {"ሀ", "ሁ", "ሂ", "ሃ", "ሄ", "ህ", "ሆ", "ኋ", "ሀ", "ሁ", "ሂ", "ሃ", "ሄ", "ህ", "ሆ", "ኋ",
        "ኸ", "ሁ", "ሂ", "ሃ", "ሄ", "ህ", "ሆ", "ኋ", "ፀ", "ፁ", "ፂ", "ፃ", "ፄ", "ፅ", "ፆ", "ሰ", "ሱ", "ሲ", "ሳ", "ሴ", "ስ", "ሶ",
        "አ", "ኡ", "ኢ", "አ", "ኤ", "እ", "ኦ", "አ"};
    public static String[] prefixes = {"የ", "ስለየ", "ወደየ", "ከየ", "በየ", "ለየ", "እንደየ", "እስከየ", "ስለ", "ወደ", "ከ", "በ", "ለ", "እንደ", "እስከ", "ባለ"};
    public static String prefix_2 = "የ";
    public static String[] suffixes_01 = {"ን"};
    public static String[] suffixes_02 = {"ም", "ስ", "ና", "ማ", "ሳ"};
    public static String[] suffixes_03 = {"ህ", "ሽ", "ው", "ዋ", "ዬ"};
    public static String[] allWords = new String[11045638];
    public static String[] allCoreWords = new String[11045638];
    public static String[] allSubNobj = new String[11045638];
    public static String[] allWordsClass = new String[11045638];
    public static String[] theDictionary = new String[490898];
    public static String[] theNouns = new String[16848];

    public static void main(String[] args) throws Exception {

        String[] toBeReplaced = {"ሲያ", "ሳ", "ስና", "ስታ", "ስን", "ስት", "ስ", "ሲ"};
        String[] replacers = {"የሚያ", "የማ", "የምና", "የምታ", "የምን", "የምት", "የም", "የሚ",
            "ሚያ", "ማ", "ምና", "ምታ", "ምን", "ምት", "ም", "ሚ",
            "ከሚያ", "ከማ", "ከምና", "ከምታ", "ከምን", "ከምት", "ከም", "ከሚ",
            "ለሚያ", "ለማ", "ለምና", "ለምታ", "ለምን", "ለምት", "ለም", "ለሚ",
            "በሚያ", "በማ", "በምና", "በምታ", "በምን", "በምት", "በም", "በሚ",
            "ስለሚያ", "ስለማ", "ስለምና", "ስለምታ", "ስለምን", "ስለምት", "ስለም", "ስለሚ",
            "ወደሚያ", "ወደማ", "ወደምና", "ወደምታ", "ወደምን", "ወደምት", "ወደም", "ወደሚ",
            "እንደሚያ", "እንደማ", "እንደምና", "እንደምታ", "እንደምን", "እንደምት", "እንደም", "እንደሚ",
            "እስከሚያ", "እስከማ", "እስከምና", "እስከምታ", "እስከምን", "እስከምት", "እስከም", "እስከሚ",
            "እስኪያ", "እስካ", "እስክና", "እስክታ", "እስክን", "እስክት", "እስክ", "እስኪ",
            "እንዲያ", "እንዳ", "እንድና", "እንድታ", "እንድን", "እንድት", "እንድ", "እንዲ",
            "ሳያ", "ሳላ", "ሳና", "ሳታ", "ሳን", "ሳት", "ሳል", "ሳይ",
            "እንዳያ", "እንዳላ", "እንዳና", "እንዳታ", "እንዳን", "እንዳት", "እንዳል", "እንዳይ",
            "የማያ", "የማላ", "የማና", "የማታ", "የማን", "የማት", "የማል", "የማይ",
            "ማያ", "ማላ", "ማና", "ማታ", "ማን", "ማት", "ማል", "ማይ",
            "ከማያ", "ከማላ", "ከማና", "ከማታ", "ከማን", "ከማት", "ከማል", "ከማይ",
            "ለማያ", "ለማላ", "ለማና", "ለማታ", "ለማን", "ለማት", "ለማል", "ለማይ",
            "በማያ", "በማላ", "በማና", "በማታ", "በማን", "በማት", "በማል", "በማይ",
            "ስለማያ", "ስለማላ", "ስለማና", "ስለማታ", "ስለማን", "ስለማት", "ስለማል", "ስለማይ",
            "እንደማያ", "እንደማላ", "እንደማና", "እንደማታ", "እንደማን", "እንደማት", "እንደማል", "እንደማይ",
            "እስከማያ", "እስከማላ", "እስከማና", "እስከማታ", "እስከማን", "እስከማት", "እስከማል", "እስከማይ",
            "ቢያ", "ባ", "ብና", "ብታ", "ብን", "ብት", "ብ", "ቢ",
            "ባያ", "ባላ", "ባና", "ባታ", "ባን", "ባት", "ባል", "ባይ",
            "ሊያ", "ላ", "ልና", "ልታ", "ልን", "ልት", "ል", "ሊ",
            "ላያ", "ላላ", "ላና", "ላታ", "ላን", "ላት", "ላል", "ላይ",
            "አያ", "አላ", "አና", "አታ", "አን", "አት", "አል", "አይ",
            "ሲያ", "ሳ", "ስና", "ስታ", "ስን", "ስት", "ስ", "ሲ",
            "ያ", "አ", "እና", "ታ", "እን", "ት", "እ", "ይ"};
        int[] replacersState = {0, 0, 0, 0, 0, 0, 0, 0,
            1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0};
        String[] toBeReplaced_2 = {"", "አ", "", "", "አ", "አ", "", "አ",
            "አ", "", "", "", "",
            "", "", "", "", "አ", "",
            "አ", "", "አ", "", "አ", "",
            "አ", "", "አ", "", "አ", "",
            "አ", "አ", "አ", "አ", "አ", "አ",
            "አ",};
        String[] replacers_2 = {"አል", "አላ", "የ", "ያል", "ያላ", "ያ", "እየ", "እያ",
            "ባላ", "ስለ", "ወደ", "ከ", "በ",
            "ለ", "እንደ", "እስከ", "ባል", "ስላላ", "ስላል",
            "ወዳላ", "ወዳል", "ካላ", "ካል", "ባላ", "ባል",
            "ላላ", "ላል", "እንዳላ", "እንዳል", "እስካላ", "እስካል",
            "ስላ", "ወዳ", "ካ", "ባ", "ላ", "እንዳ",
            "እስካ"};
        String[] toBeReplaced_3 = {"ል", "ላ", "ን", "ና", "ይ", "ያ", "", "", "ት", "ታ"};
        String[] replacers_3 = {"አል", "አላ", "አን", "አና", "አይ", "አያ", "አት", "አታ", "አት", "አታ"};
        String[] suffixes_0 = {"ም", "ስ", "ና", "ማ", "ሳ"};
        String[] suffixes_1 = {"ም", "ስ", "ና", "ማ", "ሳ", "ን"};
        String[] toBeReplaced_22 = {};
        String[] replacers_22 = {};
        BufferedReader br, br2, br3 = null;
        String fileLine, fileLine2, fileLine3 = "";
        String originalFileLine = "";
        String[] splitted, splitted2 = null;
        int counter = 0;
        boolean done = false;

        boolean doneClass = false;
        boolean doneWord = false;
        boolean doneNoun = false;
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\finalTemplateVerbs.txt"));
        br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\theDictionary.txt"));
        br3 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\allAmharicNouns.txt"));

        String temp, temp2 = "";

        while ((fileLine = br.readLine()) != null) {
            fileLine = normalizeLetter(fileLine);
            splitted2 = fileLine.split(" : ");
            allWords[counter] = splitted2[1].substring(2);
            allWordsClass[counter] = splitted2[3];
            counter++;
        }
        counter = 0;
        System.out.println("first step done!");
        while ((fileLine2 = br2.readLine()) != null) {
            fileLine2 = normalizeLetter(fileLine2);
            theDictionary[counter] = fileLine2;
            counter++;
        }
        counter = 0;
        System.out.println("second step done!");
        while ((fileLine3 = br3.readLine()) != null) {
            fileLine3 = normalizeLetter(fileLine3);
            theNouns[counter] = fileLine3;
            counter++;
        }
        System.out.println("third step done!");
//        for (int i = 0; i < theDictionary.length; i++) {
//            if (i % 100 == 0) {
//                System.out.println(i);
//            }
//            for (int j = 0; j < theNouns.length; j++) {
//
//                doneNoun = false;
//                if (theNouns[j].equals(theDictionary[i])) {
//                    theDictionary[i] = null;
//                    break;
//                }
//                for (int k = 0; k < prefixes.length; k++) {
//                    if (theDictionary[i] != null && theDictionary[i].startsWith(prefixes[k])) {
//                        temp = theDictionary[i].replaceFirst(prefixes[k], "");
//                        for (int n = 0; n < theNouns.length; n++) {
//                            if (temp.equals(theNouns[n])) {
//                                theDictionary[i] = null;
//                                doneNoun = true;
//                                break;
//                            }
//                        }
//                        break;
//                    }
//                }
//                if (doneNoun) {
//                    break;
//                }
//                if (theDictionary[i] != null && (theDictionary[i].endsWith("ች")
//                        && getLastLetterBegginingPosition(theDictionary[i].substring(0, theDictionary[i].length() - 1)) == 6)) {
//                    if (theDictionary[i].endsWith("ዎች")) {
//                        temp = theDictionary[i].substring(0, theDictionary[i].length() - 2);
//                    } else {
//                        temp = theDictionary[i].substring(0, theDictionary[i].length() - 2)
//                                + justChangeLetter(theDictionary[i].charAt(theDictionary[i].length() - 1), 5);
//                    }
//                    for (int n = 0; n < theNouns.length; n++) {
//                        if (temp.equals(theNouns[n])) {
//                            theDictionary[i] = null;
//                            doneNoun = true;
//                            break;
//                        }
//                    }
//                }
//                if (doneNoun) {
//                    break;
//                }
//                if (theDictionary[i] != null && (theDictionary[i].endsWith("ችሁ") || theDictionary[i].endsWith("ቸው")
//                        || theDictionary[i].endsWith("ችን"))) {
//                    temp = theDictionary[i].substring(0, theDictionary[i].length() - 2);
//                    temp2 = theDictionary[i].substring(0, theDictionary[i].length() - 2)
//                            + justChangeLetter(theDictionary[i].charAt(theDictionary[i].length() - 1), 5);
//                    for (int n = 0; n < theNouns.length; n++) {
//                        if (temp.equals(theNouns[n]) || temp2.equals(theNouns[n])) {
//                            theDictionary[i] = null;
//                            doneNoun = true;
//                            break;
//                        }
//                    }
//                }
//                if (doneNoun) {
//                    break;
//                }
//                if (theDictionary[i] != null && theDictionary[i].length() > 1 && (getLastLetterBegginingPosition(theDictionary[i].substring(0, theDictionary[i].length() - 1)) == 1
//                        || getLastLetterBegginingPosition(theDictionary[i].substring(0, theDictionary[i].length() - 1)) == 4
//                        || getLastLetterBegginingPosition(theDictionary[i].substring(0, theDictionary[i].length() - 1)) == 7)) {
//                    temp = theDictionary[i].substring(0, theDictionary[i].length() - 2)
//                            + justChangeLetter(theDictionary[i].charAt(theDictionary[i].length() - 1), 5);
//                    for (int n = 0; n < theNouns.length; n++) {
//                        if (temp.equals(theNouns[n])) {
//                            theDictionary[i] = null;
//                            doneNoun = true;
//                            break;
//                        }
//                    }
//                }
//                if (doneNoun) {
//                    break;
//                }
//                for (int k = 0; k < suffixes_01.length; k++) {
//                    if (theDictionary[i] != null && theDictionary[i].endsWith(suffixes_01[k])) {
//                        temp = theDictionary[i].substring(0, (theDictionary[i].length() - 1));
//                        for (int n = 0; n < theNouns.length; n++) {
//                            if (temp.equals(theNouns[n])) {
//                                theDictionary[i] = null;
//                                doneNoun = true;
//                                break;
//                            }
//                        }
//                        for (int l = 0; l < suffixes_02.length; l++) {
//                            if (temp.endsWith(suffixes_02[l])) {
//                                temp = temp.substring(0, temp.length() - 1);
//                                for (int n = 0; n < theNouns.length; n++) {
//                                    if (temp.equals(theNouns[n])) {
//                                        theDictionary[i] = null;
//                                        doneNoun = true;
//                                        break;
//                                    }
//                                }
//                                break;
//                            }
//                        }
//                        break;
//                    }
//                }
//                if (doneNoun) {
//                    break;
//                }
//                for (int l = 0; l < suffixes_02.length; l++) {
//                    if (theDictionary[i] != null && theDictionary[i].endsWith(suffixes_02[l])) {
//                        temp = theDictionary[i].substring(0, theDictionary[i].length() - 1);
//                        for (int n = 0; n < theNouns.length; n++) {
//                            if (temp.equals(theNouns[n])) {
//                                theDictionary[i] = null;
//                                break;
//                            }
//                        }
//                        break;
//                    }
//                }
//
//            }
//        }
        System.out.println("forth step done!");
        for (int a = 0; a < theDictionary.length; a++) {
            fileLine2 = theDictionary[a];
            if (fileLine2 == null) {
                continue;
            }
            if (a > 0 && !doneWord) {
                System.out.println(originalFileLine);
            }
            doneWord = false;
            originalFileLine = fileLine2;
            int indexOfReplaced = 0;
            int indexOfReplacer = 0;
            for (int j = 0; j < theNouns.length; j++) {

                doneNoun = false;
                if (theNouns[j].equals(theDictionary[a])) {
//                    theDictionary[a] = null;
//                    System.out.println(theDictionary[a]);
                    doneWord = true;
                    break;
                }
                for (int k = 0; k < prefixes.length; k++) {
                    if (theDictionary[a] != null && theDictionary[a].startsWith(prefixes[k])) {
                        temp = theDictionary[a].replaceFirst(prefixes[k], "");
                        for (int n = 0; n < theNouns.length; n++) {
                            if (temp.equals(theNouns[n])) {

//                                System.out.println(theDictionary[a]);
                                doneWord = true;
                                break;
                            }
                        }
                        break;
                    }
                }
                if (doneWord) {
                    break;
                }
                if (theDictionary[a] != null && (theDictionary[a].endsWith("ች")
                        && getLastLetterBegginingPosition(theDictionary[a].substring(0, theDictionary[a].length() - 1)) == 6)) {
                    if (theDictionary[a].endsWith("ዎች")) {
                        temp = theDictionary[a].substring(0, theDictionary[a].length() - 2);
                    } else {
                        temp = theDictionary[a].substring(0, theDictionary[a].length() - 2)
                                + justChangeLetter(theDictionary[a].charAt(theDictionary[a].length() - 2), 5);
                    }
                    for (int n = 0; n < theNouns.length; n++) {
                        if (temp.equals(theNouns[n])) {
//                            theDictionary[a] = null;
//                            System.out.println(theDictionary[a]);
                            doneWord = true;
                            break;
                        }
                    }
                }
                if (doneWord) {
                    break;
                }
                if (theDictionary[a] != null && (theDictionary[a].endsWith("ችሁ") || theDictionary[a].endsWith("ቸው")
                        || theDictionary[a].endsWith("ችን"))) {
                    temp = theDictionary[a].substring(0, theDictionary[a].length() - 2);
                    temp2 = theDictionary[a].substring(0, theDictionary[a].length() - 2)
                            + justChangeLetter(theDictionary[a].charAt(theDictionary[a].length() - 1), 5);
                    for (int n = 0; n < theNouns.length; n++) {
                        if (temp.equals(theNouns[n]) || temp2.equals(theNouns[n])) {
//                            theDictionary[a] = null;
//                            System.out.println(theDictionary[a]);
                            doneWord = true;
                            break;
                        }
                    }
                }
                if (doneWord) {
                    break;
                }
                if (theDictionary[a] != null && theDictionary[a].length() > 1 && (getLastLetterBegginingPosition(theDictionary[a].substring(0, theDictionary[a].length() - 1)) == 1
                        || getLastLetterBegginingPosition(theDictionary[a].substring(0, theDictionary[a].length() - 1)) == 4
                        || getLastLetterBegginingPosition(theDictionary[a].substring(0, theDictionary[a].length() - 1)) == 7)) {
                    temp = theDictionary[a].substring(0, theDictionary[a].length() - 2)
                            + justChangeLetter(theDictionary[a].charAt(theDictionary[a].length() - 1), 5);
                    for (int n = 0; n < theNouns.length; n++) {
                        if (temp.equals(theNouns[n])) {
//                            theDictionary[a] = null;
//                            System.out.println(theDictionary[a]);
                            doneWord = true;
                            break;
                        }
                    }
                }
                if (doneWord) {
                    break;
                }
                for (int k = 0; k < suffixes_01.length; k++) {
                    if (theDictionary[a] != null && theDictionary[a].endsWith(suffixes_01[k])) {
                        temp = theDictionary[a].substring(0, (theDictionary[a].length() - 1));
                        for (int n = 0; n < theNouns.length; n++) {
                            if (temp.equals(theNouns[n])) {
//                                System.out.println(theDictionary[a]);
                                doneWord = true;
                                break;
                            }
                        }
                        for (int l = 0; l < suffixes_02.length; l++) {
                            if (temp.endsWith(suffixes_02[l])) {
                                temp = temp.substring(0, temp.length() - 1);
                                for (int n = 0; n < theNouns.length; n++) {
                                    if (temp.equals(theNouns[n])) {
//                                        System.out.println(theDictionary[a]);
                                        doneWord = true;
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
                if (doneWord) {
                    break;
                }
                for (int l = 0; l < suffixes_02.length; l++) {
                    if (theDictionary[a] != null && theDictionary[a].endsWith(suffixes_02[l])) {
                        temp = theDictionary[a].substring(0, theDictionary[a].length() - 1);
                        for (int n = 0; n < theNouns.length; n++) {
                            if (temp.equals(theNouns[n])) {
//                                System.out.println(theDictionary[a]);
                                doneWord = true;
                                break;
                            }
                        }
                        break;
                    }
                }
                if (doneWord) {
                    break;
                }

            }
            if (doneWord) {
                continue;
            }

            for (int i = 0; i < allWords.length; i++) {
                if (fileLine2.equals(allWords[i])) {
//                    System.out.println(originalFileLine);
                    doneWord = true;
                    break;
                }
                fileLine2 = originalFileLine;
                for (int j = 0; j < suffixes_0.length; j++) {
                    if (fileLine2.endsWith(suffixes_0[j]) && fileLine2.substring(0, fileLine2.length() - 1).equals(allWords[i])) {
//                        System.out.println(originalFileLine);
                        doneWord = true;
                        break;
                    }
                }
                if (doneWord) {
                    break;
                }
            }
            if (doneWord) {
                continue;
            }
            for (int i = 0; i < allWords.length; i++) {
                doneClass = false;
                doneWord = false;
                if (allWordsClass[i].endsWith("1")) {
                    for (int j = 0; j < replacers.length; j++) {
                        if (fileLine2.startsWith(replacers[j])) {
                            doneClass = true;
                            indexOfReplaced = j;
                            indexOfReplacer = j % 8;
                            break;
                        }
                    }
                    if (!doneClass) {
                        i = 1494751;
                        continue;
                    } else {

                        fileLine2 = fileLine2.replaceFirst(replacers[indexOfReplaced], toBeReplaced[indexOfReplacer]);

                        for (int k = 0; k < 1494752; k++) {
                            if (fileLine2.equals(allWords[k])) {
//                                System.out.println(originalFileLine);
                                doneWord = true;
                                break;
                            }
                            if (replacersState[indexOfReplaced] == 0) {
                                for (int j = 0; j < suffixes_0.length; j++) {
                                    if (fileLine2.endsWith(suffixes_0[j]) && fileLine2.substring(0, fileLine2.length() - 1).equals(allWords[k])) {
//                                        System.out.println(originalFileLine);
                                        doneWord = true;
                                        break;
                                    }
                                }
                            } else if (replacersState[indexOfReplaced] == 1) {
                                for (int j = 0; j < suffixes_1.length; j++) {
                                    if (fileLine2.endsWith(suffixes_1[j]) && fileLine2.substring(0, fileLine2.length() - 1).equals(allWords[k])) {
//                                        System.out.println(originalFileLine);
                                        doneWord = true;
                                        break;
                                    }
                                }
                            }
                            if (doneWord) {
                                break;
                            }
                        }
                        if (doneWord) {
                            break;
                        } else {
                            i = 1494751;
                            continue;
                        }
                    }
                }
                fileLine2 = originalFileLine;
                if (allWordsClass[i].endsWith("2")) {
                    for (int j = 0; j < replacers_2.length; j++) {
                        if (fileLine2.startsWith(replacers_2[j])) {
                            doneClass = true;
                            indexOfReplaced = j;
                            indexOfReplacer = j;
                            break;
                        }
                    }
                    if (!doneClass) {
                        i = 9737737;
                        continue;
                    } else {
                        fileLine2 = fileLine2.replaceFirst(replacers_2[indexOfReplaced], toBeReplaced_2[indexOfReplacer]);
                        for (int k = 1494752; k < 3569890; k++) {
                            if (fileLine2.equals(allWords[k])) {
//                                System.out.println(originalFileLine);
                                doneWord = true;
                                break;
                            }
                            for (int j = 0; j < suffixes_0.length; j++) {
                                if (fileLine2.endsWith(suffixes_0[j]) && fileLine2.substring(0, fileLine2.length() - 1).equals(allWords[k])) {
//                                    System.out.println(originalFileLine);
                                    doneWord = true;
                                    break;
                                }
                            }
                            if (doneWord) {
                                break;
                            }
                        }
                        if (doneWord) {
                            break;
                        } else {
                            i = 9737737;
                            continue;
                        }
                    }
                }
                fileLine2 = originalFileLine;
                if (allWordsClass[i].endsWith("6")) {
                    for (int j = 0; j < replacers_3.length; j++) {
                        if (fileLine2.startsWith(replacers_3[j])) {
                            doneClass = true;
                            indexOfReplaced = j;
                            indexOfReplacer = j;
                            break;
                        }
                    }
                    if (!doneClass) {
                        break;
                    } else {
                        fileLine2 = fileLine2.replaceFirst(replacers_3[indexOfReplaced], toBeReplaced_3[indexOfReplacer]);
                        for (int k = 9737738; k < 11045637; k++) {
                            if (fileLine2.equals(allWords[k])) {
//                                System.out.println(originalFileLine);
                                doneWord = true;
                                break;
                            }
                            for (int j = 0; j < suffixes_0.length; j++) {
                                if (fileLine2.endsWith(suffixes_0[j]) && fileLine2.substring(0, fileLine2.length() - 1).equals(allWords[k])) {
//                                    System.out.println(originalFileLine);
                                    doneWord = true;
                                    break;
                                }
                            }
                            if (doneWord) {
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }

    public static int getLastLetterBegginingPosition(String word) {
        int x;
        x = (amharicLetters.indexOf(word.charAt(word.length() - 1)) % 8);
        return x;
    }

    public static String rootWordProcessor(String word) {
        String rootWord = "";
        String[] x = word.split("");

        for (int i = 0; i < x.length; i++) {
            rootWord = rootWord + justChangeLetter(x[i].charAt(0), 5);
        }
        return rootWord;
    }

    public static char justChangeLetter(char theChar, int to) {
        int x = amharicLetters.indexOf(theChar) - amharicLetters.indexOf(theChar) % 8;
        char toBeReturned = amharicLetters.charAt(x + to);
        if (x == 0 && to == 0) {
            toBeReturned = 'ኸ';
        }
        return toBeReturned;
    }

    public static String normalizeLetter(String word) throws Exception {
        for (int j = 0; j < toBeReplacedLetter.length; j++) {
            word = word.replace(toBeReplacedLetter[j], replacerLetter[j]);
        }
        return word;
    }

    public static boolean prefSuffix(String word) {
        String temp = "";
        for (int k = 0; k < prefixes.length; k++) {
            if (word.startsWith(prefixes[k])) {
                temp = word.replaceFirst(prefixes[k], "");
                for (int n = 0; n < theNouns.length; n++) {
                    if (temp.equals(theNouns[n])) {
                        return true;
                    }
                }
                if (suffix(temp, 0)) {
                    return true;
                }
            }
        }
        return suffix(word, 0);
    }

    public static boolean suffix(String word, int fromWhere) {
        String temp, temp2 = "";
        boolean doneWord = false;
        if (fromWhere == 0) {
            for (int k = 0; k < suffixes_01.length; k++) {
                if (word.endsWith(suffixes_01[k])) {
                    temp = word.substring(0, (word.length() - 1));
                    for (int n = 0; n < theNouns.length; n++) {
                        if (temp.equals(theNouns[n])) {
                            return true;
                        }
                    }
                    if (suffix(temp, 1)) {
                        return true;
                    }
                }
            }
            return suffix(word, 1);
        } else {
            if (fromWhere == 1) {
                for (int k = 0; k < suffixes_02.length; k++) {
                    if (word.endsWith(suffixes_02[k])) {
                        temp = word.substring(0, (word.length() - 1));
                        for (int n = 0; n < theNouns.length; n++) {
                            if (temp.equals(theNouns[n])) {
                                return true;
                            }
                        }
                        if (suffix(temp, 2)) {
                            return true;
                        }
                    }
                }
                return suffix(word, 2);
            }else if (fromWhere == 2) {
                for (int k = 0; k < suffixes_03.length; k++) {
                    if (word.endsWith(suffixes_03[k])) {
                        temp = word.substring(0, (word.length() - 1));
                        for (int n = 0; n < theNouns.length; n++) {
                            if (temp.equals(theNouns[n])) {
                                return true;
                            }
                        }
                        if (suffix(temp, 3)) {
                            return true;
                        }
                    }
                }
                return suffix(word, 3);
            } else if (fromWhere == 3) {

                if (word.length() > 1 && (getLastLetterBegginingPosition(word.substring(0, word.length() - 1)) == 1
                        || getLastLetterBegginingPosition(word.substring(0, word.length() - 1)) == 4
                        || getLastLetterBegginingPosition(word.substring(0, word.length() - 1)) == 7)) {
                    temp = word.substring(0, word.length() - 2)
                            + justChangeLetter(word.charAt(word.length() - 1), 5);
                    for (int n = 0; n < theNouns.length; n++) {
                        if (temp.equals(theNouns[n])) {
                            return true;
                        }
                    }
                    if (suffix(temp, 4)) {
                        return true;
                    }
                }
                return suffix(word, 4);
                

            }else if(fromWhere == 4){
                
                if ((word.endsWith("ች")
                        && getLastLetterBegginingPosition(word.substring(0, word.length() - 1)) == 6)) {
                    if (word.endsWith("ዎች")) {
                        temp = word.substring(0, word.length() - 2);
                    } else {
                        temp = word.substring(0, word.length() - 2)
                                + justChangeLetter(word.charAt(word.length() - 2), 5);
                    }
                    for (int n = 0; n < theNouns.length; n++) {
                        if (temp.equals(theNouns[n])) {
                            return true;
                        }
                    }
                    if (suffix(temp, 4)) {
                        return true;
                    }
                }
                if ((word.endsWith("ችሁ") || word.endsWith("ቸው")
                        || word.endsWith("ችን"))) {
                    temp = word.substring(0, word.length() - 2);
                    temp2 = word.substring(0, word.length() - 2)
                            + justChangeLetter(word.charAt(word.length() - 1), 5);
                    for (int n = 0; n < theNouns.length; n++) {
                        if (temp.equals(theNouns[n]) || temp2.equals(theNouns[n])) {
                            return true;
                        }
                    }
                    if (suffix(temp, 4)) {
                        return true;
                    }
                    if (suffix(temp2, 4)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
