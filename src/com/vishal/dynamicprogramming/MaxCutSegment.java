package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class MaxCutSegment {

	public static void main(String[] args) {
		int n = 5;
		int a = 5;
		int b = 3;
		int c = 2;
		int[] memo = new int[n];
		Arrays.fill(memo, -1);
		System.out.println(maximizeCuts(n, a, b, c));
	}

	public static int maximizeCuts(int n, int x, int y, int z) {
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);

		int result = maximizeTheCuts(memo, n, x, y, z);
		return result == Integer.MIN_VALUE ? 0 : result;
	}

	private static int maximizeTheCuts(int[] memo, int n, int x, int y, int z) {
		if (n < 0) {
			return Integer.MIN_VALUE;
		} else if (n == 0) {
			return 0;
		} else if (memo[n] != -1) {
			return memo[n];
		} else {
			int result = Math.max(maximizeTheCuts(memo, n - x, x, y, z),
					Math.max(maximizeTheCuts(memo, n - y, x, y, z), maximizeTheCuts(memo, n - z, x, y, z)));
			memo[n] = result != Integer.MIN_VALUE ? result + 1 : result;
			return memo[n];
		}
	}

}
