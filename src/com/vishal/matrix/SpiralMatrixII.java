package com.vishal.matrix;

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] spiral = new int[n][n];
        int num = 1;
        for(int layer = 0; layer <= n/2; layer++){
            //Top Left to Right
            for(int j = layer; j <= n-1-layer; j++){
                spiral[layer][j] = num++;
            }
            //Rightmost Top to Bottom
            for(int i = layer+1; i <= n-1-layer; i++){
                spiral[i][n-1-layer] = num++;
            }
            //Bottom Right to Left
            for(int j = n-1-layer-1; j >= layer; j--){
                spiral[n-1-layer][j] = num++;
            }
            //Leftmost Bottom to Up
            for(int i = n-1-layer-1; i > layer; i--){
                spiral[i][layer] = num++;
            }
        }
        return spiral;
    }

}
