package com.vishal.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class NonRecurringChar {

	public static void main(String[] args) {
		String s = "geeksffforgeeks";
		System.out.println(find(s));
	}

	private static char find(String str) {
		if(str == null) {
			return 0;
		}
		Map<Character, Integer> charMap = new LinkedHashMap<>();
		int occurance = 0;
		for(int i =0;i<str.length();i++) {
			if(!charMap.containsKey(str.charAt(i))) {
				charMap.put(str.charAt(i), 1);
			}else {
				occurance = charMap.get(str.charAt(i));
				charMap.put(str.charAt(i), ++occurance);
			}
		}
		for(Entry<Character, Integer> entry : charMap.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return 0;
	}

}
