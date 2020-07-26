package com.vishal.goldmansachs;

import java.util.HashMap;
import java.util.Map;

public class WordDictionaryMaxLengthWord {

	public static void main(String[] args) {
		String[] dict = {"to", "banana", "toe", "dogs", "ababcd", "elephant"};
		String input = "eot";
		System.out.println(getMaxLength(dict, input));
	}
	
	private static String getMaxLength(String[] dict, String input) {
		int maxLength = Integer.MIN_VALUE;
		String returnString = "";
		for(String word : dict) {
			if(isUnique(word, input) && word.length() > maxLength) {
				maxLength = word.length();
				returnString = word;
			}
		}
		return returnString;
	}

	private static boolean isUnique(String word, String input) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < word.length(); i++) {
			if(!map.containsKey(word.charAt(i))) {
				map.put(word.charAt(i), 1);
			}else {
				map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
			}
		}
		for(int i = 0; i< input.length();i++) {
			if(map.containsKey(input.charAt(i))) {
				if(map.get(input.charAt(i)) > 1) {
					map.put(input.charAt(i), map.get(input.charAt(i))-1);
				}else {
					map.remove(input.charAt(i));
				}
			}
		}
		if(map.size() == 0) {
			return true;
		}else {
			return false;
		}
	}

}
