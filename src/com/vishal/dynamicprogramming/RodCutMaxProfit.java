package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class RodCutMaxProfit {

	private static Map<String, Integer> map;

	public static void main(String[] args) {
		int W = 8;
		int price[] = { 3, 5, 8, 9, 10, 17, 17, 20 };
		int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		map = new HashMap<>();
		System.out.println(getMaxProfit(W, price, length, price.length));
	}

	private static int getMaxProfit(int W, int[] val, int[] w, int n) {
		if (n == 0 || W == 0) {
			return 0;
		} else {
			String key = String.valueOf(n).concat("|").concat(String.valueOf(W));
			if (map.containsKey(key)) {
				return map.get(key);
			} else {
				int included = W - w[n - 1] >= 0 ? getMaxProfit(W - w[n - 1], val, w, n) + val[n - 1]
						: getMaxProfit(W, val, w, n - 1);
				int excluded = getMaxProfit(W, val, w, n - 1);
				map.put(key, Math.max(included, excluded));
				return map.get(key);
			}
		}
	}

}
