package com.vishal.matrix;

public class LongestLineOfConsecutiveOne {

    public int longestLine(int[][] mat) {
        int result = 0;
        int row = mat.length;
        int col = mat[0].length;
        //row wise
        for(int i = 0; i < row; i++){
            int count = 0;
            for(int j = 0; j < col; j++){
                if(mat[i][j] == 1){
                    count++;
                    result = Math.max(result, count);
                }else{
                    count = 0;
                }
            }
        }
        //col wise
        for(int j = 0; j < col; j++){
            int count = 0;
            for(int i = 0; i < row; i++){
                if(mat[i][j] == 1){
                    count++;
                    result = Math.max(result, count);
                }else{
                    count = 0;
                }
            }
        }
        //upper diagonal wise
        for(int j = 0; j < col || j < row; j++){
            int count = 0;
            for(int x = 0, y = j; x < row && y < col; x++,y++){
                if(mat[x][y] == 1){
                    count++;
                    result = Math.max(result, count);
                }else{
                    count = 0;
                }
            }
        }
        // lower diagonal
        for(int j = 0; j < col || j < row; j++){
            int count = 0;
            for(int x = j, y = 0; x < row && y < col; x++,y++){
                if(mat[x][y] == 1){
                    count++;
                    result = Math.max(result, count);
                }else{
                    count = 0;
                }
            }
        }
        //upper anti-diagonal wise
        for(int j = 0; j < col || j < row; j++){
            int count = 0;
            for(int x = 0, y = col-j-1; x < row && y >= 0 && x < row; x++,y--){
                if(mat[x][y] == 1){
                    count++;
                    result = Math.max(result, count);
                }else{
                    count = 0;
                }
            }
        }
        // lower anti-diagonal
        for(int j = 0; j < col || j < row; j++){
            int count = 0;
            for(int x = j, y = col-1; x < row && y >= 0; x++,y--){
                if(mat[x][y] == 1){
                    count++;
                    result = Math.max(result, count);
                }else{
                    count = 0;
                }
            }
        }
        return result;
    }

}
