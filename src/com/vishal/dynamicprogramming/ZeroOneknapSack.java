package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class ZeroOneknapSack {

	private static Map<String, Integer> map;
	
	public static void main(String[] args) {
		int n = 4;
		int[] w = {5,4,6,3};
		int W = 10;
		int[] val = {10,40,30,50};
		map = new HashMap<>();
		System.out.println(getMaxProfit(W, val, w, n));
	}

	private static int getMaxProfit(int W, int[] val, int[] w, int n) {
		if(n == 0 || W == 0) {
			return 0;
		}else if(W < 0) {
			return getMaxProfit(W, val, w, n-1);
		}
		else {
			String key = String.valueOf(n).concat("|").concat(String.valueOf(W));
			if(!map.containsKey(key)) {
				int included = W-w[n-1]>= 0 ? getMaxProfit(W-w[n-1], val, w, n-1) + val[n-1] : getMaxProfit(W-w[n-1], val, w, n-1);
				int excluded = getMaxProfit(W, val, w, n-1);
				map.put(key, Math.max(included, excluded));
			}
			return map.get(key);
		}
	}

}
