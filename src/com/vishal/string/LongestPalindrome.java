package com.vishal.string;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        int length = 0;
        boolean isOddLen = false;
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for(char ch: s.toCharArray()){
            charFreqMap.put(ch, charFreqMap.getOrDefault(ch, 0) + 1);
        }
        for(Map.Entry<Character,Integer> entry: charFreqMap.entrySet()){
            if(entry.getValue() % 2 == 0){
                length += entry.getValue();
            }else{
                isOddLen = true;
                length += entry.getValue() - 1;
            }
        }
        if(isOddLen){
            length += 1;
        }
        return length;
    }

}
