package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class PartitionEqualToSubsetSum {

    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if(totalSum % 2 == 1){
            return false;
        }
        int target = totalSum/2;
        int n = nums.length;
        Boolean[][] dp = new Boolean[n][target+1];
        return canPartition(nums.length-1, nums, target, dp);
    }

    private boolean canPartition(int i, int[] nums, int k, Boolean[][] dp){
        if(k == 0){
            return true;
        }else if(i == 0){
            return nums[i] == k;
        }else if(dp[i][k] != null){
            return dp[i][k];
        }else{
            boolean include = false;
            if(k >= nums[i]){
                include = canPartition(i-1, nums, k-nums[i], dp);
            }
            boolean exclude = canPartition(i-1, nums, k, dp);
            return dp[i][k] = include || exclude;
        }
    }

}
