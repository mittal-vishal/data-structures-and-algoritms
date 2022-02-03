package com.vishal.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class CanPartitionEqualSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum % 2 == 1){
            return false;
        }else{
            return subsetSum(sum/2, nums);
        }
    }

    private boolean subsetSum(int sum, int[] arr) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j >= arr[i-1]){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

}
