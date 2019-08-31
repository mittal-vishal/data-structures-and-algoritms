package com.vishal.walmart;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class NonRecurringChar {

	public static void main(String[] args) {
		String s = null;
		System.out.println(find(s));
	}

	private static char find(String s) {
		Map<Character, Integer> charSet = new HashMap<Character, Integer>();
		char returnChar = 0;
		for(int i =0;i<s.length();i++) {
			if(!charSet.containsKey(s.charAt(i))) {
				charSet.put(s.charAt(i), i);
			}else {
				charSet.remove(s.charAt(i));
			}
		}
		int min =Integer.MAX_VALUE;
		for(Entry<Character, Integer> entry : charSet.entrySet()) {
			if(entry.getValue() < min) {
				min = entry.getValue();
				returnChar = entry.getKey();
			}
		}
		if(charSet.size()==0) {
			return 0;
		}else {
			return returnChar;
		}
	}

}
