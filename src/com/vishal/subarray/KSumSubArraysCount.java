package com.vishal.subarray;

import java.util.HashMap;
import java.util.Map;

public class KSumSubArraysCount {

	public static void main(String[] args) {
		int arr[] = { 1, 1, 1, 1, -1 };
		int k = 3;
		System.out.println(find(arr, k));

	}

	private static int find(int[] nums, int k) {
		if(nums == null || nums.length == 0){
			return 0;
		}

		Map<Integer, Integer> frqMap = new HashMap<>();
		frqMap.put(0, 1);
		int sum = 0;
		int count = 0;

		for(int i = 0; i < nums.length; i++){
			sum += nums[i];
			if(frqMap.containsKey(sum - k)){
				count += frqMap.get(sum - k);
			}
			frqMap.put(sum, frqMap.getOrDefault(sum, 0) + 1);
		}

		return count;
	}

}
