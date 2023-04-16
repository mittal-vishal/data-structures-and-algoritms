package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class ClimbStairs {

	public int climbStairs(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		return countWays(n,dp);
	}

	private int countWays(int n,int[]dp){
		if(n == 0){
			return 1;
		}else if(n < 0){
			return 0;
		}else if(dp[n] != -1){
			return dp[n];
		}else{
			int oneStep = countWays(n-1,dp);
			int twoStep = countWays(n-2,dp);
			dp[n] = oneStep+twoStep;
			return dp[n];
		}
	}

	public int climbStairsTabulation(int n) {
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int step = 2; step <= n; step++){
			dp[step] = dp[step-1] + dp[step-2];
		}
		return dp[n];
	}

}
