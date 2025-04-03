package com.vishal.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithSameLetterWithKReplacement {

    public static int findLength(String str, int k) {
        Map<Character, Integer> charsMap = new HashMap<>();
        int max = 0;
        int left = 0, right = 0;
        int maxRepeatLetterCount = 0;
        while(right < str.length()){
            //Expand the window until condition satisfies
            char currChar = str.charAt(right++);
            charsMap.put(currChar, charsMap.getOrDefault(currChar, 0) + 1);
            maxRepeatLetterCount = Math.max(maxRepeatLetterCount, charsMap.get(currChar));
            //Shrink the window until cond satisfies
            while((right - left) - maxRepeatLetterCount > k){
                char removeChar = str.charAt(left++);
                charsMap.put(removeChar, charsMap.get(removeChar) - 1);
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        String str ="aaabcpbbbb";
        int k = 2;
        System.out.print(findLength(str, k));
    }

}
