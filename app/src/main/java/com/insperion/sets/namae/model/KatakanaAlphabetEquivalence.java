/*

    This file is part of Namae.

    Namae is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Namae is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with Namae.  If not, see <http://www.gnu.org/licenses/>.

*/

/*
	Developed by: Insperion
	Team: EDS Insperion
	Developer(s): Sergio Ernesto Tostado Sánchez (sets@insperion.com.mx)
	Contact: contacto@insperion.com.mx
*/

package com.insperion.sets.namae.model;

import java.util.ArrayList;
import java.util.HashMap;

public class KatakanaAlphabetEquivalence {
    
    private HashMap<String, String> katakanaEquivalence, katakana;
    
    public KatakanaAlphabetEquivalence(){
        set_InitKatakana();
        set_InitKatakanaEquivalence();
    }
    
    private void set_InitKatakanaEquivalence(){
        katakanaEquivalence = new HashMap<>();
//        katakanaEquivalence.put("a-mini", "" + (char)12449);
        katakanaEquivalence.put("a", "" + (char)12450);
//        katakanaEquivalence.put("i-mini", "" + (char)12451);
        katakanaEquivalence.put("i", "" + (char)12452);
//        katakanaEquivalence.put("u-mini", "" + (char)12453);
        katakanaEquivalence.put("u", "" + (char)12454);
        katakanaEquivalence.put("hu", "" + (char)12454);
        katakanaEquivalence.put("wi", "" + (char)12454 + (char)12452);
        katakanaEquivalence.put("wu", "" + (char)12454 + (char)12454);
        katakanaEquivalence.put("w", "" + (char)12454 + (char)12454);
        katakanaEquivalence.put("we", "" + (char)12454 + (char)12456);
//        katakanaEquivalence.put("e-mini", "" + (char)12455);
        katakanaEquivalence.put("e", "" + (char)12456);
//        katakanaEquivalence.put("o-mini", "" + (char)12457);
        katakanaEquivalence.put("o", "" + (char)12458);
        katakanaEquivalence.put("ca", "" + (char)12459);
        katakanaEquivalence.put("ka", "" + (char)12459);
        katakanaEquivalence.put("ga", "" + (char)12460);
        katakanaEquivalence.put("ki", "" + (char)12461);
        katakanaEquivalence.put("qui", "" + (char)12461);
//        katakanaEquivalence.put("gi", "" + (char)12461);
        katakanaEquivalence.put("gui", "" + (char)12462);
        katakanaEquivalence.put("x", "" + (char)12463 + (char)12473);
        katakanaEquivalence.put("xa", "" + (char)12463 + (char)12469);
        katakanaEquivalence.put("xi", "" + (char)12463 + (char)12471);
        katakanaEquivalence.put("xu", "" + (char)12463 + (char)12473);
        katakanaEquivalence.put("xe", "" + (char)12463 + (char)12475);
        katakanaEquivalence.put("xo", "" + (char)12463 + (char)12477);
        katakanaEquivalence.put("c", "" + (char)12463);
        katakanaEquivalence.put("k", "" + (char)12463);
        katakanaEquivalence.put("ku", "" + (char)12463);
        katakanaEquivalence.put("cu", "" + (char)12463);
        katakanaEquivalence.put("gu", "" + (char)12464);
        katakanaEquivalence.put("ke", "" + (char)12465);
        katakanaEquivalence.put("que", "" + (char)12465);
//        katakanaEquivalence.put("ge", "" + (char)12466);
        katakanaEquivalence.put("gue", "" + (char)12466);
        katakanaEquivalence.put("ko", "" + (char)12467);
        katakanaEquivalence.put("co", "" + (char)12467);
        katakanaEquivalence.put("go", "" + (char)12468);
        katakanaEquivalence.put("sa", "" + (char)12469);
        katakanaEquivalence.put("za", "" + (char)12470);
//        katakanaEquivalence.put("shi", "" + (char)12471);
        katakanaEquivalence.put("sha", "" + (char)12471 + (char)12515);
        katakanaEquivalence.put("shu", "" + (char)12471 + (char)12517);
        katakanaEquivalence.put("sho", "" + (char)12471 + (char)12519);
        katakanaEquivalence.put("si", "" + (char)12471);
        katakanaEquivalence.put("zi", "" + (char)12471);
        katakanaEquivalence.put("ci", "" + (char)12471);
//        katakanaEquivalence.put("ji", "" + (char)12472);
        katakanaEquivalence.put("yi", "" + (char)12472);
        katakanaEquivalence.put("s", "" + (char)12473);
        katakanaEquivalence.put("su", "" + (char)12473);
            katakanaEquivalence.put("z", "" + (char)12474);
        katakanaEquivalence.put("zu", "" + (char)12474);
        katakanaEquivalence.put("se", "" + (char)12475);
        katakanaEquivalence.put("ce", "" + (char)12475);
        katakanaEquivalence.put("ze", "" + (char)12476);
        katakanaEquivalence.put("so", "" + (char)12477);
        katakanaEquivalence.put("zo", "" + (char)12478);
        katakanaEquivalence.put("ta", "" + (char)12479);
        katakanaEquivalence.put("da", "" + (char)12480);
        katakanaEquivalence.put("chi", "" + (char)12481);
        katakanaEquivalence.put("cha", "" + (char)12481 + (char)12515);
        katakanaEquivalence.put("che", "" + (char)12481 + (char)12455);
        katakanaEquivalence.put("cho", "" + (char)12481 + (char)12519);
        katakanaEquivalence.put("chu", "" + (char)12481 + (char)12517);
        katakanaEquivalence.put("ch", "" + (char)12481 + (char)12517);
//        katakanaEquivalence.put("ji", "" + (char)12482);
//        katakanaEquivalence.put("tsu-mini", "" + (char)12483);
//        katakanaEquivalence.put("tsu", "" + (char)12484);
        katakanaEquivalence.put("zu", "" + (char)12485);
        katakanaEquivalence.put("te", "" + (char)12486);
        katakanaEquivalence.put("ti", "" + (char)12486 + (char)12451);
        katakanaEquivalence.put("de", "" + (char)12487);
        katakanaEquivalence.put("di", "" + (char)12487 + (char)12451);
        katakanaEquivalence.put("to", "" + (char)12488);
        katakanaEquivalence.put("t", "" + (char)12488);
        katakanaEquivalence.put("tu", "" + (char)12488 + (char)12453);
        katakanaEquivalence.put("do", "" + (char)12489);
        katakanaEquivalence.put("du", "" + (char)12489 + (char)12453);
        katakanaEquivalence.put("d", "" + (char)12489);
        katakanaEquivalence.put("na", "" + (char)12490);
        katakanaEquivalence.put("ni", "" + (char)12491);
        katakanaEquivalence.put("nu", "" + (char)12492);
        katakanaEquivalence.put("ne", "" + (char)12493);
        katakanaEquivalence.put("no", "" + (char)12494);
        katakanaEquivalence.put("ha", "" + (char)12495);
        katakanaEquivalence.put("ja", "" + (char)12495);
        katakanaEquivalence.put("ba", "" + (char)12496);
        katakanaEquivalence.put("pa", "" + (char)12497);
        katakanaEquivalence.put("hi", "" + (char)12498);
        katakanaEquivalence.put("ji", "" + (char)12498);
        katakanaEquivalence.put("gi", "" + (char)12498);
        katakanaEquivalence.put("bi", "" + (char)12499);        
        katakanaEquivalence.put("pi", "" + (char)12500);
        katakanaEquivalence.put("fu", "" + (char)12501);
        katakanaEquivalence.put("fa", "" + (char)12501 + (char)12449);
        katakanaEquivalence.put("fi", "" + (char)12501 + (char)12451);
        katakanaEquivalence.put("fe", "" + (char)12501 + (char)12455);
        katakanaEquivalence.put("fo", "" + (char)12501 + (char)12457);
        katakanaEquivalence.put("ju", "" + (char)12501);
        katakanaEquivalence.put("bu", "" + (char)12502);
        katakanaEquivalence.put("pu", "" + (char)12503);
        katakanaEquivalence.put("p", "" + (char)12503);
        katakanaEquivalence.put("he", "" + (char)12504);
        katakanaEquivalence.put("je", "" + (char)12504);
        katakanaEquivalence.put("ge", "" + (char)12504);
        katakanaEquivalence.put("be", "" + (char)12505);
        katakanaEquivalence.put("pe", "" + (char)12506);
        katakanaEquivalence.put("ho", "" + (char)12507);
        katakanaEquivalence.put("jo", "" + (char)12507);
        katakanaEquivalence.put("bo", "" + (char)12508);
        katakanaEquivalence.put("po", "" + (char)12509);
        katakanaEquivalence.put("ma", "" + (char)12510);
        katakanaEquivalence.put("mi", "" + (char)12511);
        katakanaEquivalence.put("m", "" + (char)12512);
        katakanaEquivalence.put("mu", "" + (char)12512);
        katakanaEquivalence.put("me", "" + (char)12513);
        katakanaEquivalence.put("mo", "" + (char)12514);
//        katakanaEquivalence.put("ya-mini", "" + (char)12515);
        katakanaEquivalence.put("ya", "" + (char)12516);
//        katakanaEquivalence.put("yu-mini", "" + (char)12517);
        katakanaEquivalence.put("yu", "" + (char)12518);
//        katakanaEquivalence.put("yo-mini", "" + (char)12519);
        katakanaEquivalence.put("ye", "" + (char)12452 + (char)12456);
        katakanaEquivalence.put("yo", "" + (char)12520);
        katakanaEquivalence.put("ra", "" + (char)12521);
        katakanaEquivalence.put("la", "" + (char)12521);
        katakanaEquivalence.put("ri", "" + (char)12522);
        katakanaEquivalence.put("li", "" + (char)12522);
        katakanaEquivalence.put("ru", "" + (char)12523);
        katakanaEquivalence.put("lu", "" + (char)12523);
        katakanaEquivalence.put("r", "" + (char)12523);
        katakanaEquivalence.put("l", "" + (char)12523);
        katakanaEquivalence.put("re", "" + (char)12524);
        katakanaEquivalence.put("le", "" + (char)12524);
        katakanaEquivalence.put("ro", "" + (char)12525);
        katakanaEquivalence.put("lo", "" + (char)12525);
//        katakanaEquivalence.put("wa-mini", "" + (char)12526);
        katakanaEquivalence.put("wa", "" + (char)12527);
//        katakanaEquivalence.put("?", "" + (char)12528);
//        katakanaEquivalence.put("?", "" + (char)12529);
        katakanaEquivalence.put("wo", "" + (char)12530);
        katakanaEquivalence.put("n", "" + (char)12531);
        katakanaEquivalence.put("ña", "" + (char)12491 + (char)12515);
        katakanaEquivalence.put("ñe", "" + (char)12491 + (char)12456);
        katakanaEquivalence.put("ñi", "" + (char)12491 + (char)12452);
        katakanaEquivalence.put("ño", "" + (char)12491 + (char)12519);
        katakanaEquivalence.put("ñu", "" + (char)12491 + (char)12517);
        katakanaEquivalence.put("v", "" + (char)12532);
        katakanaEquivalence.put("va", "" + (char)12532 + (char)12449);
        katakanaEquivalence.put("vi", "" + (char)12532 + (char)12451);
        katakanaEquivalence.put("vu", "" + (char)12532 + (char)12453);
        katakanaEquivalence.put("ve", "" + (char)12532 + (char)12455);
        katakanaEquivalence.put("vo", "" + (char)12532 + (char)12457);
//        katakanaEquivalence.put("ka-mini", "" + (char)12501);
//        katakanaEquivalence.put("ke-mini", "" + (char)12502);
//        katakanaEquivalence.put("wa?", "" + (char)12503);
//        katakanaEquivalence.put("?", "" + (char)12504);
//        katakanaEquivalence.put("?", "" + (char)12500);
//        katakanaEquivalence.put("?", "" + (char)12501);
    }
    
