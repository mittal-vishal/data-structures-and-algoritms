package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class HouseRobberI {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxAmount(nums.length-1, nums, dp);
    }

    private int maxAmount(int n, int[] nums, int[] dp){
        if(n < 0){
            return 0;
        }else if(n == 0){
            return nums[0];
        }else if(dp[n] != -1){
            return dp[n];
        }
        int include = nums[n] + maxAmount(n-2, nums,dp);
        int exclude = maxAmount(n-1, nums,dp);
        dp[n] = Math.max(include, exclude);
        return dp[n];
    }

    public int robTabulation(int[] nums) {
        int[] dp = new int[nums.length];
        int n = nums.length;
        dp[0] = nums[0];
        for(int i = 1; i < n; i++){
            int include = i > 1 ? (nums[i] + dp[i-2]): nums[i];
            int exclude = dp[i-1];
            dp[i] = Math.max(include, exclude);
        }
        return dp[n-1];
    }

    public int robSpaceOptimised(int[] nums) {
        int n = nums.length;
        int prev1 = nums[0];
        int prev2 = 0;
        for(int i = 1; i < n; i++){
            int include = i > 1 ? (nums[i] + prev2): nums[i];
            int exclude = prev1;
            int curr = Math.max(include, exclude);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

}
