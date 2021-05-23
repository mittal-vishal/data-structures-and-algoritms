package com.vishal.windowsliding;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithUniqueChars {

    public static void main(String[] args) {
        System.out.print(findLength("aabccbb"));
    }

    public static int findLength(String str) {
        Set<Character> set = new HashSet<>();
        int start = 0, end = 0;
        int max = Integer.MIN_VALUE;
        while(end < str.length()){
            //Expand the window, until cond doesn't break
            if(!set.contains(str.charAt(end))) {
                set.add(str.charAt(end++));
            }else{
                //Contract the window, untill it satisfies the cond
                while(start < end && set.contains(str.charAt(end))){
                    set.remove(str.charAt(start++));
                }
            }
            max = Math.max(max, end - start);
        }
        return max != Integer.MIN_VALUE ? max : 0;
    }

}
