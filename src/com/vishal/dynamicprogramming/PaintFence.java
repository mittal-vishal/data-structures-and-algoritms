package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class PaintFence {

    public int numWays(int n, int k) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return countWays(n, k, dp);
    }

    private int countWays(int n, int k, int[] dp){
        if(n == 1){
            return k;
        }else if(n == 2){
            return k*k;
        }else if(dp[n] != -1){
            return dp[n];
        }else{
            return dp[n] = (k-1)*countWays(n-2, k, dp) + (k-1)*countWays(n-1, k, dp);
        }
    }

}
