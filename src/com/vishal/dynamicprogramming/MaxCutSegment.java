package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class MaxCutSegment {

	private static int[] memo;

	public static void main(String[] args) {
		int n = 5;
		int a = 2, b = 1, c = 5;
		memo = new int[n];
		Arrays.fill(memo, -1);
		System.out.println(getMaxCuts(n, a, b, c));
	}

	private static int getMaxCuts(int n, int a, int b, int c) {
		if (n <= 0) {
			return 0;
		} else if (memo[n - 1] != -1) {
			return memo[n - 1];
		} else {
			memo[n - 1] = 1
					+ maxOfThree(getMaxCuts(n - a, a, b, c), getMaxCuts(n - b, a, b, c), getMaxCuts(n - c, a, b, c));
			return memo[n - 1];
		}
	}

	private static int maxOfThree(int a, int b, int c) {
		if (a >= b && a >= c) {
			return a;
		} else if (b >= a && b >= c) {
			return b;
		} else
			return c;
	}

}
