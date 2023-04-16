package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class MinCostPathInMatrix {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++){
            Arrays.fill(dp[i], -1);
        }
        return minPathSum(grid, row-1, col-1, dp);
    }

    private int minPathSum(int[][] grid, int row, int col, int[][] dp){
        if(row == 0 && col == 0){
            return grid[row][col];
        }else if(row < 0 || col < 0){
            return Integer.MAX_VALUE;
        }else if(dp[row][col] != -1){
            return dp[row][col];
        }else{
            int up = minPathSum(grid, row-1, col, dp);
            int left = minPathSum(grid, row, col-1, dp);
            dp[row][col] = grid[row][col] + Math.min(up,left);
            return dp[row][col];
        }
    }

    public int minPathSumTabulation(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for(int j = 1; j < col; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i = 1; i < row; i++){
            dp[i][0] = dp[i-1][0] +grid[i][0];
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                int up = dp[i-1][j];
                int left = dp[i][j-1];
                dp[i][j] = grid[i][j] + Math.min(up,left);
            }
        }
        return dp[row-1][col-1];
    }

}
