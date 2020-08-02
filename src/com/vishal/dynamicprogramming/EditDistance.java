package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {

	public static void main(String[] args) {
		String s1 = "horse";
		String s2 = "ros";
		System.out.println(minDistance(s1, s2));
	}

	public static int minDistance(String word1, String word2) {
        Map<String, Integer> lookup = new HashMap<>();
        return minDistance(lookup, word1, word2, word1.length() - 1, word2.length() - 1);
    }
    
    private static int minDistance(Map<String, Integer> lookup, String word1, String word2, int i, int j) {
        String key = i + "|" + j;
        if(i == -1 && j == -1){
            return 0;
        }else if(i == -1 || j == -1){
            return Math.abs(i - j);
        }else if(lookup.containsKey(key)){
            return lookup.get(key);
        }else if(word1.charAt(i) == word2.charAt(j)){
            lookup.put(key , minDistance(lookup, word1, word2, i - 1, j - 1));
            return lookup.get(key);
        }else{
            lookup.put(key, 1 + Math.min(
                minDistance(lookup, word1, word2, i, j - 1),
                Math.min(
                    minDistance(lookup, word1, word2, i - 1, j),
                    minDistance(lookup, word1, word2, i - 1, j - 1)
                )
            ));
            return lookup.get(key);
        }
    }

}
