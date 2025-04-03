package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class PerfectSquares {

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return numSquares(n, dp);
    }

    private int numSquares(int n, int[] dp){
        if(n == 0){
            return 0;
        }else if(dp[n] != -1){
            return dp[n];
        }
        int res = n;
        for(int i = 1; i*i <= n; i++){
            int square = i*i;
            int squares = numSquares(n-square, dp) + 1;
            res = Math.min(res, squares);
        }
        return dp[n] = res;
    }

    public int numSquaresTabulation(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int min = i;
            for(int j = 1; j*j <= i; j++){
                int rem = i - j*j;
                if(dp[rem] < min){
                    min = dp[rem];
                }
            }
            dp[i] = min+1;
        }
        return dp[n];
    }

}
