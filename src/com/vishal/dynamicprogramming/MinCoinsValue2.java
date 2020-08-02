package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class MinCoinsValue2 {

	public static void main(String[] args) {
		int n = 11;
		int[] coins = { 9, 6, 5, 1 };
		Map<String, Integer> lookUp = new HashMap<>();
		System.out.println(getMinCoins(n, coins, coins.length, lookUp));
	}

	private static int getMinCoins(int val, int[] coins, int n, Map<String, Integer> lookUp) {
		String key = n + "|" + val;
		if (val == 0) {
			return 0;
		} else if (n == 0) {
			return Integer.MAX_VALUE;
		} else if (lookUp.containsKey(key)) {
			return lookUp.get(key);
		} else if (val < coins[n - 1]) {
			lookUp.put(key, getMinCoins(val, coins, n - 1, lookUp));
			return lookUp.get(key);
		} else {
			int included = getMinCoins(val - coins[n - 1], coins, n, lookUp) != Integer.MAX_VALUE
					? getMinCoins(val - coins[n - 1], coins, n, lookUp) + 1
					: getMinCoins(val - coins[n - 1], coins, n, lookUp);
			int excluded = getMinCoins(val, coins, n - 1, lookUp);
			lookUp.put(key, Math.min(included, excluded));
			return lookUp.get(key);
		}
	}

}
