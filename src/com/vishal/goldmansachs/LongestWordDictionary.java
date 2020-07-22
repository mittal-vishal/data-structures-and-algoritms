package com.vishal.goldmansachs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordDictionary {

	public static void main(String[] args) {
		String[] words = { "w", "wo", "wor", "worl", "world" };
		System.out.println(longestWord(words));
	}

	public static String longestWord(String[] words) {
		Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String returnStr = "";
        for(String s : words){
            if(s.length() == 1 || set.contains(s.substring(0, s.length() - 1))){
                set.add(s);
                if(s.length() > returnStr.length()){
                	returnStr = s;
                }
            }
        }
        return returnStr;
	}

}
