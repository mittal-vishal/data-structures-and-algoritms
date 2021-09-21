package com.vishal.google;

public class MinJumpsToReachEnd {

	public static void main(String[] args) {
		int[] array = { 2, 3, 1, 1, 4 };
		System.out.println(jump(array));
	}

	public static int jump(int[] nums) {

		if(nums == null || nums.length <= 1){
			return 0;
		}

		int jumps = 1;
		int currJumpReach = nums[0];
		int maxReach = nums[0];

		for(int i = 1; i < nums.length; i++){
			if(currJumpReach < i){
				jumps++;
				currJumpReach = maxReach;
			}
			maxReach = Math.max(maxReach, i + nums[i]);
		}

		return jumps;
	}

	public boolean canJump(int[] nums) {
		if(nums == null || nums.length == 0){
			return false;
		}

		int maxReach = nums[0];

		for(int i = 1; i < nums.length; i++){
			if(maxReach < i){
				return false;
			}
			maxReach = Math.max(maxReach, i +  nums[i]);
		}

		return true;

	}

}
