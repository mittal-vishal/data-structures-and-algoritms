package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class SubsetSum {

	public static void main(String[] args) {
		int sum = 9;
		int[] arr = { 3, 34, 4, 12, 5, 2 };
		Map<String, Boolean> lookup = new HashMap<>();
		System.out.println(find(lookup, sum, arr, arr.length));
	}

	private static boolean find(Map<String, Boolean> lookup, int sum, int[] arr, int length) {
		String key = sum + "|" + length;
		if (lookup.containsKey(key)) {
			return lookup.get(key);
		} else if (sum == 0) {
			return true;
		} else if (length < 1 || sum < 0) {
			return false;
		} else if (sum < arr[length - 1]) {
			lookup.put(key, find(lookup, sum, arr, length - 1));
		} else {
			lookup.put(key, find(lookup, sum - arr[length - 1], arr, length - 1) || find(lookup, sum, arr, length - 1));
		}
		return lookup.get(key);
	}

}
