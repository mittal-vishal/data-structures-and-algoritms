package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CoinsSumCombinations {
	
	private static Map<String, Integer> lookUp;

	public static void main(String[] args) {
		int val = 8;
		int[] coins = { 2, 5, 3 };
		lookUp = new HashMap<>();
		System.out.println(getCombinations(val, coins, coins.length));
	}

	//Bottom Up approach
	public int change(int amount, int[] coins) {
		int[] dp = new int[amount+1];
		dp[0] = 1;
		for(int i = 0; i < coins.length; i++){
			for(int j = coins[i]; j < dp.length; j++){
				dp[j] += dp[j - coins[i]];
			}
		}
		return dp[amount];
	}

	private static int getCombinations(int val, int[] coins, int n) {
		String key = n + "|" + val;
		int result;
		if(lookUp.containsKey(key)) {
			return lookUp.get(key);
		}
		if(val == 0) {
			return 1;
		}else if(n == 0){
			return 0;
		}else if(coins[n-1] > val) {
			result = getCombinations(val, coins, n-1);
		}else {
			result = getCombinations(val, coins, n-1) + getCombinations(val-coins[n-1], coins, n);
		}
		lookUp.put(key, result);
		return result;
	}

}
