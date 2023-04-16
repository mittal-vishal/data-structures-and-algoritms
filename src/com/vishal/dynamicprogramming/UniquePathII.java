package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class UniquePathII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][]dp = new int[row][col];
        for(int i = 0; i < row; i++){
            Arrays.fill(dp[i], -1);
        }
        return uniquePath(obstacleGrid, row-1, col-1, dp);
    }

    private int uniquePath(int[][] grid, int row, int col, int[][] dp){
        if(row < 0 || col < 0 || grid[row][col] == 1){
            return 0;
        }else if(row == 0 && col == 0){
            return 1;
        }else if(dp[row][col] != -1){
            return dp[row][col];
        }else{
            int up = uniquePath(grid, row-1, col, dp);
            int left = uniquePath(grid, row, col-1, dp);
            dp[row][col] = up+left;
            return dp[row][col];
        }
    }

    public int uniquePathsWithObstaclesTabulation(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][]dp = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = obstacleGrid[i][j] == 1? 0: 1;
                }else if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    int up = i > 0 ? dp[i-1][j]: 0;
                    int left = j > 0 ? dp[i][j-1]: 0;
                    dp[i][j] = up+left;
                }
            }
        }
        return dp[row-1][col-1];
    }

    public int uniquePathsWithObstaclesSpaceOptimised(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[] prev = new int[col];
        for(int i = 0; i < row; i++){
            int[] curr = new int[col];
            for(int j = 0; j < col; j++){
                if(i == 0 && j == 0){
                    curr[j] = obstacleGrid[i][j] == 1? 0: 1;
                }else if(obstacleGrid[i][j] == 1){
                    curr[j] = 0;
                }else{
                    int up = i > 0 ? prev[j]: 0;
                    int left = j > 0 ? curr[j-1]: 0;
                    curr[j] = up+left;
                }
            }
            prev = curr;
        }
        return prev[col-1];
    }

}
