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

package com.insperion.sets.namae.controller;

import java.util.ArrayList;
import com.insperion.sets.namae.model.KatakanaAlphabetEquivalence;

public class SpanishToKatakana {
    
    private Automaton automaton;
    private KatakanaAlphabetEquivalence katakana;
    
    public SpanishToKatakana(){
        
    }
    
    public String get_KatakanaPartOfName(String partName) {
        
        automaton = new Automaton();
        katakana = new KatakanaAlphabetEquivalence();
        
        ArrayList<String> tokens = automaton.get_MerosName(partName);
        String katakanaName = katakana.get_KatakanaSubset(tokens);
        
        return katakanaName;
        
    }
    
    public String[][] get_Translation(String nameToTranslate) {
        
        String katakanaMerosResult = "";
        String[] merosName = nameToTranslate.toLowerCase().trim().split(" ");
        String[][] completeName = new String[merosName.length][2];
        
        for (int i = 0; i < merosName.length; i++) {
            
            katakanaMerosResult = get_KatakanaPartOfName(merosName[i]);
            completeName[i][0] = katakanaMerosResult;
            completeName[i][1] = katakana.get_Romanization(katakanaMerosResult);
            
            // TSU-MINI ADDING ALGORITHM
            
            // Getting duplicated letters
            ArrayList<String> duplicatedLetters = automaton.get_DuplicatedLetter();
            // Looping the duplicated letter sequences if any exists
            if (!duplicatedLetters.isEmpty()){
                
                // Getting array to manipulate
                String katakanaPartName = completeName[i][0],
                       romajiPartName = completeName[i][1];
                String[] auxKatakanaNameArray = katakanaPartName.trim().split(" "),
                         auxRomajiNameArray = romajiPartName.trim().split(" ");
                // Looping to all found sequences
                for (String duplicatedSequence : duplicatedLetters){
                    for(int j=1; j<auxRomajiNameArray.length; j++){
                        
                        if (auxRomajiNameArray[j].equals(duplicatedSequence.substring(1)) &&
                            auxRomajiNameArray[j-1].endsWith(""+duplicatedSequence.charAt(0))){
                            
                            auxRomajiNameArray[j] = duplicatedSequence.charAt(1) + auxRomajiNameArray[j];
                            auxKatakanaNameArray[j] = (char)12483 + auxKatakanaNameArray[j];
                            
                            // Re-inserting chars to strings
                            katakanaPartName = "";
                            romajiPartName = "";
                            for (int k=0; k<auxKatakanaNameArray.length; k++){
                                katakanaPartName += auxKatakanaNameArray[k] + " ";
                                romajiPartName += auxRomajiNameArray[k] + " ";
                            }
                            completeName[i][0] = katakanaPartName;
                            completeName[i][1] = romajiPartName;
                            
                            break;
                                    
                        }
                            
                    }
                }
            }
            
            //completeName[i][1] = katakana.get_LongVowelSlash(completeName[i][1]);
            completeName[i][0] = katakana.get_LongVowelSlash(
                                    completeName[i][0], completeName[i][1]);
            
        }
        
        return completeName;
        
    }
    
}
