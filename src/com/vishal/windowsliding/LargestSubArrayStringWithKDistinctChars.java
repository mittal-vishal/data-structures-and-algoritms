package com.vishal.windowsliding;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayStringWithKDistinctChars {

    public static void main(String[] args) {
        String str = "araaci";
        int k = 2;
        System.out.print(findLength(str, k));
    }

    public static int findLength(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int longest = Integer.MIN_VALUE;
        while(end < str.length()){
            //Expand the window until cond satisfies
            char rightChar = str.charAt(end++);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            //Contract the window until cond satisfies
            while(start < end && map.size() > k){
                char leftChar = str.charAt(start++);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0){
                    map.remove(leftChar);
                }
            }
            longest = Math.max(longest, end - start);
        }
        return longest;
    }
}
