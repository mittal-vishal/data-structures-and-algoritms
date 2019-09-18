package com.vishal.string;

public class AnagramPattern {

	public static void main(String[] args) {
		String str = "geeksforgeeks";
		String pattern = "egesk";
		System.out.println(find(str, pattern));
	}

	private static boolean find(String str, String pattern) {
		int patternChar[] = new int[128];
		int strChar[] = new int[128];
		for (int i = 0; i < pattern.length(); i++) {
			patternChar[pattern.charAt(i)]++;
		}
		for (int i = 0; i < pattern.length(); i++) {
			strChar[str.charAt(i)]++;
		}
		for (int i = pattern.length(); i < str.length(); i++) {
			if (isMatch(patternChar, strChar)) {
				return true;
			} else {
				strChar[pattern.length()]++;
				strChar[i - pattern.length()]--;
			}
		}
		return false;
	}

	private static boolean isMatch(int[] patternChar, int[] strChar) {
		for (int i = 0; i < patternChar.length; i++) {
			if (patternChar[i] != strChar[i]) {
				return false;
			}
		}
		return true;
	}

}
