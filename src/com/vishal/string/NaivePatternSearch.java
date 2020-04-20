package com.vishal.string;

public class NaivePatternSearch {

	public static void main(String[] args) {
		String str = "abcdabcabcd";
		String pattern = "abc";
		find(str, pattern);
	}

	private static void find(String str, String pattern) {
		int n = str.length(), m = pattern.length();
		for (int i = 0; i < n - m; i++) {
			boolean isMatch = true;
			for (int j = 0; j < m; j++) {
				if (str.charAt(i + j) != pattern.charAt(j)) {
					isMatch = false;
					break;
				}
			}
			if (isMatch) {
				System.out.println(i);
			}
		}
	}

}