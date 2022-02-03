package com.vishal.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ZeroOneknapSack {

	public static void main(String[] args) {
		int n = 4;
		int[] w = {5,4,6,3};
		int capacity = 10;
		int[] val = {10,40,30,50};
		ZeroOneknapSack knapSack = new ZeroOneknapSack();
		int profit = knapSack.getMaxProfit(capacity, val, w);
		System.out.println(profit);
		//Tabulation
		int maxProfit = knapSack.knapsack(capacity, val, w);
		System.out.println(maxProfit);
	}

	private int getMaxProfit(int capacity, int[] val, int[] w){
		int n = w.length;
		int[][] dp = new int[capacity + 1][n + 1];
		for(int i = 0; i < dp.length; i++){
			Arrays.fill(dp[i], -1);
		}
		return getMaxProfit(capacity, val, w, n-1, dp);
	}

	private int getMaxProfit(int capacity, int[] val, int[] w, int n, int[][] dp){
		if(n < 0 || capacity < 0){
			return 0;
		}else if(dp[capacity][n] != -1){
			return dp[capacity][n];
		}else if(capacity < w[n]){
			return getMaxProfit(capacity, val, w, n-1, dp);
		}else{
			int include = val[n] + getMaxProfit(capacity - w[n], val, w, n-1, dp);
			int exclude = getMaxProfit(capacity, val, w, n-1, dp);
			dp[capacity][n] = Math.max(include, exclude);
			return dp[capacity][n];
		}
	}

	/*
	* Tabulation
	* */
	private int knapsack(int capacity, int[] val, int[] w){
		int n = w.length;
		int[][] dp = new int[n + 1][capacity + 1];
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= capacity; j++){
				if(j >= w[i-1]){
					int include = val[i-1] + dp[i-1][j - w[i-1]];
					int exclude = dp[i-1][j];
					dp[i][j] = Math.max(include,exclude);
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][capacity];
	}
}
