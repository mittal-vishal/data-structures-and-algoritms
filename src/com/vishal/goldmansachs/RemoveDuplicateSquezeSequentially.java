package com.vishal.goldmansachs;

public class RemoveDuplicateSquezeSequentially {

	public static void main(String[] args) {
		String s = "abcd";
		int k = 2;
		System.out.println(removeDuplicates(s, k));

	}

	private static String removeDuplicates(String s, int k) {
		int runningCount = 0;
		char prev = '\0';
		int start = -1;
		int n = s.length();
		int i = 0;

		while(i < n) {
			if (prev == '\0') {
				start = i;
				runningCount = 1;
				prev = s.charAt(i++);
			} else if (prev == s.charAt(i)) {
				runningCount++;
				prev = s.charAt(i++);
			} else if (prev != s.charAt(i)) {
				runningCount = 1;
				prev = s.charAt(i);
				start = i++;
			}
			if (runningCount == k) {
				s = s.substring(0, start).concat(s.substring(start + runningCount, s.length()));
				i = 0;
				n = s.length();
				prev = '\0';
				runningCount = 0;
				start = -1;
			}
		}
		return s;
	}

}
