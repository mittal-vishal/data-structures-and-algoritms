package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class UniquePath {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        return uniquePaths(0, 0, m, n, dp);
    }

    private int uniquePaths(int i, int j, int m, int n, int[][] dp){
        if(!isValid(i, j, m, n)){
            return 0;
        }else if(dp[i][j] != -1){
            return dp[i][j];
        }else if(i == m-1 && j == n-1){
            return 1;
        }
        int right = uniquePaths(i, j + 1, m, n, dp);
        int down = uniquePaths(i + 1, j, m, n, dp);
        dp[i][j] = right + down;
        return dp[i][j];
    }

    private boolean isValid(int i, int j, int m, int n){
        if(i >= 0 && i < m && j >= 0 && j < n){
            return true;
        }
        return false;
    }

}
