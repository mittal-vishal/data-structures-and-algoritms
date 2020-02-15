package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CoinsSumCombinations {
	
	private static Map<String, Integer> lookUp;

	public static void main(String[] args) {
		int val = 10;
		int[] coins = { 2, 5, 3, 6 };
		lookUp = new HashMap<>();
		System.out.println(getCombinations(val, coins, coins.length));
	}

	private static int getCombinations(int val, int[] coins, int n) {
		String key = String.valueOf(n) + "|" + String.valueOf(val);
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
