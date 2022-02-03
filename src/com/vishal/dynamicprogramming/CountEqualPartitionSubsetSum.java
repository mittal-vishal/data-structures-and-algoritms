package com.vishal.dynamicprogramming;

public class CountEqualPartitionSubsetSum {

    public int numSubseq(int[] nums, int target) {
        return subsetSum(target, nums);
    }

    private int subsetSum(int sum, int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j >= arr[i-1]){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

}
