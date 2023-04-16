package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class MaxSumAfterPartitioning {

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return maxSum(arr, 0, k, dp);
    }

    private int maxSum(int[] arr, int i, int k, int[] dp){
        if(i == dp.length){
            return 0;
        }else if(dp[i] != -1){
            return dp[i];
        }
        int maxElement = 0;
        int answer = 0;
        int len = 0;
        int n = Math.min(arr.length, i+k);
        for(int j = i; j < n; j++){
            len++;
            maxElement = Math.max(maxElement, arr[j]);
            int currSum = len*maxElement + maxSum(arr, j+1, k, dp);
            answer = Math.max(answer, currSum);
        }
        return dp[i] = answer;
    }

}
