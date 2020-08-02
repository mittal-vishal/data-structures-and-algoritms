package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class LCS {

	public static void main(String[] args) {
		String s1 = "abcdgh";
		String s2 = "aedfhr";
		System.out.println(longestCommonSubsequence(s1, s2));
	}

	public static int longestCommonSubsequence(String text1, String text2) {
        Map<String, Integer> lookUp = new HashMap<>();
        return lcs(lookUp, text1, text2, text1.length() - 1, text2.length() - 1);
    }
    
    private static int lcs(Map<String, Integer> lookUp, String text1, String text2, int i, int j) {
        String key = i+"|"+j;
        if(i < 0 || j < 0){
            return 0;
        }else if(lookUp.containsKey(key)){
            return lookUp.get(key);
        }else if(text1.charAt(i) == text2.charAt(j)){
            lookUp.put(key, 1 + lcs(lookUp, text1, text2, i-1, j-1));
            return lookUp.get(key);
        }else{
            lookUp.put(key, Math.max(lcs(lookUp, text1, text2, i-1, j), lcs(lookUp, text1, text2, i, j-1)));
            return lookUp.get(key);
        }
    }

}
