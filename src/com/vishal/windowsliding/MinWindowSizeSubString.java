package com.vishal.windowsliding;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSizeSubString {

    public static String findSubstring(String str, String pattern) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch: pattern.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        String returnStr = "";
        int start = 0, end = 0;
        int matchedCount = 0;
        while(end < str.length()){
            //Expand the window until condition met
            while(end < str.length() && matchedCount < freqMap.size()){
                char rightChar = str.charAt(end++);
                if(freqMap.containsKey(rightChar)){
                    freqMap.put(rightChar, freqMap.get(rightChar) - 1);
                    if(freqMap.get(rightChar) == 0){
                        matchedCount++;
                    }
                }
            }
            //Shrink the window with condition satisfied
            while(start < end && matchedCount == freqMap.size()){
                if(returnStr == "" || returnStr.length() > (end-start)){
                    returnStr = str.substring(start, end);
                }
                char leftChar = str.charAt(start);
                if(freqMap.containsKey(leftChar)){
                    if(freqMap.get(leftChar) == 0){
                        matchedCount--;
                    }
                    freqMap.put(leftChar, freqMap.get(leftChar) + 1);
                }
                start++;
            }
        }
        return returnStr;
    }

}
