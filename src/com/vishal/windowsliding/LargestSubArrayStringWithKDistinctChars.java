package com.vishal.windowsliding;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayStringWithKDistinctChars {

    public static void main(String[] args) {
        String str = "araaci";
        int k = 2;
        System.out.print(findLength(str, k));
    }

    public static int findLength(String s, int k) {
        Map<Character, Integer> occurances = new HashMap<>();
        int left = 0;
        int right = 0;
        int longest = 0;
        while(right < s.length()){
            char ch = s.charAt(right++);
            occurances.put(ch, occurances.getOrDefault(ch, 0) + 1);
            while(occurances.size() > k && left < right){
                char removeChar = s.charAt(left++);
                if(occurances.get(removeChar) > 1){
                    occurances.put(removeChar, occurances.get(removeChar) - 1);
                }else{
                    occurances.remove(removeChar);
                }
            }
            longest = Math.max(longest, (right-left));
        }
        return longest;
    }
}
