package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class HouseRobberII {

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int includingLast = maxMoney(1, n-1, nums, dp);
        Arrays.fill(dp, -1);
        int includingFirst = maxMoney(0, n-2, nums, dp);
        return Math.max(includingFirst, includingLast);
    }

    private int maxMoney(int start, int end, int[] nums, int[] dp){
        if(end < start){
            return 0;
        }else if(dp[end] != -1){
            return dp[end];
        }
        int robbed = nums[end] + maxMoney(start, end-2, nums, dp);
        int notRobbed = maxMoney(start, end-1, nums, dp);
        dp[end] = Math.max(robbed, notRobbed);
        return dp[end];
    }

}
