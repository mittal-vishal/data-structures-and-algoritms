package com.vishal.arrays;

public class RangeSumQuery2D {

    private int[][] matrix;

    public RangeSumQuery2D(int[][] matrix) {
        for(int i = 1; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] += matrix[i-1][j];
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 1; j < matrix[i].length; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }
        this.matrix = matrix;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int totalSum = matrix[row2][col2];
        int extra = ((row1 > 0) ? matrix[row1-1][col2]: 0) + ((col1 > 0) ? matrix[row2][col1-1]: 0) - ((row1 > 0 && col1 > 0)? matrix[row1-1][col1-1]: 0);
        return totalSum - extra;
    }

}
