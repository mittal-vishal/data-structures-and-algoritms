package com.vishal.dynamicprogramming;

public class CountSquaresWithAllOne {

    public int countSquares(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int count = 0;
        //update square count for last row
        for(int j = 0; j < cols; j++){
            if(matrix[rows - 1][j] == 1){
                dp[rows-1][j] = 1;
                count++;
            }
        }
        //update square count for last column
        for(int i = 0; i < rows; i++){
            if(matrix[i][cols - 1] == 1 && i != matrix.length - 1){
                dp[i][cols-1] = 1;
                count++;
            }
        }
        //update square count for remaining matrix in bottom up fashion
        for(int i = rows - 2; i >= 0; i--){
            for(int j = cols - 2; j >= 0; j--){
                if(matrix[i][j] == 1){
                    dp[i][j] = 1 + (Math.min(dp[i+1][j+1], Math.min(dp[i][j+1], dp[i+1][j])));
                    count += dp[i][j];
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,1,1}, {1,1,1,1}, {0,1,1,1}};
        CountSquaresWithAllOne square = new CountSquaresWithAllOne();
        int squareArea = square.countSquares(matrix);
        System.out.println(squareArea);
    }

}
