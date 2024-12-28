package com.vishal.backtracking;

public class RatMazeWithMultipleJumps {

    public int[][] ShortestDistance(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix[0][0] == 0){
            return new int[][]{{-1}};
        }
        int n = matrix.length;
        int[][] result = new int[n][n];
        if(backtrack(0, 0, matrix, result)){
            return result;
        }
        return new int[][]{{-1}};
    }

    private boolean backtrack(int i, int j, int[][] matrix, int[][] result){
        if(!isValid(i, j, matrix.length)){
            return false;
        }
        result[i][j] = 1;
        if(i == matrix.length-1 && j == matrix.length-1){
            return true;
        }
        int jumps = matrix[i][j];
        for(int k = 1; k <= jumps; k++){
            if(backtrack(i, j+k, matrix, result)){
                return true;
            }
            if(backtrack(i+k, j, matrix, result)){
                return true;
            }
        }
        result[i][j] = 0;
        return false;
    }

    private boolean isValid(int i, int j, int n){
        if(i >= 0 && i < n && j >= 0 && j < n){
            return true;
        }
        return false;
    }

}
