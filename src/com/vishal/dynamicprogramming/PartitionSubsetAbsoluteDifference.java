package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class PartitionSubsetAbsoluteDifference {

    private static int INT_MAX = 100000000;
    public static int minSubsetSumDifference(int[] arr, int n) {
        int totalSum = Arrays.stream(arr).sum();
        int[][] dp = new int[n][totalSum+1];
        subsetSum(arr, totalSum, dp);
        int result = INT_MAX;
        for(int sum = 0; sum <= totalSum/2; sum++){
            if(dp[n-1][sum] == 1){
                int expectedMin = Math.abs((totalSum - sum) - sum);
                result = Math.min(result, expectedMin);
            }
        }
        return result;
    }

    private static void subsetSum(int arr[], int k, int[][] dp){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        if(arr[0] <= k){
            dp[0][arr[0]] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int target = 1; target <= k; target++){
                int include = 0;
                if(target >= arr[i]){
                    include = dp[i-1][target-arr[i]];
                }
                int exclude = dp[i-1][target];
                dp[i][target] = (include == 1 || exclude == 1)? 1: 0;
            }
        }
    }

}
