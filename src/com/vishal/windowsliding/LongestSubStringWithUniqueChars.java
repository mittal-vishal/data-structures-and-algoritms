package com.vishal.windowsliding;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithUniqueChars {

    public static void main(String[] args) {
        System.out.print(findLength("dvdf"));
    }

    public static int findLength(String s) {
        Set<Character> uniques = new HashSet<>();
        int left = 0;
        int right = 0;
        int result = 0;
        while(right < s.length()){
            char ch = s.charAt(right++);
            if(!uniques.contains(ch)){
                uniques.add(ch);
            }else{
                while(uniques.contains(ch) && left < right){
                    char removeChar = s.charAt(left++);
                    uniques.remove(removeChar);
                }
                uniques.add(ch);
            }
            result = Math.max(result, (right-left));
        }
        return result;
    }

}
