package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class SubsetSum {

	private static Map<String, Boolean> lookup;

	public static void main(String[] args) {
		int sum = 9;
		int[] arr = { 3, 34, 4, 12, 5, 2 };
		lookup = new HashMap<>();
		System.out.println(find(sum, arr, arr.length));
	}

	private static boolean find(int sum, int[] arr, int length) {
		String key = sum + "|" + length;
		if (lookup.containsKey(key)) {
			return lookup.get(key);
		}
		if (sum == 0) {
			lookup.put(key, true);
		} else if (length < 1 || sum < 0) {
			lookup.put(key, false);
		} else if (sum < arr[length - 1]) {
			lookup.put(key, find(sum, arr, length - 1));
		} else {
			lookup.put(key, find(sum - arr[length - 1], arr, length - 1) || find(sum, arr, length - 1));
		}
		return lookup.get(key);
	}

}
