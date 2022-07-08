package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;
import static javaapplication9.JavaApplication9.amharicLetters;

public class fullWordAnalyser_DB {

    static String amharicLetters = "ኧሁሂሃሄህሆኋለሉሊላሌልሎሏሐሑሒሓሔሕሖኋመሙሚማሜምሞሟሰሱሲሳሴስሶሷሠሡሢሣሤሥሧሷረሩሪራሬርሮሯሸሹሺሻሼሽሾሿቀቁቂቃቄቅቆቋበቡቢባቤብቦቧተቱቲታቴትቶቷ"
            + "ቸቹቺቻቼችቾቿኀኁኂኃኄኅኆኋነኑኒናኔንኖኗኘኙኚኛኜኝኞኟአኡኢኣኤእኦኣከኩኪካኬክኮኳኸኹኺኻኼኽኾኋወዉዊዋዌውዎዏዐዑዒዓዔዕዖዓዘዙዚዛ"
            + "ዜዝዞዟዠዡዢዣዤዥዦዧየዩዪያዬይዮያገጉጊጋጌግጎጓጠጡጢጣጤጥጦጧጨጩጪጫጬጭጮጯደዱዲዳዴድዶዷጀጁጂጃጄጅጆጇጰጱጲጳጴጵጶጷፀፁፂፃፄፅፆጿጸጹጺጻጼጽጾጿፈፉፊፋፌፍፎፏፐፑፒፓፔፕፖፗቨቩቪቫቬቭቮቯ";
    public static String[] toBeReplacedLetter = {"ሐ", "ሑ", "ሒ", "ሓ", "ሔ", "ሕ", "ሖ", "ኋ", "ኀ", "ኁ", "ኂ", "ኃ", "ኄ", "ኅ", "ኆ", "ኋ",
        "ኸ", "ኹ", "ኺ", "ኻ", "ኼ", "ኽ", "ኾ", "ኋ", "ጸ", "ጹ", "ጺ", "ጻ", "ጼ", "ጽ", "ጾ", "ሠ", "ሡ", "ሢ", "ሣ", "ሤ", "ሥ", "ሦ",
        "ዐ", "ዑ", "ዒ", "ዓ", "ዔ", "ዕ", "ዖ", "ኣ"};
    public static String[] replacerLetter = {"ሀ", "ሁ", "ሂ", "ሃ", "ሄ", "ህ", "ሆ", "ኋ", "ሀ", "ሁ", "ሂ", "ሃ", "ሄ", "ህ", "ሆ", "ኋ",
        "ኸ", "ሁ", "ሂ", "ሃ", "ሄ", "ህ", "ሆ", "ኋ", "ፀ", "ፁ", "ፂ", "ፃ", "ፄ", "ፅ", "ፆ", "ሰ", "ሱ", "ሲ", "ሳ", "ሴ", "ስ", "ሶ",
        "አ", "ኡ", "ኢ", "አ", "ኤ", "እ", "ኦ", "አ"};
    public static String[] prefixes = {"የ", "የየ", "ስለየ", "ወደየ", "ከየ", "በየ", "ለየ", "እንደየ", "እስከየ", "ስለ", "ወደ", "ከ", "በ", "ለ", "እንደ", "እስከ", "ባለ", "ያለ", "አለ", "ካለ", "ከነ"};
    public static String[] prefixes_2 = {"ያ", "የያ", "ስለያ", "ወደያ", "ከያ", "በያ", "ለያ", "እንደያ", "እስከያ", "ስላ", "ወዳ", "ካ", "ባ", "ላ", "እንዳ", "እስካ", "ባላ", "ያላ", "አላ", "ካላ"};
    public static String[] suffixes_01 = {"ም", "ስ", "ና", "ማ", "ሳ"};
    public static String[] suffixes_02 = {"ን"};
    public static String[] suffixes_03 = {"ህ", "ሽ", "ው", "ዋ", "ዬ"};

