package com.vishal.google;

public class RotateImageBy90 {

    public void rotateMatrixByLayers(int[][] matrix){
        int n = matrix.length;
        int layers = n/2;
        for(int i = 0; i < layers; i++){
            int start = i;
            int end = n - i - 1;
            for(int j = start; j < end; j++){
                //Store Top
                int temp = matrix[start][j];
                //Left to Top
                matrix[start][j] = matrix[n-1-j][start];
                //Bottom to Left
                matrix[n-1-j][start] = matrix[end][n-1-j];
                //Right to Bottom
                matrix[end][n-1-j] = matrix[j][end];
                //Top to Right
                matrix[j][end] = temp;
            }
        }
    }

    public void rotate(int[][] matrix) {
        //Create transpose of matrix
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < (n/2); j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }

    }

}
