package com.vishal.google;

public class JumpGameI {

	public static void main(String[] args) {
		int[] array = { 2, 3, 1, 1, 4 };
		System.out.println(canJump(array));
	}

	public static boolean canJump(int[] nums) {
		int jumps = nums[0];
		int n = nums.length;
		if(n == 1){
			return true;
		}
		for(int i = 0; i < n; i++){
			jumps = Math.max(jumps, nums[i]);
			if((i + jumps) >= n-1){
				return true;
			}else if(jumps <= 0){
				return false;
			}
			jumps--;
		}
		return false;
	}

}