    public static String[] toBeReplaced = {"ሲያ", "ሳ", "ስና", "ስታ", "ስን", "ስት", "ስ", "ሲ"};
    public static String[] replacers = {
        "ሳያ", "ሳላ", "ሳና", "ሳታ", "ሳን", "ሳት", "ሳል", "ሳይ",
        "እንዳያ", "እንዳላ", "እንዳና", "እንዳታ", "እንዳን", "እንዳት", "እንዳል", "እንዳይ",
        "የማያ", "የማላ", "የማና", "የማታ", "የማን", "የማት", "የማል", "የማይ",
        "ማያ", "ማላ", "ማና", "ማታ", "ማን", "ማት", "ማል", "ማይ",
        "ከማያ", "ከማላ", "ከማና", "ከማታ", "ከማን", "ከማት", "ከማል", "ከማይ",
        "ለማያ", "ለማላ", "ለማና", "ለማታ", "ለማን", "ለማት", "ለማል", "ለማይ",
        "በማያ", "በማላ", "በማና", "በማታ", "በማን", "በማት", "በማል", "በማይ",
        "ወደማያ", "ወደማላ", "ወደማና", "ወደማታ", "ወደማን", "ወደማት", "ወደማል", "ወደማይ",
        "ስለማያ", "ስለማላ", "ስለማና", "ስለማታ", "ስለማን", "ስለማት", "ስለማል", "ስለማይ",
        "እንደማያ", "እንደማላ", "እንደማና", "እንደማታ", "እንደማን", "እንደማት", "እንደማል", "እንደማይ",
        "እስከማያ", "እስከማላ", "እስከማና", "እስከማታ", "እስከማን", "እስከማት", "እስከማል", "እስከማይ",
        "የሚያ", "የማ", "የምና", "የምታ", "የምን", "የምት", "የም", "የሚ",
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
        "ባያ", "ባላ", "ባና", "ባታ", "ባን", "ባት", "ባል", "ባይ",
        "ቢያ", "ባ", "ብና", "ብታ", "ብን", "ብት", "ብ", "ቢ",
        "ላያ", "ላላ", "ላና", "ላታ", "ላን", "ላት", "ላል", "ላይ",
        "ሊያ", "ላ", "ልና", "ልታ", "ልን", "ልት", "ል", "ሊ",
        "አያ", "አላ", "አና", "አታ", "አን", "አት", "አል", "አይ",
        "ሲያ", "ሳ", "ስና", "ስታ", "ስን", "ስት", "ስ", "ሲ",
        "ያ", "አ", "እና", "ታ", "እን", "ት", "እ", "ይ"};
    public static int[] replacersState = {
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
        0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0};
    public static String[] toBeReplaced_2 = {"", "አ", "", "", "አ", "አ", "", "አ",
        "አ", "", "", "", "",
        "", "", "", "", "አ", "",
        "አ", "", "አ", "", "አ", "",
        "አ", "", "አ", "", "አ", "",
        "አ", "አ", "አ", "አ", "አ", "አ",
        "አ",};
    public static String[] replacers_2 = {"አል", "አላ", "የ", "ያል", "ያላ", "ያ", "እየ", "እያ",
        "ባላ", "ስለ", "ወደ", "ከ", "በ",
        "ለ", "እንደ", "እስከ", "ባል", "ስላላ", "ስላል",
        "ወዳላ", "ወዳል", "ካላ", "ካል", "ባላ", "ባል",
        "ላላ", "ላል", "እንዳላ", "እንዳል", "እስካላ", "እስካል",
        "ስላ", "ወዳ", "ካ", "ባ", "ላ", "እንዳ",
        "እስካ"};
    public static String[] toBeReplaced_3 = {"ል", "ላ", "ን", "ና", "ይ", "ያ", "", "", "ት", "ታ"};
    public static String[] replacers_3 = {"አል", "አላ", "አን", "አና", "አይ", "አያ", "አት", "አታ", "አት", "አታ"};
    public static String[] suffixes_0 = {"ም", "ስ", "ና", "ማ", "ሳ"};
    public static String[] suffixes_1 = {"ም", "ስ", "ና", "ማ", "ሳ", "ን"};

    public static String[] allWords = new String[12491666];
    public static String[] allCoreWords = new String[12491666];
    public static String[] allSubNobj = new String[12491666];
    public static String[] allWordsClass = new String[12491666];
    public static String[] theDictionary = new String[11729];
    public static String[] theNouns = new String[18443];

