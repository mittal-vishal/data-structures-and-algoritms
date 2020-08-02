package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class ZeroOneknapSack {

	public static void main(String[] args) {
		int n = 4;
		int[] w = {5,4,6,3};
		int W = 10;
		int[] val = {10,40,30,50};
		Map<String, Integer> map = new HashMap<>();
		System.out.println(getMaxProfit(W, val, w, n, map));
	}

	private static int getMaxProfit(int W, int[] val, int[] w, int n, Map<String, Integer> map) {
		String key = n + "|" + W;
		if(map.containsKey(key)) {
			return map.get(key);
		}else if(n < 1 || W <= 0) {
			return 0;
		}else if(W - w[n-1] < 0) {
			map.put(key, getMaxProfit(W, val, w, n-1, map));
		}else {
			map.put(key, Math.max(val[n-1] + getMaxProfit(W - w[n-1], val, w, n-1, map), getMaxProfit(W, val, w, n-1, map)));
		}
		return map.get(key);
	}

}
