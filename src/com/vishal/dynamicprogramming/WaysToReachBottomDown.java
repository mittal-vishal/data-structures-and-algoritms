package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class WaysToReachBottomDown {

	private static Map<String, Integer> map;

	public static void main(String[] args) {
		int m = 3;
		int n = 4;
		map = new HashMap<>();
		System.out.println(getWays(m, n));
	}

	private static int getWays(int m, int n) {
		String key = m + "|" + n;
		if(map.containsKey(key)) {
			return map.get(key);
		}
		if (m == 1 && n == 1) {
			map.put(key, 1);
		} else if (m > 1 && n == 1) {
			map.put(key, getWays(m - 1, n));
		} else if (n > 1 && m == 1) {
			map.put(key, getWays(m, n - 1));
		} else {
			map.put(key, getWays(m - 1, n) + getWays(m, n - 1));
		}
		return map.get(key);
	}

}
