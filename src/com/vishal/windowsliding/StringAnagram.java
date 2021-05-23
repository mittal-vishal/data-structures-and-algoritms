package com.vishal.windowsliding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagram {

    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<>();
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch: pattern.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        int start = 0, end = 0;
        int matchedCount = 0;
        while(end < str.length()){
            char rightChar = str.charAt(end++);
            if(freqMap.containsKey(rightChar)){
                freqMap.put(rightChar, freqMap.get(rightChar) - 1);
                if(freqMap.get(rightChar) == 0){
                    matchedCount++;
                }
            }
            if(matchedCount == freqMap.size()){
                resultIndices.add(start);
            }
            if(start < end && end > pattern.length() - 1){
                char leftChar = str.charAt(start++);
                if(freqMap.containsKey(leftChar)){
                    if(freqMap.get(leftChar) == 0){
                        matchedCount--;
                    }
                    freqMap.put(leftChar, freqMap.get(leftChar) + 1);
                }
            }
        }
        return resultIndices;
    }

    public static void main(String[] args) {
        String str = "abbcabc";
        String pattern = "abc";
        System.out.print(findStringAnagrams(str, pattern));
    }

}