    private void set_InitKatakana(){
        katakana = new HashMap<>();
        katakana.put(" ", " ");
        katakana.put("" + (char)12449, "a-mini");
        katakana.put("" + (char)12450, "a");
        katakana.put("" + (char)12451, "i-mini");
        katakana.put("" + (char)12452, "i");
        katakana.put("" + (char)12453, "u-mini");
        katakana.put("" + (char)12454, "u");
        katakana.put("" + (char)12455, "e-mini");
        katakana.put("" + (char)12456, "e");
        katakana.put("" + (char)12457, "o-mini");
        katakana.put("" + (char)12458, "o");
        katakana.put("" + (char)12459, "ka");
        katakana.put("" + (char)12460, "ga");
        katakana.put("" + (char)12461, "ki");
        katakana.put("" + (char)12462, "gi");
        katakana.put("" + (char)12463, "ku");
        katakana.put("" + (char)12464, "gu");
        katakana.put("" + (char)12465, "ke");
        katakana.put("" + (char)12466, "ge");
        katakana.put("" + (char)12467, "ko");
        katakana.put("" + (char)12468, "go");
        katakana.put("" + (char)12469, "sa");
        katakana.put("" + (char)12470, "za");
        katakana.put("" + (char)12471, "shi");
        katakana.put("" + (char)12471 + (char)12515, "sha");
        katakana.put("" + (char)12471 + (char)12517, "shu");
        katakana.put("" + (char)12471 + (char)12519, "sho");
        katakana.put("" + (char)12472, "ji");
        katakana.put("" + (char)12473, "su");
        katakana.put("" + (char)12474, "zu");
        katakana.put("" + (char)12475, "se");
        katakana.put("" + (char)12476, "ze");
        katakana.put("" + (char)12477, "so");
        katakana.put("" + (char)12478, "zo");
        katakana.put("" + (char)12479, "ta");
        katakana.put("" + (char)12480, "da");
        katakana.put("" + (char)12481, "chi");
        katakana.put("" + (char)12481 + (char)12515, "cha");
        katakana.put("" + (char)12481 + (char)12455, "che");
        katakana.put("" + (char)12481 + (char)12519, "cho");
        katakana.put("" + (char)12481 + (char)12517, "chu");
        katakana.put("" + (char)12482, "ji");
        katakana.put("" + (char)12483, "tsu-mini");
        katakana.put("" + (char)12484, "tsu");
        katakana.put("" + (char)12485, "zu");
        katakana.put("" + (char)12486, "te");
        katakana.put("" + (char)12486 + (char)12451, "ti");
        katakana.put("" + (char)12487, "de");
        katakana.put("" + (char)12487 + (char)12451, "di");
        katakana.put("" + (char)12488, "to");
        katakana.put("" + (char)12488 + (char)12453, "tu");
        katakana.put("" + (char)12489, "do");
        katakana.put("" + (char)12489 + (char)12453, "du");
        katakana.put("" + (char)12490, "na");
        katakana.put("" + (char)12491, "ni");
        katakana.put("" + (char)12491 + (char)12515, "nya");
        katakana.put("" + (char)12491 + (char)12517, "nyu");
        katakana.put("" + (char)12491 + (char)12519, "nyo");
        katakana.put("" + (char)12492, "nu");
        katakana.put("" + (char)12493, "ne");
        katakana.put("" + (char)12494, "no");
        katakana.put("" + (char)12495, "ha");
        katakana.put("" + (char)12496, "ba");
        katakana.put("" + (char)12497, "pa");
        katakana.put("" + (char)12498, "hi");
        katakana.put("" + (char)12499, "bi");        
        katakana.put("" + (char)12500, "pi");
        katakana.put("" + (char)12501, "fu");
        katakana.put("" + (char)12501 + (char)12449, "fa");
        katakana.put("" + (char)12501 + (char)12451, "fi");
        katakana.put("" + (char)12501 + (char)12455, "fe");
        katakana.put("" + (char)12501 + (char)12457, "fo");
        katakana.put("" + (char)12502, "bu");
        katakana.put("" + (char)12503, "pu");
        katakana.put("" + (char)12504, "he");
        katakana.put("" + (char)12505, "be");
        katakana.put("" + (char)12506, "pe");
        katakana.put("" + (char)12507, "ho");
        katakana.put("" + (char)12508, "bo");
        katakana.put("" + (char)12509, "po");
        katakana.put("" + (char)12510, "ma");
        katakana.put("" + (char)12511, "mi");
        katakana.put("" + (char)12512, "mu");
        katakana.put("" + (char)12513, "me");
        katakana.put("" + (char)12514, "mo");
        katakana.put("" + (char)12515, "ya-mini");
        katakana.put("" + (char)12516, "ya");
        katakana.put("" + (char)12517, "yu-mini");
        katakana.put("" + (char)12518, "yu");
        katakana.put("" + (char)12519, "yo-mini");
        katakana.put("" + (char)12520, "yo");
        katakana.put("" + (char)12521, "ra");
        katakana.put("" + (char)12522, "ri");
        katakana.put("" + (char)12523, "ru");
        katakana.put("" + (char)12524, "re");
        katakana.put("" + (char)12525, "ro");
        katakana.put("" + (char)12526, "wa-mini");
        katakana.put("" + (char)12527, "wa");
//        katakana.put("?", "" + (char)12528);
//        katakana.put("?", "" + (char)12529);
        katakana.put("" + (char)12530, "wo");
        katakana.put("" + (char)12531, "n");
        katakana.put("" + (char)12532, "v");
        katakana.put("" + (char)12532 + (char)12449, "va");
        katakana.put("" + (char)12532 + (char)12451, "vi");
        katakana.put("" + (char)12532 + (char)12453, "vu");
        katakana.put("" + (char)12532 + (char)12455, "ve");
        katakana.put("" + (char)12532 + (char)12457, "vo");
//        katakana.put("ka-mini", "" + (char)12501);
//        katakana.put("ke-mini", "" + (char)12502);
//        katakana.put("wa?", "" + (char)12503);
//        katakana.put("?", "" + (char)12504);
//        katakana.put("?", "" + (char)12500);
//        katakana.put("?", "" + (char)12501);
    }
      
