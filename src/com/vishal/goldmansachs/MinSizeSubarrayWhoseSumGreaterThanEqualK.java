package com.vishal.goldmansachs;

public class MinSizeSubarrayWhoseSumGreaterThanEqualK {

	public int minSubArrayLen(int s, int[] nums) {

		int start = 0;
		int end = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;

		while (end < nums.length) {

			while (sum <= s && end < nums.length) {
				sum = sum + nums[end++];
				if (sum >= s && (end - start) < min) {
					min = end - start;
				}
			}

			while (sum > s && start < nums.length) {
				sum = sum - nums[start++];
				if (sum >= s && (end - start) < min) {
					min = end - start;
				}
			}

		}

		return (min == Integer.MAX_VALUE) ? 0 : min;

	}

}
