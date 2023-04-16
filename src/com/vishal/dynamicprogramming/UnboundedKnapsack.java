package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class UnboundedKnapsack {

    static int knapSack(int N, int W, int val[], int wt[]){
        int[][] dp = new int[N][W+1];
        for(int i = 0; i < N; i++){
            Arrays.fill(dp[i], -1);
        }
        return maximize(N-1, W, val, wt, dp);
    }

    private static int maximize(int n, int W, int[] val, int[] wt, int[][] dp){
        if(n == 0){
            return (int)(W/wt[n])*val[n];
        }else if(dp[n][W] != -1){
            return dp[n][W];
        }
        int include = 0;
        if(W >= wt[n]){
            include = val[n] + maximize(n, W-wt[n], val, wt, dp);
        }
        int exclude = maximize(n-1, W, val, wt, dp);
        dp[n][W] = Math.max(include, exclude);
        return dp[n][W];
    }

    static int knapSackTabulation(int N, int W, int val[], int wt[]){
        int[][] dp = new int[N][W+1];
        for(int weight = 0; weight <= W; weight++){
            dp[0][weight] = (int)(weight/wt[0])*val[0];
        }
        for(int i = 1; i < N; i++){
            for(int weight = 0; weight <= W; weight++){
                int include = 0;
                if(weight >= wt[i]){
                    include = val[i] + dp[i][weight-wt[i]];
                }
                int exclude = dp[i-1][weight];
                dp[i][weight] = Math.max(include, exclude);
            }
        }
        return dp[N-1][W];
    }

}
