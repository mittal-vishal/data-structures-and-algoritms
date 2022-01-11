package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class UniquePathII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        return uniquePaths(0, 0, obstacleGrid, dp);
    }

    private int uniquePaths(int i, int j, int[][] obstacleGrid, int[][] dp){
        if(!isValid(i, j, obstacleGrid) || obstacleGrid[i][j] == 1){
            return 0;
        }else if(dp[i][j] != -1){
            return dp[i][j];
        }else if(i == obstacleGrid.length-1 && j == obstacleGrid[0].length-1){
            return 1;
        }
        int right = uniquePaths(i, j + 1, obstacleGrid, dp);
        int down = uniquePaths(i + 1, j, obstacleGrid, dp);
        dp[i][j] = right + down;
        return dp[i][j];
    }

    private boolean isValid(int i, int j, int[][] obstacleGrid){
        if(i >= 0 && i < obstacleGrid.length && j >= 0 && j < obstacleGrid[0].length){
            return true;
        }
        return false;
    }

}
