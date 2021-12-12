package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class ClimbStairs {

	public int climbStairs(int n) {
		int[] memo = new int[n+1];
		Arrays.fill(memo, -1);
		return climbStairs(0, n, memo);
	}

	private int climbStairs(int curr, int n, int[] memo){
		if(curr > n){
			return 0;
		}else if(curr == n){
			return 1;
		}else if(memo[curr] != -1){
			return memo[curr];
		}else{
			int step1 = climbStairs(curr + 1, n, memo);
			int step2 = climbStairs(curr + 2, n, memo);
			memo[curr] = step1 + step2;
			return memo[curr];
		}
	}

}
