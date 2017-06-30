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

public class Automaton {
    
    // Important constants
    private final int IS_BEGIN_LETTER = 0, INITIAL_STATE = 0,
                      NOT_FOUND = -1;
    private int IS_FINAL_LETTER;
    private ArrayList<String> duplicated_letters;
    
    public Automaton() {
        duplicated_letters = new ArrayList<>();
    }
    
    private String get_ClearExceptionsFromName(String name){
        
        String[][] duplicatedCases = {
            {"rr","r"}, {"ff","f"}, {"bb","b"}, {"nn", "n"}};
        int isX = name.indexOf("x"), isJ = name.indexOf("j");
        
        IS_FINAL_LETTER = name.length()-1;
        
        // Replacing a-vowels
        name = name.replace("á", "a").replace("é", "e").replace("í", "i")
               .replace("ó", "o").replace("ú", "u");
        
        // Specials cases
        if (isJ != NOT_FOUND && isJ == IS_BEGIN_LETTER ){
            name = name.replace("jess", "yess").replace("jass", "yass")
                   .replace("jaque", "yaque").replace("jack", "yack")
                   .replace("jord", "yord").replace("jonat", "yonat")
                   .replace("joan", "yoan").replace("jordi", "yordi")
                   .replace("janne", "yanne").replace("johan", "yoan")
                   .replace("jeann", "yean").replace("jocel", "yosel")
                   .replace("jaz", "yaz");
        }
        
        if (name.startsWith("xa") || name.startsWith("xim"))
            name = "j" + name.substring(1);
        
        if (name.startsWith("xo"))
            name = "s" + name.substring(1);

        if (name.startsWith("chr"))
            name = "cr" + name.substring(2);

        if (isX != NOT_FOUND && isX != IS_BEGIN_LETTER && isX != IS_FINAL_LETTER){
            duplicated_letters.add(name.charAt(isX-1) + "" +
                                   name.charAt(isX+1) + "" +
                                   name.charAt(isX+2));
        }
        
        if (name.contains("ah") || name.contains("eh") || name.contains("ih") ||
            name.contains("oh") || name.contains("uh"))
            name = name.replace("h", "");
        
        if (name.endsWith("ie"))
            name = name.replace("ie", "i");
        
        if (name.startsWith("h"))
            name = name.substring(1);
        
        if (name.startsWith("gio"))
            name = "yo" + name.substring(3);
        
        // Duplicated consonants letter
        for (String[] dCase : duplicatedCases){
            int isCase = name.indexOf(dCase[0]);
            if (isCase != NOT_FOUND &&
                isCase != IS_BEGIN_LETTER &&
                isCase != IS_FINAL_LETTER){
                duplicated_letters.add(name.charAt(isCase-1) + "" +
                                       name.charAt(isCase+1) + "" +
                                       name.charAt(isCase+2));
                name = name.replace(dCase[0], dCase[1]);
            }
        }
        
        // Another exceptions
        return  name.replace("y", "i").replace("ll", "y").replace("xo", "so")
                    .replace("th", "t").replace("cr", "cur").replace("she", "si")
                    .replace("br", "bur").replace("pr", "pur").replace("fr", "fur")
                    .replace("ct", "cut").replace("ss", "z").replace("angi", "anye")
                    .replace("fl", "ful").replace("geo", "heo").replace("cl", "cul")
                    .replace("gr", "gur").replace("bl", "bul").replace("cc", "c")
                    .replace("ck", "k").replace("gn", "gun")
                    .replace("tte", "t").replace("güe", "we").replace("güi", "wi")
                    .replace("gina", "yina").replace("gl","gul");
        
    }
    
    public ArrayList<String> get_DuplicatedLetter(){
        return duplicated_letters;
    }
    
    private boolean isVowel(char charToTest) {
        
        return (charToTest == 'a' || charToTest == 'e' || charToTest == 'i' ||
                charToTest == 'o' || charToTest == 'u');
                
    }
    
    public ArrayList<String> get_MerosName(String name) {
        
        char[] charName = get_ClearExceptionsFromName(name).toCharArray();
        int state = INITIAL_STATE, i=0;
        String token = "";
        ArrayList<String> tokens = new ArrayList<>();
        
        do {
            switch(state) {
                case INITIAL_STATE:
                    token = "";
                    if (isVowel(charName[i]))
                        state = 1;
                    else if (charName[i] == 'c')
                        state = 4;
                    else if (charName[i] == 'q' || charName[i] == 'g')
                        state = 3;
                    else
                        state = 2;
                    token += charName[i];
                    i++;                    
                    break;
                case 1:
                    tokens.add(token);
                    state = INITIAL_STATE;
                    break;
                case 2:
                    if (isVowel(charName[i])){
                        token += charName[i];
                        i++;
                    }
                    state = 1;
                    break;
                case 3:
                    token += charName[i];                    
                    if (token.equals("gu")){
                        i++;                    
                        state = 5;
                        break;
                    }
                    else {
                        i++;                    
                        state = 2;
                    }
                    break;
                case 4:
                    if (isVowel(charName[i])){
                        token += charName[i];
                        i++;
                        state = 1;
                        break;
                    }
                    token += charName[i];
                    i++;                    
                    state = 2;
                    break;
                case 5:
                    if (charName[i] == 'e' || charName[i] == 'i'){
                        token += charName[i];
                        i++;
                    }
                    state = 1;
                    break;
            }
            
        }
        while (i < charName.length);
        
        if (!token.equals("")){
            if (!token.contains("h") && !token.contains("u") && token.length()==3){
                tokens.add(token.charAt(0) + "" + token.charAt(1));
                tokens.add(""+token.charAt(token.length()-1));
            }
            else
                tokens.add(token);
        }
                
        return tokens;
        
    }
    
    
}
