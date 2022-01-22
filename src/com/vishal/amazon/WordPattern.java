package com.vishal.amazon;

import java.util.HashMap;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        HashMap<Character, String> charStringMap = new HashMap<>();
        HashMap<String, Character> stringCharMap = new HashMap<>();
        if(pattern.length() != words.length){
            return false;
        }
        for(int i = 0; i < pattern.length(); i++){
            char currChar = pattern.charAt(i);
            if(!charStringMap.containsKey(currChar)){
                charStringMap.put(currChar, words[i]);
            }else if(!charStringMap.get(currChar).equals(words[i])){
                return false;
            }
            String currStr = words[i];
            if(!stringCharMap.containsKey(currStr)){
                stringCharMap.put(currStr, currChar);
            }else if(stringCharMap.get(currStr) != currChar){
                return false;
            }
        }
        return true;
    }

}
