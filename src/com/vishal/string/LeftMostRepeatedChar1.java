package com.vishal.string;

import java.util.Arrays;

public class LeftMostRepeatedChar1 {

	public static void main(String[] args) {
		String s = "geeksforgeeks";
		System.out.println(find(s));

	}

	private static int find(String s) {
		int charArray[] = new int[128];
		int min = Integer.MAX_VALUE;
		Arrays.fill(charArray, -1);
		for (int i = 0; i < s.length(); i++) {
			if (charArray[s.charAt(i)] == -1) {
				charArray[s.charAt(i)] = i;
			} else {
				min = minimum(min, charArray[s.charAt(i)]);
			}
		}
		min = (min == Integer.MAX_VALUE) ? -1 : min;
		return min;
	}

	private static int minimum(int i, int j) {
		if(i < j) {
			return i;
		}else {
			return j;
		}
	}

}
