package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class MinCoinsValue {

	private static int[] memo;

	public static void main(String[] args) {
		int n = 30;
		int[] coins = { 25, 10, 5 };
		memo = new int[n];
		Arrays.fill(memo, -1);
		System.out.println(getMinCoins(n, coins));
	}

	private static int getMinCoins(int val, int[] coins) {
		if (val == 0) {
			return 0;
		}else {
			int result = Integer.MAX_VALUE;
			for (int i = 0; i < coins.length; i++) {
				if (coins[i] <= val) {
					if (memo[val - coins[i]] == -1) {
						int subResult = getMinCoins(val - coins[i], coins);
						if (subResult != Integer.MAX_VALUE) {
							result = Math.min(result, subResult + 1);
						}
						memo[val - coins[i]] = result;
					}
					result = memo[val - coins[i]];
				}
			}
			return result != Integer.MAX_VALUE ? result : -1;
		}
	}

}
