package com.vishal.string;

import java.util.Arrays;

public class LeftMostNotRepeatedChar {

	public static void main(String[] args) {
		String s = "geeksforgeeks";
		System.out.println(find(s));

	}

	private static int find(String s) {
		int[] occurence = new int[256];
		//Filling occurrence as -1
		Arrays.fill(occurence, -1);
		//Iterating over a string
		for (int i = 0; i < s.length(); i++) {
			//If ist occurence of char, store the index
			if (occurence[s.charAt(i)] == -1) {
				occurence[s.charAt(i)] = i;
			} else {
				occurence[s.charAt(i)] = -2;
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 256; i++) {
			if(occurence[i] >= 0) {
				min = Math.min(min, occurence[i]);
			}
		}
		return min != Integer.MAX_VALUE ? min : -1;
	}

}
