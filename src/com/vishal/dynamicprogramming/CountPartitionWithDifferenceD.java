package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class CountPartitionWithDifferenceD {

    private static int MOD = (int)1e9+7;

    public static int countPartitions(int n, int d, int[] arr) {
        int totalSum = Arrays.stream(arr).sum();
        if((totalSum+d) < 0 || (totalSum+d) % 2 == 1){
            return 0;
        }
        int target = (totalSum+d)/2;
        int[][] dp = new int[n][target+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return countWays(arr, n-1, target, dp);
    }

    private static int countWays(int[] nums, int ind, int sum, int[][] dp){
        if(ind == 0){
            if(sum == 0 && nums[ind] == 0){
                return 2;
            }else if(sum == 0 || sum == nums[0]){
                return 1;
            }else{
                return 0;
            }
        }else if(dp[ind][sum] != -1){
            return dp[ind][sum];
        }else{
            int include = 0;
            if(sum >= nums[ind]){
                include = countWays(nums, ind-1, sum-nums[ind], dp);
            }
            int exclude = countWays(nums, ind-1, sum, dp);
            dp[ind][sum] = (include+exclude)%MOD;
            return dp[ind][sum];
        }
    }

}
