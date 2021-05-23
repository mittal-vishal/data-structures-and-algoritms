package com.vishal.windowsliding;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithSameLetterWithKReplacement {

    public static int findLength(String str, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int start = 0, end = 0;
        int maxRepeatLetterCount = 0;
        int max = Integer.MIN_VALUE;
        while(end < str.length()){
            char rightChar = str.charAt(end++);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, freqMap.get(rightChar));

            if(end - start - maxRepeatLetterCount > k){
                char leftChar = str.charAt(start++);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
            }

            max = Math.max(max, end - start);

        }
        return max;
    }

}
