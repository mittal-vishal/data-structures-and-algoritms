package com.vishal.arrays;

import java.util.Arrays;

public class GenerateMatrixWithAverageOfRowAsInteger {

    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] matrix = generateMatrix(m, n);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] generateMatrix(int m, int n) {
        int[][] result = new int[m][n];
        if(m % 2 == 1){
            for(int i = 0; i < m; i++){
                Arrays.fill(result[i], -1);
            }
            return result;
        }
        if(n == 1){
            for(int i = 0; i < m; i++){
                result[i][n-1] = i+1;
            }
        }
        for(int i = 0; i < m; i++){
            int num = i;
            for(int j = 0; j < n; j++){
                result[i][j] = num+1;
                num += m;
            }
        }
        return result;
    }

}
