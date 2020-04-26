package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class Fibonacci {
	
	private static int memo[];

	public static void main(String[] args) {
		int n = 9;
		memo = new int[n + 1];
		Arrays.fill(memo, -1);
		System.out.println(print(n));
	}
	
	private static int print(int n) {
		if(n <= 1) {
			return 1;
		}else if(memo[n] != -1){
			return memo[n];
		}else {
			memo[n] = print(n-1) + print(n-2);
			return memo[n];
		}
	}

}
