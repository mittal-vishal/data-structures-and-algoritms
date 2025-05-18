package com.vishal.arrays;

public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {
        if(mat.length == 0){
            return new int[0];
        }
        int m = mat.length;
        int n = mat[0].length;
        int r = 0;
        int c = 0;
        int[] res = new int[m*n];
        for(int i = 0; i < res.length; i++){
            res[i] = mat[r][c];
            //Up
            if((r+c) % 2 == 0){
                if(c == n-1){
                    r++;
                }else if(r == 0){
                    c++;
                }else{
                    r--;
                    c++;
                }
            }
            //Down
            else{
                if(r == m-1){
                    c++;
                }else if(c == 0){
                    r++;
                }else{
                    r++;
                    c--;
                }
            }
        }
        return res;
    }

}
