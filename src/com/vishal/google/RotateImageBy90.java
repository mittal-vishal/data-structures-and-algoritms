package com.vishal.google;

public class RotateImageBy90 {

    public void rotateByLayers(int[][] matrix) {

        int n = matrix.length;

        for(int layer = 0; layer < n/2; layer++){

            for(int j = layer; j < n-layer-1; j++){
                //Save top right
                int temp = matrix[j][n-1-layer];
                //Top left to top right
                matrix[j][n-1-layer] = matrix[layer][j];
                //Bottom left to top left
                matrix[layer][j] = matrix[n-1-j][layer];
                //Bottom right to bottom left
                matrix[n-1-j][layer] = matrix[n-1-layer][n-1-j];
                //Top right to bottom right
                matrix[n-1-layer][n-1-j] = temp;
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
