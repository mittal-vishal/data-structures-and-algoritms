package com.vishal.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RodCutMaxProfit {

	private static int INT_MIN = (int)-1e8;

	public static int cutRod(int price[], int n) {
		int[][] dp = new int[n][n+1];
		for(int i = 0; i < n; i++){
			Arrays.fill(dp[i], -1);
		}
		return maximize(price, n-1, n, dp);
	}

	private static int maximize(int[] price, int index, int length, int[][] dp){
		if(index == 0){
			return length * price[0];
		}else if(dp[index][length] != -1){
			return dp[index][length];
		}
		int exclude = maximize(price, index-1, length, dp);
		int include = INT_MIN;
		if(length >= index+1){
			include = price[index] + maximize(price, index, length-(index+1), dp);
		}
		dp[index][length] = Math.max(include,exclude);
		return dp[index][length];
	}

	public static int cutRodTabulation(int price[], int n) {
		int[][] dp = new int[n][n+1];
		for(int len = 0; len <= n; len++){
			dp[0][len] = len*price[0];
		}
		for(int i = 1; i < n; i++){
			for(int len = 0; len <= n; len++){
				int exclude = dp[i-1][len];
				int include = INT_MIN;
				if(len >= i+1){
					include = price[i] + dp[i][len-(i+1)];
				}
				dp[i][len] = Math.max(include,exclude);
			}
		}
		return dp[n-1][n];
	}

}
