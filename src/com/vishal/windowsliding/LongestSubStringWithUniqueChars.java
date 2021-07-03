package com.vishal.windowsliding;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithUniqueChars {

    public static void main(String[] args) {
        System.out.print(findLength("dvdf"));
    }

    public static int findLength(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int left = 0, right = 0;
        int max = Integer.MIN_VALUE;
        Set<Character> charsSet = new HashSet<>();
        while(right < s.length()){
            //Expand the window, untill cond satisfies
            char currChar = s.charAt(right);
            if(!charsSet.contains(currChar)){
                charsSet.add(currChar);
                right++;
                max = Math.max(max, (right - left));
            }else{
                //Shrinking the window until cond satisfies
                while(left < right && charsSet.contains(currChar)){
                    charsSet.remove(s.charAt(left++));
                }
            }
        }
        return max;
    }

}
