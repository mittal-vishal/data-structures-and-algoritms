package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class MinFallingPathSum {

    public int minFallingPathSum(int[][] matrix) {
        int result = Integer.MAX_VALUE;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int j = 0; j < col; j++){
            int expectedResult = getMinPathSum(0, j, matrix, dp);
            result = Math.min(result, expectedResult);
        }
        return result;
    }

    private int getMinPathSum(int row, int col, int[][] matrix, int[][] dp){
        if(row == matrix.length-1){
            return matrix[row][col];
        }else if(dp[row][col] != -1){
            return dp[row][col];
        }
        int[] colDir = {-1, 0, 1};
        int minSum = Integer.MAX_VALUE;
        for(int j: colDir){
            int newCol = col+j;
            if(newCol < 0 || newCol >= matrix[0].length){
                continue;
            }
            int currPathSum = matrix[row][col] + getMinPathSum(row+1, newCol, matrix, dp);
            minSum = Math.min(minSum, currPathSum);
        }
        return dp[row][col] = minSum;
    }
}
