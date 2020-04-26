package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class NumberOfWaysReachTopStair {

	private static int[] memo;

	public static void main(String[] args) {
		int n = 5;
		memo = new int[n];
		Arrays.fill(memo, -1);
		System.out.println(reachTop(n, 0));
	}

	private static int reachTop(int end, int start) {
		if (start == end) {
			return 1;
		} else if (start > end) {
			return 0;
		} else if (memo[start] != -1) {
			return memo[start];
		} else {
			memo[start] = reachTop(end, start + 1) + reachTop(end, start + 2) + reachTop(end, start + 3);
			return memo[start];
		}
	}

}
