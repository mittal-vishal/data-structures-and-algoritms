package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class NumberOfWays {
	
	private static int[] memo;

	public static void main(String[] args) {
		int n = 5;
		memo = new int[n+1];
		Arrays.fill(memo, -1);
		System.out.println(reachTop(n));
	}

	private static int reachTop(int n) {
		if(n >= 0 && memo[n] != -1) {
			return memo[n];
		}
		if(n == 0) {
			memo[n] = 1;
		}else if(n < 0) {
			return 0;
		}else {
			memo[n] = reachTop(n-1) + reachTop(n-2) + reachTop(n-3);
		}
		return memo[n];
	}

}
