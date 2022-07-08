/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author worki
 */
public class fullVerbAnalyser {

    static String amharicLetters = "ኧሁሂሃሄህሆኋለሉሊላሌልሎሏሐሑሒሓሔሕሖኋመሙሚማሜምሞሟሠሡሢሣሤሥሧሷረሩሪራሬርሮሯሰሱሲሳሴስሶሷሸሹሺሻሼሽሾሿቀቁቂቃቄቅቆቋበቡቢባቤብቦቧተቱቲታቴትቶቷ"
            + "ቸቹቺቻቼችቾቿኀኁኂኃኄኅኆኋነኑኒናኔንኖኗኘኙኚኛኜኝኞኟአኡኢኣኤእኦኣከኩኪካኬክኮኳኸኹኺኻኼኽኾኋወዉዊዋዌውዎዏዐዑዒዓዔዕዖዓዘዙዚዛ"
            + "ዜዝዞዟዠዡዢዣዤዥዦዧየዩዪያዬይዮያገጉጊጋጌግጎጓጠጡጢጣጤጥጦጧጨጩጪጫጬጭጮጯደዱዲዳዴድዶዷጀጁጂጃጄጅጆጇጰጱጲጳጴጵጶጷጸጹጺጻጼጽጾጿፀፁፂፃፄፅፆጿፈፉፊፋፌፍፎፏፐፑፒፓፔፕፖፗቨቩቪቫቬቭቮቯ";
    public static String[] toBeReplacedLetter = {"ሐ", "ሑ", "ሒ", "ሓ", "ሔ", "ሕ", "ሖ", "ኋ", "ኀ", "ኁ", "ኂ", "ኃ", "ኄ", "ኅ", "ኆ", "ኋ",
        "ኸ", "ኹ", "ኺ", "ኻ", "ኼ", "ኽ", "ኾ", "ኋ", "ጸ", "ጹ", "ጺ", "ጻ", "ጼ", "ጽ", "ጾ", "ሠ", "ሡ", "ሢ", "ሣ", "ሤ", "ሥ", "ሦ",
        "ዐ", "ዑ", "ዒ", "ዓ", "ዔ", "ዕ", "ዖ", "ኣ"};
    public static String[] replacerLetter = {"ሀ", "ሁ", "ሂ", "ሃ", "ሄ", "ህ", "ሆ", "ኋ", "ሀ", "ሁ", "ሂ", "ሃ", "ሄ", "ህ", "ሆ", "ኋ",
        "ኸ", "ሁ", "ሂ", "ሃ", "ሄ", "ህ", "ሆ", "ኋ", "ፀ", "ፁ", "ፂ", "ፃ", "ፄ", "ፅ", "ፆ", "ሰ", "ሱ", "ሲ", "ሳ", "ሴ", "ስ", "ሶ",
        "አ", "ኡ", "ኢ", "አ", "ኤ", "እ", "ኦ", "አ"};

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
        BufferedReader br, br2 = null;
        String fileLine, fileLine2 = "";
        String originalFileLine = "";
        String[] splitted, splitted2 = null;
        int counter = 0;
        boolean done = false;
        String[] allWords = new String[11045638];
        String[] allCoreWords = new String[11045638];
        String[] allSubNobj = new String[11045638];
        String[] allWordsClass = new String[11045638];
        boolean doneClass = false;
        boolean doneWord = false;
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\finalTemplateVerbs.txt"));
        br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\allAmharicNouns.txt"));

        while ((fileLine = br.readLine()) != null) {
            splitted2 = fileLine.split(" : ");
            allWords[counter] = splitted2[1].substring(2);
            allWordsClass[counter] = splitted2[3];
            counter++;
        }
        System.out.println("first step done!");
        while ((fileLine2 = br2.readLine()) != null) {
            doneWord = false;
            originalFileLine = fileLine2;
            int indexOfReplaced = 0;
            int indexOfReplacer = 0;
            fileLine2 = normalizeLetter(fileLine2);
            for (int i = 0; i < allWords.length; i++) {
                if (fileLine2.equals(allWords[i])) {
                    System.out.println(originalFileLine);
                    doneWord = true;
                    break;
                }
                fileLine2 = originalFileLine;
                for (int j = 0; j < suffixes_0.length; j++) {
                    if (fileLine2.endsWith(suffixes_0[j]) && fileLine2.substring(0, fileLine2.length() - 1).equals(allWords[i])) {
                        System.out.println(originalFileLine);
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
                                System.out.println(originalFileLine);
                                doneWord = true;
                                break;
                            }
                            if (replacersState[indexOfReplaced] == 0) {
                                for (int j = 0; j < suffixes_0.length; j++) {
                                    if (fileLine2.endsWith(suffixes_0[j]) && fileLine2.substring(0, fileLine2.length() - 1).equals(allWords[k])) {
                                        System.out.println(originalFileLine);
                                        doneWord = true;
                                        break;
                                    }
                                }
                            } else if (replacersState[indexOfReplaced] == 1) {
                                for (int j = 0; j < suffixes_1.length; j++) {
                                    if (fileLine2.endsWith(suffixes_1[j]) && fileLine2.substring(0, fileLine2.length() - 1).equals(allWords[k])) {
                                        System.out.println(originalFileLine);
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
                                System.out.println(originalFileLine);
                                doneWord = true;
                                break;
                            }
                            for (int j = 0; j < suffixes_0.length; j++) {
                                if (fileLine2.endsWith(suffixes_0[j]) && fileLine2.substring(0, fileLine2.length() - 1).equals(allWords[k])) {
                                    System.out.println(originalFileLine);
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
                                System.out.println(originalFileLine);
                                doneWord = true;
                                break;
                            }
                            for (int j = 0; j < suffixes_0.length; j++) {
                                if (fileLine2.endsWith(suffixes_0[j]) && fileLine2.substring(0, fileLine2.length() - 1).equals(allWords[k])) {
                                    System.out.println(originalFileLine);
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
}
