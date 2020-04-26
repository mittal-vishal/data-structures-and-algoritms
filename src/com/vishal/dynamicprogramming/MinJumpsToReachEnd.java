package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class MinJumpsToReachEnd {

	private static int[] memo;

	public static void main(String[] args) {
		int[] array = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		int n = array.length;
		memo = new int[n];
		Arrays.fill(memo, -1);
		int res = getMinJumps(array, n);
		res = res != Integer.MAX_VALUE ? res : -1;
		System.out.println(res);
	}

	private static int getMinJumps(int[] array, int n) {
		if (n == 1) {
			return 0;
		} else {
			int result = Integer.MAX_VALUE;
			for (int i = 0; i < n - 1; i++) {
				if (i + array[i] >= n - 1) {
					if (memo[n - 1] == -1) {
						int subResult = getMinJumps(array, i + 1);
						if (subResult != Integer.MAX_VALUE) {
							result = Math.min(result, subResult + 1);
						}
						memo[n - 1] = result;
					}
					result = memo[n - 1];
				}
			}
			return result;
		}
	}

}
