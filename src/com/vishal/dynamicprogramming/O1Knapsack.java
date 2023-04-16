package com.vishal.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class O1Knapsack {
	//Function to return max value that can be put in knapsack of capacity W.
	static int knapsack(int W, int wt[], int val[], int n) {
		int[][]dp = new int[n][W+1];
		for(int i = 0; i < n; i++){
			Arrays.fill(dp[i], -1);
		}
		return knapsack(W, wt, val, n-1, dp);
	}

	private static int knapsack(int W, int wt[], int val[], int index, int[][]dp){
		if(index == 0){
			if(W >= wt[0]){
				return val[0];
			}
			return 0;
		}else if(dp[index][W] != -1){
			return dp[index][W];
		}
		int include = 0;
		if(W >= wt[index]){
			include = val[index] + knapsack(W-wt[index], wt, val, index-1, dp);
		}
		int exclude = knapsack(W, wt, val, index-1, dp);
		dp[index][W] = Math.max(include, exclude);
		return dp[index][W];
	}

	/*
	* Tabulation
	* */
	static int knapSack(int W, int wt[], int val[], int n) {
		int[][]dp = new int[n][W+1];
		for(int itemWeight = wt[0]; itemWeight <= W; itemWeight++){
			dp[0][itemWeight] = val[0];
		}
		for(int item = 1; item < n; item++){
			for(int weight = 0; weight <= W; weight++){
				int include = 0;
				if(weight >= wt[item]){
					include = val[item] + dp[item-1][weight-wt[item]];
				}
				int exclude = dp[item-1][weight];
				dp[item][weight] = Math.max(include, exclude);
			}
		}
		return dp[n-1][W];
	}
}