    public static void main(String[] args) throws Exception {

        BufferedReader br, br2, br3 = null;
        String fileLine, fileLine2, fileLine3 = "";
        String originalFileLine = "";
        String[] splitted, splitted2 = null;
        int counter = 0;
        boolean doneWord = false;
        br = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\finalTemplateVerbs.txt"));
        br2 = new BufferedReader(new FileReader("C:\\Users\\worki\\Desktop\\final\\temp4.txt"));
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
        for (int a = 0; a < theDictionary.length; a++) {

            if (a > 0 && !doneWord) {
                System.out.println(originalFileLine);
            }
            originalFileLine = theDictionary[a];
            doneWord = false;
            if (preSuffix(theDictionary[a])) {
                doneWord = true;
                continue;
            }
            if (verbsProcessor(theDictionary[a])) {
                doneWord = true;
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

    public static boolean verbsProcessor(String word) {
        boolean doneClass = false;
        boolean doneWord = false;
        int indexOfReplaced = 0;
        int indexOfReplacer = 0;
        String temp, temp2 = "";
        String originalFileLine = word;
        for (int i = 0; i < allWords.length; i++) {
            if (word.equals(allWords[i])) {
                return true;
            }
            word = originalFileLine;
            for (int j = 0; j < suffixes_0.length; j++) {
                if (word.endsWith(suffixes_0[j]) && word.substring(0, word.length() - 1).equals(allWords[i])) {
                    return true;
                }
            }
        }
        for (int i = 0; i < allWords.length; i++) {
            doneClass = false;
            doneWord = false;
            if (allWordsClass[i].endsWith("1")) {
                for (int j = 0; j < replacers.length; j++) {
                    if (word.startsWith(replacers[j])) {
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

                    word = word.replaceFirst(replacers[indexOfReplaced], toBeReplaced[indexOfReplacer]);
                    if (word.equals("")) {
                        i = 1494751;
                        continue;
                    }
                    for (int k = 0; k < 1494752; k++) {
                        if (word.equals(allWords[k])) {
                            return true;
                        }
                        if (replacersState[indexOfReplaced] == 0) {
                            for (int j = 0; j < suffixes_0.length; j++) {
                                if (word.endsWith(suffixes_0[j]) && word.substring(0, word.length() - 1).equals(allWords[k])) {
                                    return true;
                                }
                            }
                        } else if (word.length() > 2 && replacersState[indexOfReplaced] == 1) {
                            temp = word.substring(0, word.length() - 1);
                            for (int j = 0; j < suffixes_1.length; j++) {
                                if (word.endsWith(suffixes_1[j]) && temp.equals(allWords[k])) {
                                    return true;
                                }
                            }
                        }

                    }
                    i = 1494751;
                    continue;
                }
            }
            word = originalFileLine;
            if (allWordsClass[i].endsWith("2")) {
                for (int j = 0; j < replacers_2.length; j++) {
                    if (word.startsWith(replacers_2[j])) {
                        doneClass = true;
                        indexOfReplaced = j;
                        indexOfReplacer = j;
                        break;
                    }
                }
                if (!doneClass) {
                    i = 11183757;
                    continue;
                } else {
                    word = word.replaceFirst(replacers_2[indexOfReplaced], toBeReplaced_2[indexOfReplacer]);
                    if (word.equals("")) {
                        i = 11183757;
                        continue;
                    }
                    for (int k = 1494752; k < 3637599; k++) {
                        if (word.equals(allWords[k])) {
                            return true;
                        }
                        if (word.length() > 2) {
                            for (int j = 0; j < suffixes_1.length; j++) {
                                temp = word.substring(0, word.length() - 1);
                                if (word.endsWith(suffixes_1[j]) && temp.equals(allWords[k])) {
                                    return true;
                                }
                            }
                        }
                    }
                    i = 11183757;
                    continue;
                }
            }
            word = originalFileLine;
            if (allWordsClass[i].endsWith("6")) {
                for (int j = 0; j < replacers_3.length; j++) {
                    if (word.startsWith(replacers_3[j])) {
                        doneClass = true;
                        indexOfReplaced = j;
                        indexOfReplacer = j;
                        break;
                    }
                }
                if (!doneClass) {
                    break;
                } else {
                    word = word.replaceFirst(replacers_3[indexOfReplaced], toBeReplaced_3[indexOfReplacer]);
                    if(word.equals("")){
                        break;
                    }
                    for (int k = 11183758; k < allWords.length; k++) {
                        if (word.equals(allWords[k])) {
                            return true;
                        }
                        for (int j = 0; j < suffixes_0.length; j++) {
                            if (word.endsWith(suffixes_0[j]) && word.substring(0, word.length() - 1).equals(allWords[k])) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static boolean preSuffix(String word) {
        String temp = "", temp2 = "";
        for (int n = 0; n < theNouns.length; n++) {
            if (word.equals(theNouns[n])) {
                return true;
            }
        }
        for (int k = 0; k < prefixes.length; k++) {
            if (word.startsWith(prefixes[k])) {
                temp = word.replaceFirst(prefixes[k], "");
                temp2 = "እ"+word.replaceFirst(prefixes[k], "");
                for (int n = 0; n < theNouns.length; n++) {
                    if (temp.equals(theNouns[n]) || temp2.equals(theNouns[n])) {
                        return true;
                    }
                }
                if (suffix(temp, 0)) {
                    return true;
                }
                if (suffix(temp2, 0)) {
                    return true;
                }
            }
        }
        for (int k = 0; k < prefixes_2.length; k++) {
            if (word.startsWith(prefixes_2[k])) {
                temp = "አ" + word.replaceFirst(prefixes_2[k], "");
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
        String temp = "", temp2 = "", temp3 = "", temp4 = "", temp5 = "";
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
            } else if (fromWhere == 2) {
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
                if (word.length() > 1 && (getLastLetterBegginingPosition(word) == 1
                        || getLastLetterBegginingPosition(word) == 4
                        || getLastLetterBegginingPosition(word) == 7)) {
                    
                    temp = word.substring(0, word.length() - 1)
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

            } else if (fromWhere == 4) {
                if (word.length() > 2 && (word.endsWith("ት")
                        && (word.charAt(word.length() - 2) == 'ይ'
                        || getLastLetterBegginingPosition(word.substring(0, word.length() - 1)) == 2))) {
                    if (word.endsWith("ዊት")) {
                        temp = word.substring(0, word.length() - 1);
                    } else if (word.charAt(word.length() - 2) == 'ይ' || word.charAt(word.length() - 2) == 'ዪ') {
                        temp = word.substring(0, word.length() - 2);
                        temp2 = word.substring(0, word.length() - 2) + justChangeLetter(word.charAt(word.length() - 2), 5);
                    } else {
                        temp = word.substring(0, word.length() - 2) + justChangeLetter(word.charAt(word.length() - 2), 5);
                    }
                    
                    for (int n = 0; n < theNouns.length; n++) {
                        if (temp.equals(theNouns[n]) || temp2.equals(theNouns[n])) {
                            return true;
                        }
                    }
                }
                if (word.length() > 2 && (word.endsWith("ች")
                        && getLastLetterBegginingPosition(word.substring(0, word.length() - 1)) == 6)) {
                    temp2 = "";
                    if (word.endsWith("ዎች")) {
                        temp = word.substring(0, word.length() - 2);
                    } else {
                        temp = word.substring(0, word.length() - 2)
                                + justChangeLetter(word.charAt(word.length() - 2), 5);
                        temp2 = word.substring(0, word.length() - 2)
                                + justChangeLetter(word.charAt(word.length() - 2), 3);
                    }
                    System.out.println("problemHere: "+word+" : "+temp+" : "+temp2);
                    for (int n = 0; n < theNouns.length; n++) {
                        if (temp.equals(theNouns[n]) || (!temp2.equals("") && temp2.equals(theNouns[n]))) {
                            return true;
                        }
                    }
                    if (suffix(temp, 4)) {
                        return true;
                    }
                    if (!temp2.equals("") && suffix(temp2, 4)) {
                        return true;
                    }
                    temp2 = "";
                }
                if (word.length() > 3 && (word.endsWith("ችሁ") || word.endsWith("ቸው")
                        || word.endsWith("ችን"))) {
                    
                    int end = 2;
                    if (word.charAt(word.length() - 3) == 'ያ') {
                        end = 3;
                    }
                    
                    if (word.length() >= 4 && end == 3) {
                        temp = word.substring(0, word.length() - 3);
                        temp2 = word.substring(0, word.length() - 2);
                        temp3 = word.substring(0, word.length() - 3) + "ዬ";
                        temp4 = word.substring(0, word.length() - 3) + "ዪ";
                        temp5 = word.substring(0, word.length() - 3) + "ይ";
                    } else if (word.length() >= 4 && end == 2) {
                        if (getLastLetterBegginingPosition(word.substring(0, word.length() - 2)) == 7) {
                            temp = word.substring(0, word.length() - 3)
                                    + justChangeLetter(word.charAt(word.length() - 3), 6);
                        } else {
                            temp = word.substring(0, word.length() - 2);
                            temp2 = word.substring(0, word.length() - 3)
                                    + justChangeLetter(word.charAt(word.length() - 3), 5);
                        }
                    }
                    for (int n = 0; n < theNouns.length; n++) {
                        if (temp.equals(theNouns[n]) || temp2.equals(theNouns[n])
                                || temp3.equals(theNouns[n]) || temp4.equals(theNouns[n]) || temp5.equals(theNouns[n])) {
                            return true;
                        }
                    }
                    if (suffix(temp, 4)) {
                        return true;
                    }
                    if (!temp2.equals("") && suffix(temp2, 4)) {
                        return true;
                    }
                    if (!temp3.equals("") && suffix(temp3, 4)) {
                        return true;
                    }
                    if (!temp4.equals("") && suffix(temp4, 4)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
