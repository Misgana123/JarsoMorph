/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;

/**
 *
 * @author Misgana
 */
public class sameStemCatacorizer {

    static FileWriter myWriter;
    static String tempSuffix,tempPrefix;
    static String[] prefixesOne = {"ስን", "ስት", "ስ2ይ", "ስ2", "ስ"};
    static String[] suffixesOne = {"1ብው6ት", "1ብ3ችህ1", "1ል3ችህ1", "1ልው6ት", "1ብ3ች0ው", "1ል3ች0ው", "2ይ3ች0ው", "ል3ች0ው",
        "ብ3ች0ው", "ብ3ችህ1", "ል3ችህ1", "1ል3ች1", "1ብ3ች1", "1ብው6", "ልው6ት", "ብ3ች1", "3ች0ው", "1ው6ት", "3ችህ1", "1ልው6",
        "7ችህ1", "ብው6ት", "1ብ3ት", "7ች0ው", "1ብ6ት", "1ብ0ት", "1ል0ት", "1ል3ት", "2ይ3ት", "ል3ች1", "1ል6ት", "1ልክ", "1ልሽ",
        "1ው6", "3ች1", "ብ0ት", "ል0ት", "ብ3ት", "ል3ት", "ብው6", "ብ6ት", "ልው6", "ል6ት", "1ብኝ", "1ልኝ", "1ብን", "1ልን", "7ች1",
        "1ብህ", "1ብክ", "1ብሽ", "1ልህ", "0ው", "3ት", "ብህ", "ብክ", "ብሽ", "ልህ", "ልክ", "ልሽ", "ው6", "ው6ት", "0ኝ", "2ኝ", "0ን",
        "2ን", "2ው", "1ኝ", "1ን", "1ት", "7ት", "ብኝ", "ልኝ", "ብን", "ልን", "1ህ", "1ክ", "1ሽ", "ህ", "ክ", "ው", "ኝ", "ን",
        "ሽ", "2", "1", ""};
    static String[] suffixesTwo = {"3ችህ1ብ3ች0ው", "3ችህ1ል3ች0ው", "3ች1ብ3ች0ው", "3ች1ል3ች0ው", "0ህ1ብ3ች0ው", "0ህ1ል3ች0ው", "0ህ1ብ3ችህ1", "0ህ1ል3ችህ1", "0ክ1ብ3ች0ው", "0ክ1ል3ች0ው", "0ክ1ብ3ችህ1", "0ክ1ል3ችህ1", "3ህ1ብ3ች0ው", "3ህ1ል3ች0ው", "3ህ1ብ3ችህ1", "3ህ1ል3ችህ1", "ህ1ብ3ች0ው", "ህ1ል3ች0ው", "ህ1ብ3ችህ1", "ህ1ል3ችህ1", "ክ1ብ3ች0ው", "ክ1ል3ች0ው", "ክ1ብ3ችህ1", "ክ1ል3ችህ1", "3ችህ7ች0ው", "3ችክ7ች0ው", "3ችህ1ብ0ት", "3ችህ1ል0ት", "3ችህ1ብ3ት", "3ችህ1ል3ት", "0ችብ3ች0ው", "0ችል3ች0ው", "0ችብ3ችህ1", "0ችል3ችህ1", "0ህ1ብ3ች1", "0ህ1ል3ች1", "0ህ1ብው6ት", "0ህ1ልው6ት", "0ክ1ብ3ች1", "0ክ1ል3ች1", "0ክ1ብው6ት", "0ክ1ልው6ት", "0ውብ3ች0ው", "0ውል3ች0ው", "0ውብ3ችህ1", "0ውል3ችህ1", "0ንብ3ች0ው", "0ንል3ች0ው", "0ንብ3ችህ1", "0ንል3ችህ1", "0ህብ3ች0ው", "0ህል3ች0ው", "0ሽብ3ች0ው", "0ሽል3ች0ው", "0ክብ3ች0ው", "0ክል3ች0ው", "3ችው3ች0ው", "3ህ1ብ3ች1", "3ህ1ል3ች1", "3ህ1ብው6ት", "3ህ1ልው6ት", "3ውብ3ች0ው", "3ውል3ች0ው", "3ውብ3ችህ1", "3ውል3ችህ1", "3ንብ3ች0ው", "3ንል3ች0ው", "3ንብ3ችህ1", "3ንል3ችህ1", "3ህብ3ች0ው", "3ህል3ች0ው", "3ሽብ3ች0ው", "3ሽል3ች0ው", "3ክብ3ች0ው", "3ክል3ች0ው", "3ችብ3ች0ው", "3ችል3ች0ው", "3ችብ3ችህ1", "3ችል3ችህ1", "7ችብ3ች0ው", "7ችል3ች0ው", "7ችብ3ችህ1", "7ችል3ችህ1", "ህ1ብ3ች1", "ህ1ል3ች1", "ህ1ብው6ት", "ህ1ልው6ት", "ክ1ብ3ች1", "ክ1ል3ች1", "ክ1ብው6ት", "ክ1ልው6ት", "ንብ3ች0ው", "ንል3ች0ው", "ንብ3ችህ1", "ንል3ችህ1", "ህብ3ች0ው", "ህል3ች0ው", "ሽብ3ች0ው", "ሽል3ች0ው", "ክብ3ች0ው", "ክል3ች0ው", "3ች7ች0ው", "3ች1ብ0ት", "3ች1ል0ት", "3ች1ብ3ት", "3ች1ል3ት", "3ችህ1ብኝ", "3ችህ1ልኝ", "3ችህ1ብን", "3ችህ1ልን", "0ብ3ች0ው", "0ል3ች0ው", "0ብ3ችህ1", "0ል3ችህ1", "0ች3ች0ው", "0ች3ችህ1", "0ችብ3ች1", "0ችል3ች1", "0ችብው6ት", "0ችልው6ት", "1ብ3ች0ው", "1ል3ች0ው", "1ብ3ችህ1", "1ል3ችህ1", "0ህ7ች0ው", "0ው3ች0ው", "0ህ7ችህ1", "0ው3ችህ1", "0ህ1ብ0ት", "0ህ1ል0ት", "0ህ1ብ3ት", "0ህ1ል3ት", "0ህ1ብው6", "0ህ1ብ6ት", "0ህ1ልው6", "0ህ1ል6ት", "0ክ1ብ0ት", "0ክ1ል0ት", "0ክ1ብ3ት", "0ክ1ል3ት", "0ክ1ብው6", "0ክ1ብ6ት", "0ክ1ልው6", "0ክ1ል6ት", "0ውብ3ች1", "0ውል3ች1", "0ውብው6ት", "0ውልው6ት", "0ህ1ው6ት", "0ክ1ው6ት", "0ን3ች0ው", "0ን3ችህ1", "0ንብ3ች1", "0ንል3ች1", "0ንብው6ት", "0ንልው6ት", "0ህ3ች0ው", "0ሽ3ች0ው", "0ክ3ች0ው", "3ህ7ች0ው", "3ው3ች0ው", "3ህ7ችህ1", "3ው3ችህ1", "3ህ1ብ0ት", "3ህ1ል0ት", "3ህ1ብ3ት", "3ህ1ል3ት", "3ህ1ብው6", "3ህ1ብ6ት", "3ህ1ልው6", "3ህ1ል6ት", "3ውብ3ች1", "3ውል3ች1", "3ውብው6ት", "3ውልው6ት", "3ህ1ው6ት", "3ን3ች0ው", "3ን3ችህ1", "3ንብ3ች1", "3ንል3ች1", "3ንብው6ት", "3ንልው6ት", "3ህ3ች0ው", "3ሽ3ች0ው", "3ብ3ች0ው", "3ል3ች0ው", "3ብ3ችህ1", "3ል3ችህ1", "3ች3ች0ው", "3ች3ችህ1", "3ችብ3ች1", "3ችል3ች1", "3ችብው6ት", "3ችልው6ት", "7ብ3ች0ው", "7ል3ች0ው", "7ብ3ችህ1", "7ል3ችህ1", "7ች3ች0ው", "7ች3ችህ1", "7ችብ3ች1", "7ችል3ች1", "7ችብው6ት", "7ችልው6ት", "ህ1ብ0ት", "ህ1ል0ት", "ህ1ብ3ት", "ህ1ል3ት", "ህ1ብው6", "ህ1ብ6ት", "ህ1ልው6", "ህ1ል6ት", "ክ1ብ0ት", "ክ1ል0ት", "ክ1ብ3ት", "ክ1ል3ት", "ክ1ብው6", "ክ1ብ6ት", "ክ1ልው6", "ክ1ል6ት", "ህ1ው6ት", "ክ1ው6ት", "ን3ች0ው", "ን3ችህ1", "ንብ3ች1", "ንል3ች1", "ንብው6ት", "ንልው6ት", "ህ3ች0ው", "ሽ3ች0ው", "ክ3ች0ው", "3ችህ1ኝ", "3ችክ1ኝ", "3ችህ1ን", "3ችክ1ን", "3ችህ1ት", "3ችክ1ት", "3ችህ7ት", "3ችክ7ት", "3ች1ብኝ", "3ች1ልኝ", "3ች1ብን", "3ች1ልን", "0ብ3ች1", "0ል3ች1", "0ብው6ት", "0ልው6ት", "0ች3ች1", "0ችብ0ት", "0ችል0ት", "0ችብ3ት", "0ችል3ት", "0ችብው6", "0ችብ6ት", "0ችልው6", "0ችል6ት", "1ብ3ች1", "1ል3ች1", "1ብው6ት", "1ልው6ት", "0ህ7ች1", "0ው3ች1", "0ህ1ብህ", "0ህ1ብክ", "0ህ1ብሽ", "0ህ1ልህ", "0ህ1ልክ", "0ህ1ልሽ", "0ክ1ብህ", "0ክ1ብክ", "0ክ1ብሽ", "0ክ1ልህ", "0ክ1ልክ", "0ክ1ልሽ", "0ውብ0ት", "0ውል0ት", "0ውብ3ት", "0ውል3ት", "0ውብው6", "0ውብ6ት", "0ውልው6", "0ውል6ት", "0ህ1ው6", "0ውው6ት", "0ክ1ው6", "0ን3ች1", "0ንብ0ት", "0ንል0ት", "0ንብ3ት", "0ንል3ት", "0ንብው6", "0ንብ6ት", "0ንልው6", "0ንል6ት", "0ህብ0ት", "0ህል0ት", "0ህብ3ት", "0ህል3ት", "0ሽብ0ት", "0ሽል0ት", "0ሽብ3ት", "0ሽል3ት", "0ክብ0ት", "0ክል0ት", "0ክብ3ት", "0ክል3ት", "3ችው3ት", "3ህ7ች1", "3ው3ች1", "3ህ1ብህ", "3ህ1ብክ", "3ህ1ብሽ", "3ህ1ልህ", "3ህ1ልክ", "3ህ1ልሽ", "3ውብ0ት", "3ውል0ት", "3ውብ3ት", "3ውል3ት", "3ውብው6", "3ውብ6ት", "3ውልው6", "3ውል6ት", "3ህ1ው6", "3ውው6ት", "3ን3ች1", "3ንብ0ት", "3ንል0ት", "3ንብ3ት", "3ንል3ት", "3ንብው6", "3ንብ6ት", "3ንልው6", "3ንል6ት", "3ህብ0ት", "3ህል0ት", "3ህብ3ት", "3ህል3ት", "3ሽብ0ት", "3ሽል0ት", "3ሽብ3ት", "3ሽል3ት", "3ክብ0ት", "3ክል0ት", "3ክብ3ት", "3ክል3ት", "3ብ3ች1", "3ል3ች1", "3ብው6ት", "3ልው6ት", "3ች3ች1", "3ችብ0ት", "3ችል0ት", "3ችብ3ት", "3ችል3ት", "3ችብው6", "3ችብ6ት", "3ችልው6", "3ችል6ት", "ህ7ች0ው", "ክ7ች0ው", "ህ7ችህ1", "ክ7ችህ1", "7ችብ0ት", "7ችል0ት", "7ችብ6ት", "7ችል6ት", "7ብ3ች1", "7ል3ች1", "7ብው6ት", "7ልው6ት", "7ች3ች1", "7ችብ3ት", "7ችል3ት", "7ችብው6", "7ችልው6", "ህ1ልክ", "ህ1ልሽ", "ክ1ብህ", "ክ1ብክ", "ክ1ብሽ", "ክ1ልህ", "ክ1ልክ", "ክ1ልሽ", "ህ1ው6", "ክ1ው6", "ን3ች1", "ንብ0ት", "ንል0ት", "ንብ3ት", "ንል3ት", "ንብው6", "ንብ6ት", "ንልው6", "ንል6ት", "ህብ0ት", "ህል0ት", "ህብ3ት", "ህል3ት", "ሽብ0ት", "ሽል0ት", "ሽብ3ት", "ሽል3ት", "ክብ0ት", "ክል0ት", "ክብ3ት", "ክል3ት", "3ች1ኝ", "3ች1ን", "3ች1ት", "3ች7ት", "3ችህ1", "3ች0ው", "0ብ0ት", "0ል0ት", "0ብ3ት", "0ል3ት", "0ብው6", "0ብ6ት", "0ልው6", "0ል6ት", "0ው6ት", "0ች3ት", "0ችብኝ", "0ችልኝ", "0ችብን", "0ችልን", "0ችብህ", "0ችብክ", "0ችብሽ", "0ችልህ", "0ችልክ", "0ችልሽ", "7ች0ው", "7ችህ1", "1ብ0ት", "1ል0ት", "1ብ3ት", "1ል3ት", "1ብው6", "1ብ6ት", "1ልው6", "1ል6ት", "1ው6ት", "0ህ1ህ", "0ህ1ክ", "0ህ1ሽ", "0ህ1ት", "0ክ1ት", "0ህ7ት", "0ው3ት", "0ውብህ", "0ውብክ", "0ውብሽ", "0ውልህ", "0ውልክ", "0ውልሽ", "0ውው6", "0ን0ው", "0ን3ት", "0ንብህ", "0ንብክ", "0ንብሽ", "0ንልህ", "0ንልክ", "0ንልሽ", "0ክ0ኝ", "0ኽ0ኝ", "0ክ0ን", "0ኽ0ን", "0ክ0ው", "0ኽ0ው", "0ህ3ት", "0ሽ3ት", "0ክ3ት", "0ህብኝ", "0ህልኝ", "0ህብን", "0ህልን", "0ሽብኝ", "0ሽልኝ", "0ሽብን", "0ሽልን", "0ክብኝ", "0ክልኝ", "0ክብን", "0ክልን", "3ችውኝ", "3ችውን", "3ችውት", "3ህ1ህ", "3ህ1ክ", "3ህ1ሽ", "3ህ1ት", "3ህ7ት", "3ው3ት", "3ውብህ", "3ውብክ", "3ውብሽ", "3ውልህ", "3ውልክ", "3ውልሽ", "3ውው6", "3ን0ው", "3ን3ት", "3ንብህ", "3ንብክ", "3ንብሽ", "3ንልህ", "3ንልክ", "3ንልሽ", "3ው6ት", "3ክ0ኝ", "3ኽ0ኝ", "3ክ0ን", "3ኽ0ን", "3ክ0ው", "3ኽ0ው", "3ህ3ት", "3ሽ3ት", "3ህብኝ", "3ህልኝ", "3ህብን", "3ህልን", "3ሽብኝ", "3ሽልኝ", "3ሽብን", "3ሽልን", "3ክብኝ", "3ክልኝ", "3ክብን", "3ክልን", "3ብ0ት", "3ል0ት", "3ብ3ት", "3ል3ት", "3ብው6", "3ብ6ት", "3ልው6", "3ል6ት", "3ች3ት", "3ችብኝ", "3ችልኝ", "3ችብን", "3ችልን", "3ችብህ", "3ችብክ", "3ችብሽ", "3ችልህ", "3ችልክ", "3ችልሽ", "ህ7ች1", "ክ7ች1", "ህ1ብህ", "ህ1ብክ", "ህ1ብሽ", "ህ1ልህ", "7ብ0ት", "7ል0ት", "7ብ6ት", "7ል6ት", "7ችብኝ", "7ችልኝ", "7ብ3ት", "7ል3ት", "7ብው6", "7ልው6", "7ው6ት", "7ች3ት", "7ችብን", "7ችልን", "7ችብህ", "7ችብክ", "7ችብሽ", "7ችልህ", "7ችልክ", "7ችልሽ", "1ው6", "ን0ው", "ን3ት", "ንብህ", "ንብክ", "ንብሽ", "ንልህ", "ንልክ", "ንልሽ", "ው6ት", "ክ0ኝ", "ኽ0ኝ", "ክ0ን", "ኽ0ን", "ክ0ው", "ኽ0ው", "ህ3ት", "ሽ3ት", "ክ3ት", "ህብኝ", "ህልኝ", "ህብን", "ህልን", "ሽብኝ", "ሽልኝ", "ሽብን", "ሽልን", "ክብኝ", "ክልኝ", "ክብን", "ክልን", "3ች1", "0ብኝ", "0ልኝ", "0ብን", "0ልን", "0ብህ", "0ብክ", "0ብሽ", "0ልህ", "0ልክ", "0ልሽ", "0ው6", "0ችኝ", "0ችን", "0ችህ", "0ችክ", "0ችሽ", "0ችው", "7ች1", "1ብኝ", "1ልኝ", "1ብን", "1ልን", "1ብህ", "1ብክ", "1ብሽ", "1ልህ", "1ልክ", "1ልሽ", "0ውህ", "0ውክ", "0ውሽ", "0ውት", "0ህ1", "0ክ1", "0ንህ", "0ንክ", "0ንሽ", "0ሽኝ", "0ሽን", "0ሽው", "3ውህ", "3ውክ", "3ውሽ", "3ውት", "3ህ1", "3ንህ", "3ንክ", "3ንሽ", "3ው6", "3ሽኝ", "3ሽን", "3ሽው", "3ብኝ", "3ልኝ", "3ብን", "3ልን", "3ብህ", "3ብክ", "3ብሽ", "3ልህ", "3ልክ", "3ልሽ", "3ችኝ", "3ችን", "3ችህ", "3ችክ", "3ችሽ", "3ችው", "ህ1ህ", "ህ1ክ", "ህ1ሽ", "ክ1ህ", "ክ1ክ", "ክ1ሽ", "ህ1ት", "ክ1ት", "ህ7ት", "ክ7ት", "7ብኝ", "7ልኝ", "7ችኝ", "7ችው", "7ችል", "7ብን", "7ልን", "7ብህ", "7ብክ", "7ብሽ", "7ልህ", "7ልክ", "7ልሽ", "7ው6", "7ችን", "7ችህ", "7ችክ", "7ችሽ", "ክ1", "ንህ", "ንክ", "ንሽ", "ው6", "ሽኝ", "ሽን", "ሽው", "0ኝ", "0ን", "0ህ", "0ክ", "0ሽ", "0ው", "3ት", "0ች", "1ኝ", "1ን", "1ህ", "1ክ", "1ሽ", "1ት", "7ት", "3ው", "3ን", "3ህ", "3ሽ", "3ክ", "3ኝ", "3ች", "ህ1", "7ኝ", "7ው", "7ል", "7ን", "7ህ", "7ክ", "7ሽ", "7ች", "ን", "ህ", "ሽ", "ክ", "0", "1", "3", "7"};
    static String[] suffixesThree = {"1ብ3ች0ው3ል3ችህ1", "1ል3ች0ው3ል3ችህ1", "1ብ3ች0ው3ል3ች1", "1ል3ች0ው3ል3ች1", "2ይ3ች0ው3ል0ህ", "2ይ3ች0ው3ል0ሽ", "1ብ0ት3ል3ችህ1", "1ብ3ት3ል3ችህ1", "3ብ3ች0ው3ል0ች", "3ብ3ች1ው3ል0ች", "1ል0ት3ል3ችህ1", "1ል3ት3ል3ችህ1", "3ል3ች0ው3ል0ች", "3ል3ች1ው3ል0ች", "1ብኝ3ል3ችህ1", "1ብን3ል3ችህ1", "1ብ0ት3ል3ች1", "1ብ3ት3ል3ች1", "ብ3ች0ው3ል0ች", "ብ3ች1ው3ል0ች", "3ብ3ችህ7ል0ች", "3ብው6ት3ል0ች", "1ልኝ3ል3ችህ1", "1ልን3ል3ችህ1", "1ል0ት3ል3ች1", "1ል3ት3ል3ች1", "ል3ች0ው3ል0ች", "ል3ች1ው3ል0ች", "3ል3ችህ7ል0ች", "3ልው6ት3ል0ች", "2ይ3ት3ል0ህ", "2ይ3ት3ል0ሽ", "3ች0ው3ል0ህ", "3ች0ው3ል0ክ", "1ኝ3ል3ችህ1", "1ን3ል3ችህ1", "1ት3ል3ችህ1", "7ት3ል3ችህ1", "7ች3ል3ችህ1", "7ች7ል3ችህ1", "3ች0ው3ል0ች", "3ት3ል3ችህ1", "3ች3ል3ችህ1", "3ች7ል3ችህ1", "3ው6ት3ል0ች", "1ብኝ3ል3ች1", "1ብን3ል3ች1", "ብ3ችህ7ል0ች", "ብው6ት3ል0ች", "3ብ0ት3ል0ች", "3ብ3ት3ል0ች", "3ብ3ች7ል0ች", "3ብ6ት3ል0ች", "1ልኝ3ል3ች1", "1ልን3ል3ች1", "ል3ችህ7ል0ች", "ልው6ት3ል0ች", "3ል0ት3ል0ች", "3ል3ት3ል0ች", "3ል3ች7ል0ች", "3ል6ት3ል0ች", "1ኝ3ል3ች1", "1ን3ል3ች1", "1ት3ል3ች1", "7ት3ል3ች1", "7ች3ል3ች1", "7ች7ል3ች1", "3ችህ7ል0ች", "ው6ት3ል0ች", "3ት3ል3ች1", "3ች3ል3ች1", "3ች7ል3ች1", "ብ0ት3ል0ች", "ብ3ት3ል0ች", "ብ3ች7ል0ች", "ብ6ት3ል0ች", "3ብኝ3ል0ች", "3ብን3ል0ች", "3ብህ3ል0ች", "3ብክ3ል0ች", "3ብሽ3ል0ች", "ል0ት3ል0ች", "ል3ት3ል0ች", "ል3ች7ል0ች", "ል6ት3ል0ች", "3ልኝ3ል0ች", "3ልን3ል0ች", "3ልህ3ል0ች", "3ልክ3ል0ች", "3ልሽ3ል0ች", "0ኝ3ል0ህ", "0ኝ3ል0ክ", "2ኝ3ል0ህ", "2ኝ3ል0ሽ", "0ን3ል0ህ", "0ን3ል0ክ", "2ን3ል0ህ", "2ን3ል0ሽ", "0ው3ል0ህ", "0ው3ል0ክ", "2ው3ል0ህ", "2ው3ል0ሽ", "3ት3ል0ህ", "3ት3ል0ክ", "2ይ3ል0ህ", "2ይ3ል0ሽ", "3ል3ችህ1", "0ኝ3ል0ች", "0ን3ል0ች", "0ው3ል0ች", "3ት3ል0ች", "3ች7ል0ች", "6ት3ል0ች", "3ኝ3ል0ህ", "3ኝ3ል0ክ", "3ን3ል0ህ", "3ን3ል0ክ", "3ው3ል0ህ", "3ው3ል0ክ", "3ኝ3ል0ች", "3ን3ል0ች", "3ህ3ል0ች", "3ክ3ል0ች", "3ሽ3ል0ች", "3ው3ል0ች", "ብኝ3ል0ች", "ብን3ል0ች", "ብህ3ል0ች", "ብክ3ል0ች", "ብሽ3ል0ች", "ልኝ3ል0ች", "ልን3ል0ች", "ልህ3ል0ች", "ልክ3ል0ች", "ልሽ3ል0ች", "3ል3ች1", "ህ3ል0ች", "ክ3ል0ች", "ሽ3ል0ች", "3ል0ህ", "3ል0ክ", "3ል0ች", "3ብው6", "3ልው6", "ብው6", "ልው6", "3ብ3ች0ው3ል0ን", "3ብ3ች1ው3ል0ን", "3ል3ች0ው3ል0ን", "3ል3ች1ው3ል0ን", "ብ3ች0ው3ል0ን", "ብ3ች1ው3ል0ን", "3ብ3ችህ7ል0ን", "3ብው6ት3ል0ን", "ል3ች0ው3ል0ን", "ል3ች1ው3ል0ን", "3ል3ችህ7ል0ን", "3ልው6ት3ል0ን", "3ች0ው3ል0ን", "3ች1ህ3ል0ን", "3ች1ው3ል0ን", "3ው6ት3ል0ን", "ብ3ችህ7ል0ን", "ብው6ት3ል0ን", "3ብ0ት3ል0ን", "3ብ3ት3ል0ን", "3ብ3ች7ል0ን", "3ብ6ት3ል0ን", "ል3ችህ7ል0ን", "ልው6ት3ል0ን", "3ል0ት3ል0ን", "3ል3ት3ል0ን", "3ል3ች7ል0ን", "3ል6ት3ል0ን", "3ችህ7ል0ን", "ው6ት3ል0ን", "ብ0ት3ል0ን", "ብ3ት3ል0ን", "ብ3ች7ል0ን", "ብ6ት3ል0ን", "3ብህ3ል0ን", "3ብክ3ል0ን", "3ብሽ3ል0ን", "ል0ት3ል0ን", "ል3ት3ል0ን", "ል3ች7ል0ን", "ል6ት3ል0ን", "3ልህ3ል0ን", "3ልክ3ል0ን", "3ልሽ3ል0ን", "0ው3ል0ን", "3ት3ል0ን", "3ች7ል0ን", "6ት3ል0ን", "3ህ3ል0ን", "3ክ3ል0ን", "3ሽ3ል0ን", "3ው3ል0ን", "ብህ3ል0ን", "ብክ3ል0ን", "ብሽ3ል0ን", "ልህ3ል0ን", "ልክ3ል0ን", "ልሽ3ል0ን", "ህ3ል0ን", "ክ3ል0ን", "ሽ3ል0ን", "3ል0ን", "3ብው6", "3ልው6", "ብው6", "ልው6", "1ብ3ች0ው3ል", "1ብ3ች1ው3ል", "3ብ3ች0ው3ል", "3ብ3ች1ው3ል", "1ል3ች0ው3ል", "1ል3ች1ው3ል", "3ል3ች0ው3ል", "3ል3ች1ው3ል", "ብ3ች0ው3ል", "ብ3ች1ው3ል", "1ብ3ችህ7ል", "1ብው6ት3ል", "3ብ3ችህ7ል", "3ብው6ት3ል", "ል3ች0ው3ል", "ል3ች1ው3ል", "1ል3ችህ7ል", "1ልው6ት3ል", "3ል3ችህ7ል", "3ልው6ት3ል", "3ች0ው3ል", "3ች1ህ3ል", "3ች1ው3ል", "7ች0ው3ል", "7ች1ህ3ል", "7ች1ው3ል", "1ው6ት3ል", "3ው6ት3ል", "ብ3ችህ7ል", "ብው6ት3ል", "1ብ0ት3ል", "1ብ3ት3ል", "1ብ3ች7ል", "1ብ6ት3ል", "3ብ0ት3ል", "3ብ3ት3ል", "3ብ3ች7ል", "3ብ6ት3ል", "ል3ችህ7ል", "ልው6ት3ል", "1ል0ት3ል", "1ል3ት3ል", "1ል3ች7ል", "1ል6ት3ል", "3ል0ት3ል", "3ል3ት3ል", "3ል3ች7ል", "3ል6ት3ል", "3ችህ7ል", "ው6ት3ል", "7ችህ7ል", "ብ0ት3ል", "ብ3ት3ል", "ብ3ች7ል", "ብ6ት3ል", "1ብኝ3ል", "1ብን3ል", "1ብህ3ል", "1ብክ3ል", "1ብሽ3ል", "3ብኝ3ል", "3ብን3ል", "3ብህ3ል", "3ብክ3ል", "3ብሽ3ል", "ል0ት3ል", "ል3ት3ል", "ል3ች7ል", "ል6ት3ል", "1ልኝ3ል", "1ልን3ል", "1ልህ3ል", "1ልክ3ል", "1ልሽ3ል", "3ልኝ3ል", "3ልን3ል", "3ልህ3ል", "3ልክ3ል", "3ልሽ3ል", "0ኝ3ል", "0ን3ል", "0ው3ል", "3ት3ል", "3ች7ል", "6ት3ል", "1ኝ3ል", "1ን3ል", "1ህ3ል", "1ክ3ል", "1ሽ3ል", "1ት3ል", "7ት3ል", "7ች7ል", "3ኝ3ል", "3ን3ል", "3ህ3ል", "3ክ3ል", "3ሽ3ል", "3ው3ል", "ብኝ3ል", "ብን3ል", "ብህ3ል", "ብክ3ል", "ብሽ3ል", "1ብው6", "3ብው6", "ልኝ3ል", "ልን3ል", "ልህ3ል", "ልክ3ል", "ልሽ3ል", "1ልው6", "3ልው6", "ህ3ል", "ክ3ል", "ሽ3ል", "3ል1", "ብው6", "ልው6", "3ል", "3ብ3ች0ው3ል0ህ1", "3ብ3ች1ው3ል0ህ1", "3ል3ች0ው3ል0ህ1", "3ል3ች1ው3ል0ህ1", "ብ3ች0ው3ል0ህ1", "ብ3ች1ው3ል0ህ1", "3ብ3ች0ው3ል0ው", "3ብ3ችህ7ል0ህ1", "3ብ3ች1ው3ል0ው", "3ብው6ት3ል0ህ1", "ል3ች0ው3ል0ህ1", "ል3ች1ው3ል0ህ1", "3ል3ች0ው3ል0ው", "3ል3ችህ7ል0ህ1", "3ል3ች1ው3ል0ው", "3ልው6ት3ል0ህ1", "3ች0ው3ል0ህ1", "3ች1ህ3ል0ህ1", "3ች1ው3ል0ህ1", "3ው6ት3ል0ህ1", "ብ3ች0ው3ል0ው", "ብ3ችህ7ል0ህ1", "ብ3ች1ው3ል0ው", "ብው6ት3ል0ህ1", "3ብ0ት3ል0ህ1", "3ብ3ት3ል0ህ1", "3ብ3ችህ7ል0ው", "3ብ3ች7ል0ህ1", "3ብው6ት3ል0ው", "3ብ6ት3ል0ህ1", "ል3ች0ው3ል0ው", "ል3ችህ7ል0ህ1", "ል3ች1ው3ል0ው", "ልው6ት3ል0ህ1", "3ል0ት3ል0ህ1", "3ል3ት3ል0ህ1", "3ል3ችህ7ል0ው", "3ል3ች7ል0ህ1", "3ልው6ት3ል0ው", "3ል6ት3ል0ህ1", "3ች0ው3ል0ው", "3ችህ7ል0ህ1", "3ች1ህ3ል0ው", "3ች1ው3ል0ው", "ው6ት3ል0ህ1", "3ው6ት3ል0ው", "ብ0ት3ል0ህ1", "ብ3ት3ል0ህ1", "ብ3ችህ7ል0ው", "ብ3ች7ል0ህ1", "ብው6ት3ል0ው", "ብ6ት3ል0ህ1", "3ብህ3ል0ህ1", "3ብክ3ል0ህ1", "3ብሽ3ል0ህ1", "3ብ0ት3ል0ው", "3ብ3ት3ል0ው", "3ብ3ች7ል0ው", "3ብ6ት3ል0ው", "ል0ት3ል0ህ1", "ል3ት3ል0ህ1", "ል3ችህ7ል0ው", "ል3ች7ል0ህ1", "ልው6ት3ል0ው", "ል6ት3ል0ህ1", "3ልህ3ል0ህ1", "3ልክ3ል0ህ1", "3ልሽ3ል0ህ1", "3ል0ት3ል0ው", "3ል3ት3ል0ው", "3ል3ች7ል0ው", "3ል6ት3ል0ው", "0ው3ል0ህ1", "3ት3ል0ህ1", "3ች7ል0ህ1", "3ችህ7ል0ው", "6ት3ል0ህ1", "ው6ት3ል0ው", "3ህ3ል0ህ1", "3ክ3ል0ህ1", "3ሽ3ል0ህ1", "3ው3ል0ህ1", "ብህ3ል0ህ1", "ብክ3ል0ህ1", "ብሽ3ል0ህ1", "ብ0ት3ል0ው", "ብ3ት3ል0ው", "ብ3ች7ል0ው", "ብ6ት3ል0ው", "3ብህ3ል0ው", "3ብክ3ል0ው", "3ብሽ3ል0ው", "ልህ3ል0ህ1", "ልክ3ል0ህ1", "ልሽ3ል0ህ1", "ል0ት3ል0ው", "ል3ት3ል0ው", "ል3ች7ል0ው", "ል6ት3ል0ው", "3ልህ3ል0ው", "3ልክ3ል0ው", "3ልሽ3ል0ው", "ህ3ል0ህ1", "ክ3ል0ህ1", "ሽ3ል0ህ1", "0ው3ል0ው", "3ት3ል0ው", "3ች7ል0ው", "6ት3ል0ው", "3ህ3ል0ው", "3ክ3ል0ው", "3ሽ3ል0ው", "3ው3ል0ው", "ብህ3ል0ው", "ብክ3ል0ው", "ብሽ3ል0ው", "ልህ3ል0ው", "ልክ3ል0ው", "ልሽ3ል0ው", "ህ3ል0ው", "ክ3ል0ው", "ሽ3ል0ው", "3ል0ህ1", "3ል0ው", "3ብው6", "3ልው6", "ብው6", "ልው6", "ብው", "ልው"};
    static String[] prefixesThree = {"ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};

    static String[] suffixesFour = {"3ችህ1ብ3ች0ው","3ችህ1ል3ች0ው","3ች1ው3ች0ው","3ች1ብ3ች0ው","3ች1ል3ች0ው","ህ1ብ3ች0ው","ህ1ል3ች0ው","0ንብ3ች0ው","0ንል3ች0ው","0ንብ3ችህ1","0ንል3ችህ1","0ህብ3ች0ው","0ህል3ች0ው","0ክብ3ች0ው","0ክል3ች0ው","0ሽብ3ች0ው","0ሽል3ች0ው","0ውብ3ች0ው","0ውል3ች0ው","0ውብ3ችህ1","0ውል3ችህ1","3ችህ7ች0ው","3ችው3ች0ው","3ችህ1ብ0ት","3ችህ1ል0ት","3ችህ1ብ3ት","3ችህ1ል3ት","1ው3ች0ው","1ብ3ች0ው","1ል3ች0ው","4ይ3ች0ው","4እ0ች0ው","2ይ3ች0ው","2እ0ች0ው","4እ0ችህ1","4ይ3ችህ1","2እ0ችህ1","2ይ3ችህ1","4ብ3ች0ው","4ል3ች0ው","4ብ3ችህ1","4ል3ችህ1","0ን3ች0ው","0ን3ችህ1","0ንብ3ችው","0ንብ3ች1","0ንል3ችው","0ንል3ች1","0ንብው6ት","0ንልው6ት","0ህ3ች0ው","0ሽ3ች0ው","6ብ3ች0ው","6ል3ች0ው","6ብ3ችህ1","6ል3ችህ1","3ብ3ች0ው","3ል3ች0ው","3ብ3ችህ1","3ል3ችህ1","0ው3ች0ው","0ው3ችህ1","0ውብ3ችው","0ውብ3ች1","0ውል3ችው","0ውል3ች1","0ውብው6ት","0ውልው6ት","3ች1ህ3ት","3ች1ው3ት","3ች7ች0ው","3ች1ብ0ት","3ች1ል0ት","3ች1ብ3ት","3ች1ል3ት","3ችህ1ብኝ","3ችህ1ልኝ","3ችህ1ብን","3ችህ1ልን","ህ7ች0ው","ው3ች0ው","ህ1ብ0ት","ህ1ል0ት","ህ1ብ3ት","ህ1ል3ት","4ይ3ች1","4እ0ች1","2ይ3ች1","2እ0ች1","4ብ3ችው","4ብ3ች1","4ል3ችው","4ል3ች1","4ብው6ት","4ልው6ት","0ን3ች1","0ንብ0ት","0ንል0ት","0ንብ3ት","0ንል3ት","0ንብው6","0ንብ6ት","0ንልው6","0ንል6ት","0ንው6ት","0ህብ0ት","0ህል0ት","0ህብ3ት","0ህል3ት","0ክብ0ት","0ክል0ት","0ክብ3ት","0ክል3ት","0ሽብ0ት","0ሽል0ት","0ሽብ3ት","0ሽል3ት","6ብ3ችው","6ብ3ች1","6ል3ችው","6ል3ች1","6ብው6ት","6ልው6ት","3ብ3ችው","3ብ3ች1","3ል3ችው","3ል3ች1","3ብው6ት","3ልው6ት","0ው3ች1","0ውብ0ት","0ውል0ት","0ውብ3ት","0ውል3ት","0ውብው6","0ውብ6ት","0ውልው6","0ውል6ት","3ችህ1ኝ","3ችህ1ን","3ችህ1ት","3ችህ7ት","3ችው3ት","3ች1ብኝ","3ች1ልኝ","3ች1ብን","3ች1ልን","1ህ3ት","1ው3ት","7ች0ው","1ብ0ት","1ል0ት","1ብ3ት","1ል3ት","ህ1ብኝ","ህ1ልኝ","ህ1ብን","ህ1ልን","4እ0ት","4ይ3ት","2እ0ት","2ይ3ት","4ብ0ት","4ል0ት","4ብ3ት","4ል3ት","4ብው6","4ብ6ት","4ልው6","4ል6ት","4ው6ት","0ን0ው","0ን3ት","0ንብህ","0ንብክ","0ንብሽ","0ንልህ","0ንልክ","0ንልሽ","0ንው6","0ኽ0ኝ","0ክ0ኝ","0ሽ2ኝ","0ኽ0ን","0ክ0ን","0ሽ2ን","0ኽ0ው","0ክ0ው","0ሽ2ው","0ህ3ት","0ሽ3ት","0ህብኝ","0ህልኝ","0ህብን","0ህልን","0ክብኝ","0ክልኝ","0ክብን","0ክልን","0ሽብኝ","0ሽልኝ","0ሽብን","0ሽልን","7ችህ1","6ብ0ት","6ል0ት","6ብ3ት","6ል3ት","6ብው6","6ብ6ት","6ልው6","6ል6ት","6ው6ት","3ብ0ት","3ል0ት","3ብ3ት","3ል3ት","3ብው6","3ብ6ት","3ልው6","3ል6ት","3ው6ት","0ው3ት","0ውብኝ","0ውልኝ","0ውብን","0ውልን","0ውብህ","0ውብክ","0ውብሽ","0ውልህ","0ውልክ","0ውልሽ","0ው6ት","3ች1ኝ","3ች1ን","3ች1ት","3ች7ት","3ችህ1","3ች0ው","ህ1ኝ","ህ1ን","ህ1ት","ህ7ት","ው3ት","1ብኝ","1ልኝ","1ብን","1ልን","4ብህ","4ብክ","4ብሽ","4ልህ","4ልክ","4ልሽ","4ው6","0ንህ","0ንክ","0ንሽ","0ሽኝ","0ሽን","0ሽው","7ች1","6ብኝ","6ልኝ","6ብን","6ልን","6ብህ","6ብክ","6ብሽ","6ልህ","6ልክ","6ልሽ","6ው6","3ብኝ","3ልኝ","3ብን","3ልን","3ብህ","3ብክ","3ብሽ","3ልህ","3ልክ","3ልሽ","3ው6","0ውኝ","0ውን","0ውህ","0ውክ","0ውሽ","0ውት","0ው6","3ች1","1ኝ","1ን","1ት","7ት","ህ1","0ው","4ህ","4ክ","4ሽ","4ው","0ን","0ህ","0ክ","0ሽ","6ኝ","6ን","6ህ","6ክ","6ሽ","6ት","3ኝ","3ን","3ህ","3ክ","3ሽ","3ው","3ት","1","4","6","3"};
    static String[] suffixesFive = {"3ችህ1ብ3ች0ው3ል3ችህ1", "3ችህ1ል3ች0ው3ል3ችህ1", "3ች1ብ3ች0ው3ል3ችህ1", "3ችህ1ብ3ች0ው3ል3ችው", "3ችህ1ብ3ች0ው3ል3ች1", "3ች1ል3ች0ው3ል3ችህ1", "3ችህ1ል3ች0ው3ል3ችው", "3ችህ1ል3ች0ው3ል3ች1", "3ች1ብ3ች0ው3ል3ችው", "3ች1ብ3ች0ው3ል3ች1", "3ችህ1ብ0ት3ል3ችህ1", "3ችህ1ብ3ት3ል3ችህ1", "3ች1ል3ች0ው3ል3ችው", "3ች1ል3ች0ው3ል3ች1", "3ችህ1ል0ት3ል3ችህ1", "3ችህ1ል3ት3ል3ችህ1", "3ች1ብ0ት3ል3ችህ1", "3ች1ብ3ት3ል3ችህ1", "3ችህ1ብኝ3ል3ችህ1", "3ችህ1ብን3ል3ችህ1", "3ችህ1ብ0ት3ል3ችው", "3ችህ1ብ0ት3ል3ች1", "3ችህ1ብ3ት3ል3ችው", "3ችህ1ብ3ት3ል3ች1", "3ች1ል0ት3ል3ችህ1", "3ች1ል3ት3ል3ችህ1", "3ችህ1ልኝ3ል3ችህ1", "3ችህ1ልን3ል3ችህ1", "3ችህ1ል0ት3ል3ችው", "3ችህ1ል0ት3ል3ች1", "3ችህ1ል3ት3ል3ችው", "3ችህ1ል3ት3ል3ች1", "4እ0ች0ው3ል0ህ1", "4ይ3ች0ው3ል0ህ1", "2እ0ች0ው3ል0ህ1", "2ይ3ች0ው3ል0ህ1", "4እ0ች1ህ3ል0ህ1", "4ይ3ች1ህ3ል0ህ1", "2እ0ች1ህ3ል0ህ1", "2ይ3ች1ህ3ል0ህ1", "4ብ3ች0ው3ል0ህ1", "4ብ3ች1ው3ል0ህ1", "0ንብ3ች0ው3ል0ን", "0ንብ3ች1ው3ል0ን", "0ህብ3ች0ው3ል0ህ", "0ህብ3ች0ው3ል0ክ", "0ህብ3ች0ው3ል0ሽ", "0ክብ3ች0ው3ል0ህ", "0ክብ3ች0ው3ል0ክ", "0ክብ3ች0ው3ል0ሽ", "0ሽብ3ች0ው3ል0ህ", "0ሽብ3ች0ው3ል0ክ", "0ሽብ3ች0ው3ል0ሽ", "3ች1ብኝ3ል3ችህ1", "3ች1ብን3ል3ችህ1", "3ች1ብ0ት3ል3ችው", "3ች1ብ0ት3ል3ች1", "3ች1ብ3ት3ል3ችው", "3ች1ብ3ት3ል3ች1", "3ችህ1ብኝ3ል3ችው", "3ችህ1ብኝ3ል3ች1", "3ችህ1ብን3ል3ችው", "3ችህ1ብን3ል3ች1", "4ል3ች0ው3ል0ህ1", "4ል3ች1ው3ል0ህ1", "0ንል3ች0ው3ል0ን", "0ንል3ች1ው3ል0ን", "0ህል3ች0ው3ል0ህ", "0ህል3ች0ው3ል0ክ", "0ህል3ች0ው3ል0ሽ", "0ክል3ች0ው3ል0ህ", "0ክል3ች0ው3ል0ክ", "0ክል3ች0ው3ል0ሽ", "0ሽል3ች0ው3ል0ህ", "0ሽል3ች0ው3ል0ክ", "0ሽል3ች0ው3ል0ሽ", "3ች1ልኝ3ል3ችህ1", "3ች1ልን3ል3ችህ1", "3ች1ል0ት3ል3ችው", "3ች1ል0ት3ል3ች1", "3ች1ል3ት3ል3ችው", "3ች1ል3ት3ል3ች1", "3ችህ1ልኝ3ል3ችው", "3ችህ1ልኝ3ል3ች1", "3ችህ1ልን3ል3ችው", "3ችህ1ልን3ል3ች1", "4እ0ች0ው3ል0ው", "4ይ3ች0ው3ል0ው", "2እ0ች0ው3ል0ው", "2ይ3ች0ው3ል0ው", "4እ0ችህ7ል0ህ1", "4ይ3ችህ7ል0ህ1", "4እ0ች1ህ3ል0ው", "4ይ3ች1ህ3ል0ው", "2እ0ችህ7ል0ህ1", "2ይ3ችህ7ል0ህ1", "2እ0ች1ህ3ል0ው", "2ይ3ች1ህ3ል0ው", "3ች1ው3ች0ው3ል", "4ብ3ች0ው3ል0ው", "4ብ3ችህ7ል0ህ1", "4ብ3ች1ው3ል0ው", "4ብው6ት3ል0ህ1", "0ንብ3ችህ7ል0ን", "0ንብው6ት3ል0ን", "3ች1ብኝ3ል3ችው", "3ች1ብኝ3ል3ች1", "3ች1ብን3ል3ችው", "3ች1ብን3ል3ች1", "3ብ3ች0ው3ል0ች", "3ብ3ች1ው3ል0ች", "4ል3ች0ው3ል0ው", "4ል3ችህ7ል0ህ1", "4ል3ች1ው3ል0ው", "4ልው6ት3ል0ህ1", "0ንል3ችህ7ል0ን", "0ንልው6ት3ል0ን", "3ች1ልኝ3ል3ችው", "3ች1ልኝ3ል3ች1", "3ች1ልን3ል3ችው", "3ች1ልን3ል3ች1", "3ል3ች0ው3ል0ች", "3ል3ች1ው3ል0ች", "4እ0ት3ል0ህ1", "4ይ3ት3ል0ህ1", "2እ0ት3ል0ህ1", "2ይ3ት3ል0ህ1", "4እ0ችህ7ል0ው", "4ይ3ችህ7ል0ው", "4እ0ች7ል0ህ1", "4ይ3ች7ል0ህ1", "2እ0ችህ7ል0ው", "2ይ3ችህ7ል0ው", "2እ0ች7ል0ህ1", "2ይ3ች7ል0ህ1", "4ው6ት3ል0ህ1", "3ች1ህ3ት3ል", "3ችህ7ች0ው3ል", "3ችው3ች0ው3ል", "4ብ0ት3ል0ህ1", "4ብ3ት3ል0ህ1", "4ብ3ችህ7ል0ው", "4ብ3ች7ል0ህ1", "4ብው6ት3ል0ው", "4ብ6ት3ል0ህ1", "0ንብ0ት3ል0ን", "0ንብ3ት3ል0ን", "0ንብ3ች7ል0ን", "0ንብ6ት3ል0ን", "0ህብ0ት3ል0ህ", "0ህብ0ት3ል0ክ", "0ህብ0ት3ል0ሽ", "0ህብ3ት3ል0ህ", "0ህብ3ት3ል0ክ", "0ህብ3ት3ል0ሽ", "0ክብ0ት3ል0ህ", "0ክብ0ት3ል0ክ", "0ክብ0ት3ል0ሽ", "0ክብ3ት3ል0ህ", "0ክብ3ት3ል0ክ", "0ክብ3ት3ል0ሽ", "0ሽብ0ት3ል0ህ", "0ሽብ0ት3ል0ክ", "0ሽብ0ት3ል0ሽ", "0ሽብ3ት3ል0ህ", "0ሽብ3ት3ል0ክ", "0ሽብ3ት3ል0ሽ", "3ብ3ችህ7ል0ች", "3ብው6ት3ል0ች", "0ውብ3ች0ው3ል", "0ውብ3ች1ው3ል", "4ል0ት3ል0ህ1", "4ል3ት3ል0ህ1", "4ል3ችህ7ል0ው", "4ል3ች7ል0ህ1", "4ል6ት3ል0ህ1", "4ልው6ት3ል0ው", "0ንል0ት3ል0ን", "0ንል3ት3ል0ን", "0ንል3ች7ል0ን", "0ንል6ት3ል0ን", "0ህል0ት3ል0ህ", "0ህል0ት3ል0ክ", "0ህል0ት3ል0ሽ", "0ህል3ት3ል0ህ", "0ህል3ት3ል0ክ", "0ህል3ት3ል0ሽ", "0ክል0ት3ል0ህ", "0ክል0ት3ል0ክ", "0ክል0ት3ል0ሽ", "0ክል3ት3ል0ህ", "0ክል3ት3ል0ክ", "0ክል3ት3ል0ሽ", "0ሽል0ት3ል0ህ", "0ሽል0ት3ል0ክ", "0ሽል0ት3ል0ሽ", "0ሽል3ት3ል0ህ", "0ሽል3ት3ል0ክ", "0ሽል3ት3ል0ሽ", "3ል3ችህ7ል0ች", "3ልው6ት3ል0ች", "0ውል3ች0ው3ል", "0ውል3ች1ው3ል", "4እ0ት3ል0ው", "4ይ3ት3ል0ው", "2እ0ት3ል0ው", "2ይ3ት3ል0ው", "4እ0ች7ል0ው", "4ይ3ች7ል0ው", "2እ0ች7ል0ው", "2ይ3ች7ል0ው", "4ው6ት3ል0ው", "0ን3ች0ው3ል", "0ን3ች1ህ3ል", "0ህ3ች0ው3ል", "0ሽ3ች0ው3ል", "3ች1ው3ት3ል", "3ች7ች0ው3ል", "3ች0ው3ል0ች", "3ች1ህ3ል0ች", "0ው3ች0ው3ል", "0ው3ች1ህ3ል", "4ብህ3ል0ህ1", "4ብክ3ል0ህ1", "4ብሽ3ል0ህ1", "4ብ0ት3ል0ው", "4ብ3ት3ል0ው", "4ብ3ች7ል0ው", "4ብ6ት3ል0ው", "0ንብህ3ል0ን", "0ንብክ3ል0ን", "0ንብሽ3ል0ን", "0ህብኝ3ል0ህ", "0ህብኝ3ል0ክ", "0ህብኝ3ል0ሽ", "0ህብን3ል0ህ", "0ህብን3ል0ክ", "0ህብን3ል0ሽ", "0ክብኝ3ል0ህ", "0ክብኝ3ል0ክ", "0ክብኝ3ል0ሽ", "0ክብን3ል0ህ", "0ክብን3ል0ክ", "0ክብን3ል0ሽ", "0ሽብኝ3ል0ህ", "0ሽብኝ3ል0ክ", "0ሽብኝ3ል0ሽ", "0ሽብን3ል0ህ", "0ሽብን3ል0ክ", "0ሽብን3ል0ሽ", "6ብ3ች0ው3ል", "6ብ3ች1ው3ል", "3ብ0ት3ል0ች", "3ብ3ት3ል0ች", "3ብ3ች7ል0ች", "3ብ6ት3ል0ች", "0ውብ3ችህ7ል", "0ውብው6ት3ል", "4ልህ3ል0ህ1", "4ልክ3ል0ህ1", "4ልሽ3ል0ህ1", "4ል0ት3ል0ው", "4ል3ት3ል0ው", "4ል3ች7ል0ው", "4ል6ት3ል0ው", "0ንልህ3ል0ን", "0ንልክ3ል0ን", "0ንልሽ3ል0ን", "0ህልኝ3ል0ህ", "0ህልኝ3ል0ክ", "0ህልኝ3ል0ሽ", "0ህልን3ል0ህ", "0ህልን3ል0ክ", "0ህልን3ል0ሽ", "0ክልኝ3ል0ህ", "0ክልኝ3ል0ክ", "0ክልኝ3ል0ሽ", "0ክልን3ል0ህ", "0ክልን3ል0ክ", "0ክልን3ል0ሽ", "0ሽልኝ3ል0ህ", "0ሽልኝ3ል0ክ", "0ሽልኝ3ል0ሽ", "0ሽልን3ል0ህ", "0ሽልን3ል0ክ", "0ሽልን3ል0ሽ", "6ል3ች0ው3ል", "6ል3ች1ው3ል", "3ል0ት3ል0ች", "3ል3ት3ል0ች", "3ል3ች7ል0ች", "3ል6ት3ል0ች", "0ውል3ችህ7ል", "0ውልው6ት3ል", "4ህ3ል0ህ1", "4ክ3ል0ህ1", "4ሽ3ል0ህ1", "4ው3ል0ህ1", "4እ0ል0ህ1", "4ይ3ል0ህ1", "2እ0ል0ህ1", "2ይ3ል0ህ1", "0ን3ችህ7ል", "0ንው6ት3ል", "3ችህ1ኝ3ል", "3ችህ1ን3ል", "3ችህ1ት3ል", "3ችህ7ት3ል", "3ችው3ት3ል", "3ችህ7ል0ች", "0ው3ችህ7ል", "4ብህ3ል0ው", "4ብክ3ል0ው", "4ብሽ3ል0ው", "6ብ3ችህ7ል", "6ብው6ት3ል", "3ብኝ3ል0ች", "3ብን3ል0ች", "3ብህ3ል0ች", "3ብክ3ል0ች", "3ብሽ3ል0ች", "0ውብ0ት3ል", "0ውብ3ት3ል", "0ውብ3ች7ል", "0ውብ6ት3ል", "4ልህ3ል0ው", "4ልክ3ል0ው", "4ልሽ3ል0ው", "6ል3ችህ7ል", "6ልው6ት3ል", "3ልኝ3ል0ች", "3ልን3ል0ች", "3ልህ3ል0ች", "3ልክ3ል0ች", "3ልሽ3ል0ች", "0ውል0ት3ል", "0ውል3ት3ል", "0ውል3ች7ል", "0ውል6ት3ል", "4ህ3ል0ው", "4ክ3ል0ው", "4ሽ3ል0ው", "4ው3ል0ው", "4እ0ል0ው", "4ይ3ል0ው", "2እ0ል0ው", "2ይ3ል0ው", "0ን0ው3ል", "0ን3ት3ል", "0ን3ች7ል", "0ኽ0ኝ3ል", "0ክ0ኝ3ል", "0ሽ2ኝ3ል", "0ኽ0ን3ል", "0ክ0ን3ል", "0ሽ2ን3ል", "0ኽ0ው3ል", "0ክ0ው3ል", "0ሽ2ው3ል", "0ህ3ት3ል", "0ሽ3ት3ል", "3ች1ኝ3ል", "3ች1ን3ል", "3ች1ት3ል", "3ች7ት3ል", "3ች1ህ3ል", "7ች0ው3ል", "7ች1ህ3ል", "6ው6ት3ል", "3ኝ3ል0ች", "3ን3ል0ች", "3ህ3ል0ች", "3ክ3ል0ች", "3ሽ3ል0ች", "3ው3ል0ች", "3ት3ል0ች", "3ች7ል0ች", "3ው6ት3ል", "0ው3ት3ል", "0ው3ች7ል", "0ው6ት3ል", "6ብ0ት3ል", "6ብ3ት3ል", "6ብ3ች7ል", "6ብ6ት3ል", "0ውብኝ3ል", "0ውብን3ል", "0ውብህ3ል", "0ውብክ3ል", "0ውብሽ3ል", "6ል0ት3ል", "6ል3ት3ል", "6ል3ች7ል", "6ል6ት3ል", "0ውልኝ3ል", "0ውልን3ል", "0ውልህ3ል", "0ውልክ3ል", "0ውልሽ3ል", "0ንህ3ል", "0ንክ3ል", "0ንሽ3ል", "0ሽኝ3ል", "0ሽን3ል", "0ሽው3ል", "3ችህ7ል", "7ችህ7ል", "0ውኝ3ል", "0ውን3ል", "0ውህ3ል", "0ውክ3ል", "0ውሽ3ል", "0ውት3ል", "0ንብው6", "6ብኝ3ል", "6ብን3ል", "6ብህ3ል", "6ብክ3ል", "6ብሽ3ል", "0ውብው6", "0ንልው6", "6ልኝ3ል", "6ልን3ል", "6ልህ3ል", "6ልክ3ል", "6ልሽ3ል", "0ውልው6", "0ን3ል", "0ህ3ል", "0ክ3ል", "0ሽ3ል", "3ች7ል", "6ኝ3ል", "6ን3ል", "6ህ3ል", "6ክ3ል", "6ሽ3ል", "6ት3ል", "7ት3ል", "7ች7ል", "3ል0ች", "0ው3ል", "4ብው6", "6ብው6", "3ብው6", "4ልው6", "6ልው6", "3ልው6", "7ል"};
    static String[] suffixesSix = {"3ብ3ች0ው", "3ብ3ችህ1", "3ል3ች0ው", "3ል3ችህ1", "ብ3ች0ው", "ብ3ችህ1", "3ብ3ች1", "3ብው6ት", "ል3ች0ው", "ል3ችህ1", "3ል3ች1", "3ልው6ት", "3ች0ው", "3ችህ1", "3ው6ት", "ብ3ች1", "ብው6ት", "3ብ0ት", "3ብ3ት", "3ብው6", "ል3ች1", "ልው6ት", "3ል0ት", "3ል3ት", "3ልው6", "3ል6ት", "3ች1", "ው6ት", "3ው6", "ብ0ት", "ብ3ት", "ብው6", "3ብህ", "3ብክ", "ል0ት", "ል3ት", "ልው6", "ል6ት", "3ልህ", "3ልክ", "3ልሽ", "0ው", "3ት", "ው6", "3ህ", "3ክ", "3ው", "ብህ", "ብክ", "ልህ", "ልክ", "ልሽ", "ህ", "ክ", "ው", "3", "", "3ብ3ች0ው", "3ብ3ችህ1", "3ል3ች0ው", "3ል3ችህ1", "ብ3ች0ው", "ብ3ችህ1", "3ብ3ች1", "3ብው6ት", "ል3ች0ው", "ል3ችህ1", "3ል3ች1", "3ልው6ት", "3ች0ው", "3ችህ1", "3ው6ት", "ብ3ች1", "ብው6ት", "3ብ0ት", "3ብ3ት", "3ብው6", "ል3ች1", "ልው6ት", "3ል0ት", "3ል3ት", "3ልው6", "3ል6ት", "3ች1", "ው6ት", "3ው6", "ብ0ት", "ብ3ት", "ብው6", "3ብህ", "3ብክ", "ል0ት", "ል3ት", "ልው6", "ል6ት", "3ልህ", "3ልክ", "3ልሽ", "0ው", "3ት", "ው6", "3ህ", "3ክ", "3ው", "ብህ", "ብክ", "ልህ", "ልክ", "ልሽ", "ህ", "ክ", "ው", "3", "", "3ብ3ች0ው", "3ብ3ችህ1", "3ል3ች0ው", "3ል3ችህ1", "1ብ3ች0ው", "1ል3ች0ው", "ብ3ች0ው", "ብ3ችህ1", "3ብ3ች1", "3ብው6ት", "ል3ች0ው", "ል3ችህ1", "3ል3ች1", "3ልው6ት", "3ች0ው", "3ችህ1", "3ው6ት", "ብ3ች1", "ብው6ት", "3ብ0ት", "3ብ3ት", "3ብው6", "ል3ች1", "ልው6ት", "3ል0ት", "3ል3ት", "3ልው6", "3ል6ት", "2ች0ው", "7ች0ው", "1ብ0ት", "1ል0ት", "1ብ3ት", "1ል3ት", "3ች1", "ው6ት", "3ው6", "ብ0ት", "ብ3ት", "ብው6", "3ብኝ", "3ብን", "3ብህ", "3ብክ", "ል0ት", "ል3ት", "ልው6", "ል6ት", "3ልኝ", "3ልን", "3ልህ", "3ልክ", "3ልሽ", "1ብኝ", "1ልኝ", "1ብን", "1ልን", "0ኝ", "0ን", "0ው", "3ት", "ው6", "3ኝ", "3ን", "3ህ", "3ክ", "3ው", "ብኝ", "ብን", "ብህ", "ብክ", "ልኝ", "ልን", "ልህ", "ልክ", "ልሽ", "2ኝ", "2ን", "2ው", "2ት", "1ኝ", "1ን", "1ው", "7ት", "ህ", "ክ", "2", "ኝ", "ን", "ው", "1", "3", "", "1ብ3ች0ው", "1ብ3ችህ1", "3ብ3ች0ው", "3ብ3ችህ1", "1ል3ች0ው", "1ል3ችህ1", "3ል3ች0ው", "3ል3ችህ1", "ብ3ች0ው", "ብ3ችህ1", "1ብ3ች1", "1ብው6ት", "3ብ3ች1", "3ብው6ት", "ል3ች0ው", "ል3ችህ1", "1ል3ች1", "1ልው6ት", "3ል3ች1", "3ልው6ት", "3ች0ው", "3ችህ1", "7ች0ው", "7ችህ1", "1ው6ት", "3ው6ት", "ብ3ች1", "ብው6ት", "1ብ0ት", "1ብ3ት", "1ብው6", "3ብ0ት", "3ብ3ት", "3ብው6", "ል3ች1", "ልው6ት", "1ል0ት", "1ል3ት", "1ልው6", "1ል6ት", "3ል0ት", "3ል3ት", "3ልው6", "3ል6ት", "3ች1", "ው6ት", "7ች1", "1ው6", "3ው6", "ብ0ት", "ብ3ት", "ብው6", "1ብኝ", "1ብን", "1ብህ", "1ብክ", "3ብኝ", "3ብን", "3ብህ", "3ብክ", "ል0ት", "ል3ት", "ልው6", "ል6ት", "1ልኝ", "1ልን", "1ልህ", "1ልክ", "1ልሽ", "3ልኝ", "3ልን", "3ልህ", "3ልክ", "3ልሽ", "0ኝ", "0ን", "0ት", "3ት", "ው6", "1ኝ", "1ን", "1ህ", "1ክ", "1ት", "7ት", "3ኝ", "3ን", "3ህ", "3ክ", "ብኝ", "ብን", "ብህ", "ብክ", "ልኝ", "ልን", "ልህ", "ልክ", "ልሽ", "ህ", "ክ", "1", "3", "", "1ብ3ች0ው", "1ል3ች0ው", "3ች0ው", "2ች0ው", "7ች0ው", "1ብ0ት", "1ብ3ት", "1ል0ት", "1ል3ት", "1ብኝ", "1ብን", "1ልኝ", "1ልን", "0ኝ", "0ን", "0ው", "3ት", "2ኝ", "2ን", "2ው", "2ት", "1ኝ", "1ን", "1ው", "7ት", "2", "1", "ኝ", "ን", "ው"};
    static String[] prefixesSix = {"እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "እን", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ል", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ት", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "ይ", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""};
    static PrintStream out = null;
    public static boolean theSameStem(String fileLine, String fileLine2) {
        if (fileLine.contains(fileLine2)) {
//            tempSuffix = fileLine.substring(fileLine.indexOf(fileLine2)+fileLine2.length());
//            tempPrefix = fileLine.substring(0,fileLine.indexOf(fileLine2));
            for (int i = 0; i < suffixesSix.length; i++) {
                if ((prefixesSix[i]+fileLine2+suffixesSix[i]).equals(fileLine)) {
                    return true;
                }
            }
            out.println("theCase1: "+fileLine+" : "+fileLine2+" : "+tempSuffix+" : "+tempPrefix);
            return false;
        } else {
            out.println("theCase2: "+fileLine+" : "+fileLine2+" : "+tempSuffix+" : "+tempPrefix);
            return false;
        }
    }
static String[] prefixesThreeShort = {"ት","እን", "ይ", ""};
    public static void main(String[] args) throws Exception {
//        myWriter = new FileWriter("C:\\Users\\Misgana\\Desktop\\theTwoProcessedStem.txt", true);
        out = new PrintStream(System.out, true, "UTF-8");
        BufferedReader br = null;
        BufferedReader br2 = null;
        BufferedReader br3 = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\final\\class3Processed2.txt"));
            br2 = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\final\\class3Gerund.txt"));
            br3 = new BufferedReader(new FileReader("C:\\Users\\Misgana\\Desktop\\final\\class3Processed2.txt"));
            String fileLine = "", fileLine2 = "", fileLine3 = "";
            int counter = 0;
            String theStem = "";
            String theStemGerund = "";
            String variation = "";
            String variationGerund = "";
            String batch = "";
            String output = "";
            String outputGerund = "";
            String[] splittedOutput = null;
            String[] splittedOutputGerund = null;
            while ((fileLine = br.readLine()) != null && (fileLine2 = br2.readLine()) != null
                    && (fileLine3 = br3.readLine()) != null) {
                counter++;
//                if (counter % 1000 == 0)
//                    out.println(counter);
                if (theStem.equals("")) {
                    theStem = fileLine;
                    theStemGerund = fileLine2;
                    batch = fileLine2;
                } 
                else if ((fileLine.equals(theStem) || ("እን"+fileLine).equals(theStem)) && fileLine2.equals(theStemGerund)) {
                    
                    batch = batch + "_" + fileLine2;
                } else if ((theStem.startsWith(fileLine) && fileLine2.equals(theStemGerund)
                        || theStem.startsWith(fileLine) && fileLine2.equals(theStemGerund))
                        
                        && theStem.charAt(theStem.length() - 1) !='7'
//                        && !(fileLine.equals(theStem.substring(0,theStem.length()-1)) &&  theStem.charAt(theStem.length()-1) == theStem.charAt(theStem.length()-2))
                        ) {
                    
                    batch = batch + "_" + fileLine2;
                } 
                else if (isNumeric(fileLine.charAt(fileLine.length() - 1) + "")&& fileLine2.equals(theStemGerund) 
                        && fileLine.charAt(fileLine.length() - 1) !='7') {
                    
                    batch = batch + "_" + fileLine2;
                } else if (fileLine.startsWith(theStem) && fileLine2.equals(theStemGerund)
                        && fileLine.charAt(fileLine.length() - 1) !='7'
                        && !fileLine.equals(theStem+"ት")) {
                    batch = batch + "_" + fileLine2;
                    theStem = fileLine;
                    theStemGerund = fileLine2;
                } else if (theStem.substring(0, theStem.length() - 1).equals(fileLine.substring(0, fileLine.length() - 1))
                        && fileLine2.equals(theStemGerund)) {
                    batch = batch + "_" + fileLine2;
                    if (variation.equals("")) {
                        variation = fileLine;
                        variationGerund = fileLine2;
                    } else if (!variation.contains(fileLine)) {
                        variation = variation + "\n" + fileLine;
                        variationGerund = variationGerund + "\n" + fileLine2;
                    }

                } else if (theStem.endsWith("3") && theStem.substring(0, theStem.length() - 2).equals(fileLine.substring(0, fileLine.length() - 1))
                        && fileLine2.equals(theStemGerund)) {
                    batch = batch + "_" + fileLine2;
                    if (variation.equals("")) {
                        variation = fileLine;
                        variationGerund = fileLine2;
                    } else if (!variation.contains(fileLine)) {
                        variation = variation + "\n" + fileLine;
                        variationGerund = variationGerund + "\n" + fileLine2;
                    }

                } else {
                    if(isNumeric(theStem.charAt(theStem.length() - 1)+"") && theStem.charAt(theStem.length() - 1) !='7'){
                        theStem = theStem.substring(0,theStem.length()-1);
                    }
                    if (variation.equals("")) {
                        if (output.equals("")) {
                            output = theStem;
                            outputGerund = theStemGerund;
                        } else {
                            output = output + "\n" + theStem;
                            outputGerund = outputGerund + "\n" + theStemGerund;
                        }
                    } else {
                        if (output.equals("")) {
                            output = theStem + "\n" + variation;
                            outputGerund = theStemGerund + "\n" + variationGerund;

                        } else {
                            output = output + "\n" + theStem + "\n" + variation;
                            outputGerund = outputGerund + "\n" + theStemGerund + "\n" + variationGerund;

                        }
                        variation = "";
                        variationGerund = "";
                    }
                    theStem = fileLine;
                    theStemGerund = fileLine2;
                    batch = "";
                }
            }
            boolean done = false;
            splittedOutput = output.split("\n");
            splittedOutputGerund = outputGerund.split("\n");
            for (int i = 0; i < 10; i++) {
                out.println(splittedOutput[i]);
            }
            for (int i = 10; i < splittedOutput.length; i++) {
                done = false;
                for (int j = i - 10; j < i; j++) {
                    if (splittedOutput[i].equals(splittedOutput[j]) 
                            && splittedOutputGerund[i].equals(splittedOutputGerund[j])) {
                        done = true;
                        break;
                    }
                }
                if (!done) {
                    out.println(splittedOutput[i]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
