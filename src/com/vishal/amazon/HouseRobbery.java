package com.vishal.amazon;

public class HouseRobbery {

	public static void main(String[] args) {
		int[] loot = {2,7,9,6,1};
		System.out.println(rob(loot));
	}
	
	public static int rob(int[] nums) {
        int[] dp = new int[nums.length];
        return Math.max(rob(0, 0, nums, dp), rob(1, 0, nums, dp));
    }
    
    public static int rob(int i, int sum, int[] nums, int[] dp)  {
        if (i >= nums.length) return sum;
        sum += nums[i];
        if (dp[i] >= sum) return 0;
        dp[i] = sum;
        return Math.max(rob(i+2, sum, nums, dp), rob(i+3, sum, nums, dp));
    }

}
