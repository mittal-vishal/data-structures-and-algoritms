package com.vishal.backtracking;

import java.util.HashMap;

public class WordPatternII {

    private HashMap<String, Character> strCharMap;
    private HashMap<Character, String> charStrMap;

    public boolean wordPatternMatch(String pattern, String s) {
        strCharMap = new HashMap<>();
        charStrMap = new HashMap<>();
        return backtrack(pattern, 0, s, 0);
    }

    private boolean backtrack(String pattern, int i, String text, int j){
        if(i == pattern.length() && j == text.length()){
            return true;
        }else if(i == pattern.length() || j == text.length()){
            return false;
        }
        char currChar = pattern.charAt(i);
        for(int k = j; k < text.length(); k++){
            boolean isInsert = false;
            String possStr = text.substring(j, k + 1);
            if(!strCharMap.containsKey(possStr) && !charStrMap.containsKey(currChar)){
                strCharMap.put(possStr, currChar);
                charStrMap.put(currChar, possStr);
                isInsert = true;
            }
            if((strCharMap.containsKey(possStr) && strCharMap.get(possStr) != currChar) ||
                    charStrMap.containsKey(currChar) && !charStrMap.get(currChar).equals(possStr)){
                continue;
            }
            if(strCharMap.containsKey(possStr) && strCharMap.get(possStr) == currChar &&
                    charStrMap.containsKey(currChar) && charStrMap.get(currChar).equals(possStr)){
                if(backtrack(pattern, i + 1, text, k + 1)){
                    return true;
                }
            }
            if(isInsert){
                strCharMap.remove(possStr);
                charStrMap.remove(currChar);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String pattern = "abab";
        String s = "redblueredblue";
        WordPatternII wp = new WordPatternII();
        boolean isMatch = wp.wordPatternMatch(pattern, s);
        System.out.println(isMatch);
    }

}
