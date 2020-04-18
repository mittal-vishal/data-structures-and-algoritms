package com.vishal.string;

import java.util.Arrays;

public class AnagramPatternNotOptimal {

	public static void main(String[] args) {
		String str = "eeksforgeeks";
		String pattern = "egek";
		System.out.println(find(str, pattern));
	}

	private static boolean find(String str, String pattern) {
		for (int i = 0; i < str.length() - pattern.length(); i++) {
			if (isAnagram(str.substring(i, i + pattern.length()), pattern)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isAnagram(String text, String pattern) {
		int[] occur = new int[128];
		Arrays.fill(occur, 0);
		for (int i = 0; i < text.length(); i++) {
			occur[text.charAt(i)]++;
		}
		for (int i = 0; i < pattern.length(); i++) {
			occur[pattern.charAt(i)]--;
		}
		for (int i = 0; i < 128; i++) {
			if (occur[i] != 0) {
				return false;
			}
		}
		return true;
	}

}