    private boolean isYMini(char charToTest){
        // ya-mini yu-mini yo-mini
        return charToTest == (char)12515 || charToTest == (char)12517 ||
               charToTest == (char)12519;
        
    }
    
    private boolean isComposedSyllabus(char charToTest) {
        // chi te de do fu v to ni shi
        return charToTest == (char)12481 || charToTest == (char)12501 ||
                charToTest == (char)12486 || charToTest == (char)12487 ||
                charToTest == (char)12489 || charToTest == (char)12532 ||
                charToTest == (char)12488 || charToTest == (char)12491 ||
                charToTest == (char)12471;
        
    }
    
    private boolean isMiniVocal(char charToTest) {
        
        return charToTest == (char)12449 || charToTest == (char)12451 ||
                charToTest == (char)12453 || charToTest == (char)12455 ||
                charToTest == (char)12457;
        
    }
    
    private boolean isTsuMini(char charToTest){
        return charToTest == (char)12483;
    }
    
    private boolean isRomajiVowel(char charToTest) {
        
        return (charToTest == 'a' || charToTest == 'e' || charToTest == 'i' ||
                charToTest == 'o' || charToTest == 'u');
                
    }
    
    public String get_KatakanaSubset(ArrayList<String> romajiLetters){
        
        String subset = "";
        for (String letter : romajiLetters)
            subset += (String)katakanaEquivalence.get(letter) + " ";
        
        return subset;
        
    }
    
