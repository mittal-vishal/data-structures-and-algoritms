package com.vishal.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        int ans = characterReplacement(s, k);
        System.out.println(ans);
    }

    public static int characterReplacement(String s, int k) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int left = 0; int right = 0;
        int n = s.length();
        Map<Character, Integer> charOccurMap = new HashMap<>();
        int maxWindow = 0;
        int maxRepeat = 0;

        while(right < n){
            //Expand until it satisfies
            char currChar = s.charAt(right);
            charOccurMap.put(currChar, charOccurMap.getOrDefault(currChar, 0) + 1);

            maxRepeat = Math.max(maxRepeat, charOccurMap.get(currChar));
            //Shrink if violates
            int currWindowSize = right - left + 1;
            if((currWindowSize - maxRepeat) > k){
                char leftChar = s.charAt(left++);
                if(charOccurMap.get(leftChar) > 1){
                    charOccurMap.put(leftChar, charOccurMap.get(leftChar) - 1);
                }else{
                    charOccurMap.remove(leftChar);
                }
            }
            maxWindow = Math.max(maxWindow, right - left + 1);
            right++;
        }
        return maxWindow;
    }

}
