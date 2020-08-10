package com.vishal.subarray;

public class MinSubarrayWithSum {
	public static void main(String[] args) {
		int arr1[] = { 1, 5, 45, 6, 10, 19 };
		int item = 51;
		System.out.println(minSubArrayLen(arr1, item));
	}

	public static int minSubArrayLen(int[] nums, int k) {
		int start = 0;
		int end = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		while (end < nums.length) {
			while (sum <= k && end < nums.length) {
				sum = sum + nums[end++];
				if (sum == k) {
					min = end - start;
				}
			}
			while (sum > k && start < nums.length) {
				sum = sum - nums[start++];
				if (sum == k && (end - start) < min) {
					min = end - start;
				}
			}
		}
		return (min == Integer.MAX_VALUE) ? 0 : min;
	}

}
