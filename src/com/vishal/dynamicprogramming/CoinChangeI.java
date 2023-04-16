package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class CoinChangeI {

	private int INT_MAX = 100000000;

	public int coinChange(int[] coins, int amount) {
		int n = coins.length;
		int[][] dp = new int[n][amount+1];
		for(int i = 0; i < n; i++){
			Arrays.fill(dp[i], -1);
		}
		int res = minCoins(coins, n-1, amount, dp);
		return res != INT_MAX? res: -1;
	}

	private int minCoins(int[] coins, int n, int amount, int[][] dp){
		if(n == 0){
			if(amount % coins[0] == 0){
				return amount/coins[0];
			}else{
				return INT_MAX;
			}
		}else if(dp[n][amount] != -1){
			return dp[n][amount];
		}
		int exclude  = minCoins(coins, n-1, amount, dp);
		int include = INT_MAX;
		if(coins[n] <= amount){
			include = 1 + minCoins(coins, n, amount-coins[n], dp);
		}
		dp[n][amount] = Math.min(include, exclude);
		return dp[n][amount];
	}

	public int coinChangeTabulation(int[] coins, int amount) {
		int n = coins.length;
		int[][] dp = new int[n][amount+1];
		for(int target = 0; target <= amount; target++){
			if(target % coins[0] == 0){
				dp[0][target] = target/coins[0];
			}else{
				dp[0][target] = INT_MAX;
			}
		}
		for(int index = 1; index < n; index++){
			for(int target = 0; target <= amount; target++){
				int exclude  = dp[index-1][target];
				int include = INT_MAX;
				if(coins[index] <= target){
					include = 1 + dp[index][target-coins[index]];
				}
				dp[index][target] = Math.min(include, exclude);
			}
		}
		return dp[n-1][amount] != INT_MAX ? dp[n-1][amount]: -1;
	}

	public int coinChangeSpaceOptimised(int[] coins, int amount) {
		int n = coins.length;
		int[] prev = new int[amount+1];
		int[] curr = new int[amount+1];
		for(int target = 0; target <= amount; target++){
			if(target % coins[0] == 0){
				prev[target] = target/coins[0];
			}else{
				prev[target] = INT_MAX;
			}
		}
		for(int index = 1; index < n; index++){
			for(int target = 0; target <= amount; target++){
				int exclude  = prev[target];
				int include = INT_MAX;
				if(coins[index] <= target){
					include = 1 + curr[target-coins[index]];
				}
				curr[target] = Math.min(include, exclude);
			}
			prev = curr;
		}
		return prev[amount] != INT_MAX ? prev[amount]: -1;
	}

}
