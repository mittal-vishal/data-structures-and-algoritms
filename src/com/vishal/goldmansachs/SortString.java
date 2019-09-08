package com.vishal.goldmansachs;

import java.util.Arrays;

public class SortString {

	public static void main(String[] args) {
		String s = "hlq";
		sort(s);
	}

	private static void sort(String s) {
		int range[] = new int[128];
		char[] output = new char[s.length()];
		Arrays.fill(range, 0);
		for(int i = 0; i<s.length();i++) {
			range[s.charAt(i)]++;
		}
		for(int i = 1; i<range.length;i++) {
			range[i] = range[i] + range[i-1];
		}
		for(int i = 0; i<s.length();i++) {
			output[range[s.charAt(i)]-1] = s.charAt(i);
			range[s.charAt(i)] = range[s.charAt(i)]-1;
		}
		System.out.println(String.valueOf(output));
	}

}
