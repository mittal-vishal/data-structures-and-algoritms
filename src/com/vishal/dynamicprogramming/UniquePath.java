package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class UniquePath {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        return count(m-1, n-1, dp);
    }

    private int count(int row, int col, int[][] dp){
        if(row == 0 && col == 0){
            return 1;
        }else if(row < 0 || col < 0){
            return 0;
        }else if(dp[row][col] != -1){
            return dp[row][col];
        }else{
            int up = count(row-1, col, dp);
            int left = count(row, col-1, dp);
            dp[row][col] = up + left;
            return dp[row][col];
        }
    }

    public int uniquePathsTabulation(int m, int n) {
        int[][] dp = new int[m][n];
        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                if(row == 0 && col == 0){
                    dp[row][col] = 1;
                }else{
                    int up = row > 0 ? dp[row-1][col]: 0;
                    int left = col > 0? dp[row][col-1]: 0;
                    dp[row][col] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsSpaceOptimised(int m, int n) {
        int[] prev = new int[n];
        for(int row = 0; row < m; row++){
            int[] curr = new int[n];
            for(int col = 0; col < n; col++){
                if(row == 0 && col == 0){
                    curr[col] = 1;
                }else{
                    int up = row > 0 ? prev[col]: 0;
                    int left = col > 0? curr[col-1]: 0;
                    curr[col] = up + left;
                }
            }
            prev = curr;
        }
        return prev[n-1];
    }

    private boolean isValid(int i, int j, int m, int n){
        if(i >= 0 && i < m && j >= 0 && j < n){
            return true;
        }
        return false;
    }

}
