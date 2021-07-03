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
        if(s == null || s.length() == 0 || k == 0){
            return 0;
        }
        int left = 0, right = 0;
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> occuranceMap = new HashMap<>();
        while(right < s.length()){
            //Expand the window until condition satisfies
            if(occuranceMap.size() <= k){
                char currentChar = s.charAt(right++);
                occuranceMap.put(currentChar, occuranceMap.getOrDefault(currentChar, 0) + 1);
            }
            if(occuranceMap.size() <= k){
                max = Math.max(max, (right-left));
            }
            //Shrink the window until condition satisfies
            if(occuranceMap.size() > k){
                char removedChar = s.charAt(left++);
                if(occuranceMap.get(removedChar) > 1){
                    occuranceMap.put(removedChar, occuranceMap.get(removedChar) - 1);
                }else{
                    occuranceMap.remove(removedChar);
                }
            }
        }
        return max;
    }
}
