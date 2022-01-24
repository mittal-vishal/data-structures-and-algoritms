package com.vishal.amazon;

import java.util.HashMap;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        HashMap<String, Character> strCharMap = new HashMap<>();
        HashMap<Character, String> charStrMap = new HashMap<>();
        String[] strArr = s.split(" ");
        if(pattern.length() != strArr.length){
            return false;
        }
        for(int i = 0; i < pattern.length(); i++){
            char currChar = pattern.charAt(i);
            String currWord = strArr[i];
            if(!charStrMap.containsKey(currChar)){
                charStrMap.put(currChar, currWord);
            }
            if(!strCharMap.containsKey(currWord)){
                strCharMap.put(currWord, currChar);
            }
            if(!charStrMap.get(currChar).equals(currWord)){
                return false;
            }
            if(strCharMap.get(currWord) != currChar){
                return false;
            }
        }
        return true;
    }

}
