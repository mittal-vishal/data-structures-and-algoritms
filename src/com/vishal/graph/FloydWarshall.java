package com.vishal.graph;

public class FloydWarshall {

    private int INT_MAX = (int)1e8;
    public void shortest_distance(int[][] matrix)
    {
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = INT_MAX;
                }else if(i == j){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int k = 0; k < row; k++){
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(matrix[i][j] > (matrix[i][k] + matrix[k][j])){
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }
                }
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == INT_MAX){
                    matrix[i][j] = -1;
                }
            }
        }
    }

}