    public String get_Romanization(String katakanaName) {
        
        String romanization = "";
        ArrayList<Integer> tsus = new ArrayList<>();
        char syllabus;
        char[] nameChar = katakanaName.toCharArray();
        
        if (katakanaName.length() == 1)
            romanization += (String)katakana.get(katakanaName);
        else {    
            for (int i = 0; i < nameChar.length; i++){
                    syllabus = nameChar[i];
                    if ((i+1) != nameChar.length && isComposedSyllabus(syllabus)
                            && (isMiniVocal(nameChar[i+1]) || isYMini(nameChar[i+1]))){
                        i++;
                        romanization += (String)katakana.get(syllabus + "" + nameChar[i]);
                    }
                    else
                        romanization += (String)katakana.get(nameChar[i] + "");
            }
        }
        
        return romanization;
        
    }
    
    public String get_LongVowelSlash(String katakanaName, String romanization){
        
        String[] romanizationMeros = romanization.split(" "),
                 katakanaMeros = katakanaName.split(" ");
        char iMeros, jMeros;
        
        for (int i=0, j=1; j<romanizationMeros.length; i++, j++) {
            
            iMeros = romanizationMeros[i].charAt(romanizationMeros[i].length()-1);
            jMeros = romanizationMeros[j].charAt(0);
            if (iMeros == jMeros && isRomajiVowel(jMeros) &&
                isRomajiVowel(iMeros))
                katakanaMeros[j] = (char)12540 + "";
            
        }
        
        // Returning result
        katakanaName = "";
        for (String katakanaMero : katakanaMeros)
            katakanaName += katakanaMero + " ";
        
        return katakanaName.trim();
        
    }
    
}
