package com.vishal.dynamicprogramming;

public class MinJumpsToReachEnd {

	public static void main(String[] args) {
		int[] array = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		System.out.println(jump(array));
	}

	public static int jump(int[] nums) {

		if (nums == null || nums.length == 1) {
			return 0;
		}

		int maxStep = nums[0];
		int maxPos = nums[0];
		int jump = 1;

		for (int i = 1; i < nums.length; i++) {
			if (maxStep < i) {
				jump++;
				maxStep = maxPos;
			}
			maxPos = Math.max(maxPos, nums[i] + i);
		}

		return jump;
	}

	public boolean canJump(int[] nums) {
		int start = nums[0];

		for (int i = 1; i < nums.length; i++) {
			if (start < i) {
				return false;
			}
			start = Math.max(start, nums[i] + i);
		}

		return true;

	}

}
