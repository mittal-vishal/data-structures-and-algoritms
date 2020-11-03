package com.vishal.subarray;

import java.util.HashMap;
import java.util.Map;

public class KSumSubArraysCount {

	public static void main(String[] args) {
		int arr[] = { 1, 1, 1, 1, -1 };
		int k = 3;
		System.out.println(find(arr, k));

	}

	private static int find(int[] arr, int k) {
		int count = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (sum == k) {
				count++;
			}
			if (map.containsKey(sum - k)) {
				count = count + map.get(sum - k);
			}
			if (map.get(sum) != null) {
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}
		}
		return count;
	}

}
