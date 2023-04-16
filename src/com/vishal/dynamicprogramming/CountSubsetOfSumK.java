package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class CountSubsetOfSumK {

    public static int findWays(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return countWays(num, n-1, tar, dp);
    }

    private static int countWays(int[] nums, int index, int tar, int[][] dp){
        if(index == 0){
            if(tar == 0 && nums[0] == 0){
                return 2;
            }else if(tar == 0 || tar == nums[index]){
                return 1;
            }else {
                return 0;
            }
        }else if(dp[index][tar] != -1){
            return dp[index][tar];
        }else{
            int include = 0;
            if(tar >= nums[index]){
                include = countWays(nums, index-1, tar-nums[index], dp);
            }
            int exclude = countWays(nums, index-1, tar, dp);
            dp[index][tar] = include + exclude;
            return dp[index][tar];
        }
    }

    public static int findWaysTabulation(int num[], int tar) {
        int n = num.length;
        int[][] dp = new int[n][tar+1];
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        if(num[0] <= tar){
            dp[0][num[0]] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int target = 1; target <= tar; target++){
                int include = 0;
                if(target >= num[i]){
                    include = dp[i-1][target-num[i]];
                }
                int exclude = dp[i-1][target];
                dp[i][target] = include+exclude;
            }
        }
        return dp[n-1][tar];
    }

}
