package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class MinCoinsValue {

	public int coinChange(int[] coins, int amount) {
		int[] memo = new int[amount+1];
		Arrays.fill(memo, -1);
		int minCoins = getMinCoins(coins, amount, memo);
		return minCoins != Integer.MAX_VALUE ? minCoins: -1;
	}

	private int getMinCoins(int[] coins, int amount, int[] memo){
		if(amount == 0){
			return 0;
		}
		if(amount < 0){
			return Integer.MAX_VALUE;
		}
		if(memo[amount] != -1){
			return memo[amount];
		}
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < coins.length; i++){
			if(amount - coins[i] >= 0){
				int subprob = getMinCoins(coins, amount - coins[i], memo);
				if(subprob != Integer.MAX_VALUE && (subprob + 1) < ans){
					ans = subprob + 1;
				}
			}
		}
		memo[amount] = ans;
		return ans;
	}

}
