package com.vishal.string;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String str1 = "geeks";
		String str2 = "egesk";
		System.out.println(find(str1, str2));
	}

	private static boolean find(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		int[] charArray = new int[26];
		Arrays.fill(charArray, 0);
		for (int i = 0; i < str1.length(); i++) {
			charArray[str1.charAt(i) - 'a']++;
		}
		for (int i = 0; i < str2.length(); i++) {
			charArray[str2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (charArray[i] != 0)
				return false;
		}
		return true;
	}

}
