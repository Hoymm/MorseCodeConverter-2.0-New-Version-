package com.hoymm.root.morsecodeconverter.MorseToTextConversion;

import android.util.Log;

import java.util.HashMap;

/**
 * File created by Damian Muca - Kaizen on 27.06.17.
 */

public class MorseCodeCipher {

    private static final String CHAR_SEPARATOR = " ";
    private static final MorseCodeCipher ourInstance = new MorseCodeCipher();
    private HashMap<Character, String> textToMorseCoding = new HashMap<>();
    private HashMap<String, String> morseToTextCoding = new HashMap<>();

    public static MorseCodeCipher getInstance() {
        return ourInstance;
    }

    private MorseCodeCipher() {
        initTextToMorseCoding();
        initMorseToTextCoding();
    }

    private void initTextToMorseCoding() {
        textToMorseCoding.put(' ',"   ");
        textToMorseCoding.put('.',"·−·−·−");
        textToMorseCoding.put('A',"·−");
        textToMorseCoding.put('B',"−···");
        textToMorseCoding.put('C',"−·−·");
        textToMorseCoding.put('D',"−··");
        textToMorseCoding.put('E',"·");
        textToMorseCoding.put('F',"··−·");
        textToMorseCoding.put('G',"−−·");
        textToMorseCoding.put('H',"····");
        textToMorseCoding.put('I',"··");
        textToMorseCoding.put('J',"·−−−");
        textToMorseCoding.put('K',"−·−");
        textToMorseCoding.put('L',"·−··");
        textToMorseCoding.put('M',"−−");
        textToMorseCoding.put('N',"−·");
        textToMorseCoding.put('O',"−−−");
        textToMorseCoding.put('P',"·−−·");
        textToMorseCoding.put('Q',"−−·−");
        textToMorseCoding.put('R',"·−·");
        textToMorseCoding.put('S',"···");
        textToMorseCoding.put('T',"−");
        textToMorseCoding.put('U',"··−");
        textToMorseCoding.put('V',"···−");
        textToMorseCoding.put('W',"·−−");
        textToMorseCoding.put('X',"−··−");
        textToMorseCoding.put('Y',"−·−−");
        textToMorseCoding.put('Z',"−−··");
        textToMorseCoding.put('0',"−−−−−");
        textToMorseCoding.put('1',"·−−−−");
        textToMorseCoding.put('2',"··−−−");
        textToMorseCoding.put('3',"···−−");
        textToMorseCoding.put('4',"····−");
        textToMorseCoding.put('5',"·····");
        textToMorseCoding.put('6',"−····");
        textToMorseCoding.put('7',"−−···");
        textToMorseCoding.put('8',"−−−··");
        textToMorseCoding.put('9',"−−−−·");
        textToMorseCoding.put('·',"·−·−·−");
        textToMorseCoding.put(',',"−−··−−");
        textToMorseCoding.put('?',"··−−··");
        textToMorseCoding.put('!',"−·−·−−");
        textToMorseCoding.put('/',"−··−·");
        textToMorseCoding.put('(',"−·−−·");
        textToMorseCoding.put(')',"−·−−·−");
        textToMorseCoding.put('&',"·−···");
        textToMorseCoding.put(':',"−−−···");
        textToMorseCoding.put(';',"−·−·−·");
        textToMorseCoding.put('=',"−···−");
        textToMorseCoding.put('+',"·−·−·");
        textToMorseCoding.put('−',"−····−");
        textToMorseCoding.put('_',"··−−·−");
        textToMorseCoding.put('$',"···−··−");
        textToMorseCoding.put('@',"·−−·−·");

        textToMorseCoding.put('\'',"·−−−−·");
        textToMorseCoding.put('\"',"·−··−·");
        textToMorseCoding.put('\n',"·−·−");
    }

    private void initMorseToTextCoding() {

        morseToTextCoding.put("   ", " ");
        morseToTextCoding.put("·−·−·−", ".");
        morseToTextCoding.put("·−", "A");
        morseToTextCoding.put("−···", "B");
        morseToTextCoding.put("−·−·", "C");
        morseToTextCoding.put("−··", "D");
        morseToTextCoding.put("·", "E");
        morseToTextCoding.put("··−·", "F");
        morseToTextCoding.put("−−·", "G");
        morseToTextCoding.put("····", "H");
        morseToTextCoding.put("··", "I");
        morseToTextCoding.put("·−−−", "J");
        morseToTextCoding.put("−·−", "K");
        morseToTextCoding.put("·−··", "L");
        morseToTextCoding.put("−−", "M");
        morseToTextCoding.put("−·", "N");
        morseToTextCoding.put("−−−", "O");
        morseToTextCoding.put("·−−·", "P");
        morseToTextCoding.put("−−·−", "Q");
        morseToTextCoding.put("·−·", "R");
        morseToTextCoding.put("···", "S");
        morseToTextCoding.put("−", "T");
        morseToTextCoding.put("··−", "U");
        morseToTextCoding.put("···−", "V");
        morseToTextCoding.put("·−−", "W");
        morseToTextCoding.put("−··−", "X");
        morseToTextCoding.put("−·−−", "Y");
        morseToTextCoding.put("−−··", "Z");
        morseToTextCoding.put("−−−−−", "0");
        morseToTextCoding.put("·−−−−", "1");
        morseToTextCoding.put("··−−−", "2");
        morseToTextCoding.put("···−−", "3");
        morseToTextCoding.put("····−", "4");
        morseToTextCoding.put("·····", "5");
        morseToTextCoding.put("−····", "6");
        morseToTextCoding.put("−−···", "7");
        morseToTextCoding.put("−−−··", "8");
        morseToTextCoding.put("−−−−·", "9");
        morseToTextCoding.put("·−·−·−", "·");
        morseToTextCoding.put("−−··−−", ",");
        morseToTextCoding.put("··−−··", "?");
        morseToTextCoding.put("−·−·−−", "!");
        morseToTextCoding.put("−··−·", "/");
        morseToTextCoding.put("−·−−·", "(");
        morseToTextCoding.put("−·−−·−", ")");
        morseToTextCoding.put("·−···", "&");
        morseToTextCoding.put("−−−···", ":");
        morseToTextCoding.put("−·−·−·", ";");
        morseToTextCoding.put("−···−", "=");
        morseToTextCoding.put("·−·−·", "+");
        morseToTextCoding.put("−····−", "−");
        morseToTextCoding.put("··−−·−", "_");
        morseToTextCoding.put("···−··−", "$");
        morseToTextCoding.put("·−−·−·", "@");

        morseToTextCoding.put("·−−−−·", "\'");
        morseToTextCoding.put("·−··−·", "\"");
        morseToTextCoding.put("·−·−", "\n");
    }

    public String convertToMorse(char textChar){
        String morse = textToMorseCoding.get(textChar);
        return morse == null ? "#" : morse;
    }

    public String convertToText(String morseCode){
        String text = morseToTextCoding.get(morseCode);
        return text == null ? "#" : text;
    }

    public static String getCharSeparator() {
        return CHAR_SEPARATOR;
    }
}