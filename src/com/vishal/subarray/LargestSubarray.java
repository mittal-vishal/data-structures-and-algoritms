package com.vishal.subarray;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarray {

	public static void main(String[] args) {
		int arr[] = {15, -2, 2, -8, 1, 7, 10, 23};
		System.out.println(find(arr));

	}

	private static int find(int[] arr) {
		int large = Integer.MIN_VALUE;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++) {
			sum = sum + arr[i];
			if(arr[i] == 0 && large == Integer.MIN_VALUE) {
				large = 1;
			}
			if(sum == 0) {
				large = i + 1;
			}
			if(map.containsKey(sum)) {
				large = Math.max(large, (i-map.get(sum)));
			}else {
				map.put(sum, i);
			}
		}
		return large;
	}

}
