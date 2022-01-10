package com.vishal.dynamicprogramming;

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int maxSize = 0;
        //update square size for last row
        for(int j = 0; j < cols; j++){
            if(matrix[rows - 1][j] == '1'){
                dp[rows-1][j] = 1;
                maxSize = 1;
            }
        }
        //update for last column
        for(int i = 0; i < rows; i++){
            if(matrix[i][cols - 1] == '1'){
                dp[i][cols-1] = 1;
                maxSize = 1;
            }
        }
        //update for remaining matrix in bottom up fashion
        for(int i = rows - 2; i >= 0; i--){
            for(int j = cols - 2; j >= 0; j--){
                if(matrix[i][j] == '1'){
                    dp[i][j] = 1 + (Math.min(dp[i+1][j+1], Math.min(dp[i][j+1], dp[i+1][j])));
                    maxSize = Math.max(maxSize, dp[i][j]);
                }
            }
        }
        return maxSize*maxSize;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        MaximalSquare square = new MaximalSquare();
        int squareArea = square.maximalSquare(matrix);
        System.out.println(squareArea);
    }

}
