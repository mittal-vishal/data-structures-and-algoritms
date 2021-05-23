package com.vishal.windowsliding;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {

    public static boolean findPermutation(String str, String pattern) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int start = 0, end = 0;
        int matchCount = 0;
        for(char ch : pattern.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        while(end < str.length()){
            char rightChar = str.charAt(end++);
            if(freqMap.containsKey(rightChar)){
                freqMap.put(rightChar, freqMap.get(rightChar) - 1);
                if(freqMap.get(rightChar) == 0){
                    matchCount++;
                }
            }
            if(matchCount == freqMap.size()){
                return true;
            }
            if(end > pattern.length() - 1){
                char leftChar = str.charAt(start++);
                if(freqMap.containsKey(leftChar)){
                    if(freqMap.get(leftChar) == 0){
                        matchCount--;
                    }
                    freqMap.put(leftChar, freqMap.get(leftChar) + 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "odicf";
        String pattern="dc";
        System.out.print(findPermutation(str, pattern));
    }

}
