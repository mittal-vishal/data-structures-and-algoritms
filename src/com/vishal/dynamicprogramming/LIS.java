package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class LIS {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return longestOfLIS(nums, 0, -1, dp);
    }

    private int longestOfLIS(int[] nums, int index, int prevIdx, int[][] dp){
        if(index == nums.length){
            return 0;
        }else if(dp[index][prevIdx+1] != -1){
            return dp[index][prevIdx+1];
        }
        int include = 0;
        if(prevIdx == -1 || nums[index] > nums[prevIdx]){
            include = 1 + longestOfLIS(nums, index+1, index, dp);
        }
        int exclude = longestOfLIS(nums, index+1, prevIdx, dp);
        return dp[index][prevIdx+1] = Math.max(include, exclude);
    }

    public int lengthOfLISOtherWay(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLIS = 1;
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        return maxLIS;
    }

}
