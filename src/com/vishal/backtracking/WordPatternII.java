package com.vishal.backtracking;

import java.util.HashMap;

public class WordPatternII {

    private HashMap<String, Character> strCharMap;
    private HashMap<Character, String> charStrMap;

    public boolean wordPatternMatch(String pattern, String s) {
        strCharMap = new HashMap<>();
        charStrMap = new HashMap<>();
        return dfs(pattern, 0, s, 0);
    }

    private boolean dfs(String pattern, int i, String s, int j){
        if(i == pattern.length()  && j == s.length()){
            return true;
        }
        if(i == pattern.length() || j == s.length()){
            return false;
        }
        char currChar = pattern.charAt(i);
        boolean isInsert = false;
        for(int k = j; k < s.length(); k++){
            String possStr = s.substring(j, k + 1);
            if(strCharMap.containsKey(possStr) && strCharMap.get(possStr) != currChar){
                continue;
            }
            if(charStrMap.containsKey(currChar) && !charStrMap.get(currChar).equals(possStr)){
                continue;
            }
            if(!strCharMap.containsKey(possStr) && !charStrMap.containsKey(currChar)) {
                strCharMap.put(possStr, currChar);
                charStrMap.put(currChar, possStr);
                isInsert = true;
            }
            if(strCharMap.containsKey(possStr) &&
                    charStrMap.containsKey(currChar) &&
                    dfs(pattern, i + 1, s, k + 1)){
                return true;
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
