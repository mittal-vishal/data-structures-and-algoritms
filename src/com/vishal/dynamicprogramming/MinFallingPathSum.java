package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class MinFallingPathSum {

    private int INT_MAX = 10000000;

    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++){
            Arrays.fill(dp[i], -1);
        }
        int result = INT_MAX;
        for(int j = 0; j < matrix[0].length; j++){
            int expectedMin = minPathSum(matrix, row-1, j, dp);
            result = Math.min(result, expectedMin);
        }
        return result;
    }

    private int minPathSum(int[][] matrix, int row, int col, int[][] dp){
        if(col < 0 || col >= matrix[0].length){
            return INT_MAX;
        }else if(row == 0){
            return matrix[row][col];
        }else if(dp[row][col] != -1){
            return dp[row][col];
        }else{
            int upper = matrix[row][col] + minPathSum(matrix, row-1, col, dp);
            int upperLeft = matrix[row][col] + minPathSum(matrix, row-1, col-1, dp);
            int upperRight = matrix[row][col] + minPathSum(matrix, row-1, col+1, dp);
            dp[row][col] = Math.min(upper, Math.min(upperLeft,upperRight));
            return dp[row][col];
        }
    }

    public int minFallingPathSumTabulation(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int j = 0; j < col; j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i = 1; i < row; i++){
            for(int j = 0; j < col; j++){
                int upper = matrix[i][j] + dp[i-1][j];
                int upperLeft = j > 0? matrix[i][j] + dp[i-1][j-1]: INT_MAX;
                int upperRight = j < col-1 ? matrix[i][j] + dp[i-1][j+1]: INT_MAX;
                dp[i][j] = Math.min(upper, Math.min(upperLeft,upperRight));
            }
        }
        int ans = INT_MAX;
        for(int j = 0; j < col; j++){
            ans = Math.min(ans, dp[row-1][j]);
        }
        return ans;
    }
}
