package com.vishal.graph;

public class LongestIncreasingPathInMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        int result = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        //base case
        if(matrix.length == 1 && matrix[0].length == 1){
            return 1;
        }
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int length = dfs(matrix, i, j, dp);
                result = Math.max(result, length);
            }
        }
        return result;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp){
        int max = 1;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        if(dp[i][j] > 0){
            return dp[i][j];
        }
        for(int[] dir: dirs){
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if(isValid(newRow, newCol, matrix) && matrix[newRow][newCol] > matrix[i][j]){
                max = Math.max(max,1 + dfs(matrix, newRow, newCol, dp));
            }
        }
        return dp[i][j] = max;
    }

    private boolean isValid(int i, int j, int[][] matrix){
        if(i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length){
            return true;
        }
        return false;
    }

}
