package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class MCM {

    public static int matrixMultiplication(int[] arr , int N) {
        int[][] dp = new int[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(dp[i], -1);
        }
        return minCost(1, N-1, arr, dp);
    }

    private static int minCost(int i, int j, int[] arr, int[][] dp){
        if(i == j){
            return 0;
        }else if(dp[i][j] != -1){
            return dp[i][j];
        }
        int result = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int cost = arr[i-1]*arr[k]*arr[j];
            int left = minCost(i, k, arr, dp);
            int right = minCost(k+1, j, arr, dp);
            int totalCost = cost + left + right;
            result = Math.min(result, totalCost);
        }
        return dp[i][j] = result;
    }

}
