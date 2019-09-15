package com.vishal.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class LeftMostRepeatedChar {

	public static void main(String[] args) {
		String s = "geeksforgeeks";
		System.out.println(find(s));

	}

	private static int find(String s) {
		Map<Character, Integer> charMap = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!charMap.containsKey(s.charAt(i))) {
				charMap.put(s.charAt(i), i);
			} else {
				return charMap.get(s.charAt(i));
			}
		}
		return -1;
	}

}
