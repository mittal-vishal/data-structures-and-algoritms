package com.vishal.dynamicprogramming;

public class MaximalSquare {

    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        //fill first row
        for(int j = 0; j < col; j++){
            dp[0][j] = matrix[0][j];
        }
        //fill first col
        for(int i = 0; i < row; i++){
            dp[i][0] = matrix[i][0];
        }
        //fill remaining matrix
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][j] == 1){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        int result = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                result += dp[i][j];
            }
        }
        return result;
    }

}
