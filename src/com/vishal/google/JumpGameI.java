package com.vishal.google;

public class JumpGameI {

	public static void main(String[] args) {
		int[] array = { 2, 3, 1, 1, 4 };
		System.out.println(canJump(array));
	}

	public static boolean canJump(int[] nums) {
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
