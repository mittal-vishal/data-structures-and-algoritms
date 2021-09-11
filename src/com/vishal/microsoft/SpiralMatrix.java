package com.vishal.microsoft;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralOrderList = new ArrayList<>();

        int rows = matrix.length;
        int cols = matrix[0].length;
        int top = 0;
        int left = 0;
        int right = cols - 1;
        int bottom = rows - 1;

        while(spiralOrderList.size() < rows*cols){
            for(int col = left; col <= right; col++){
                spiralOrderList.add(matrix[top][col]);
            }
            for(int row = top + 1; row <= bottom; row++){
                spiralOrderList.add(matrix[row][right]);
            }
            if(bottom != top){
                for(int col = right - 1; col >= left; col--){
                    spiralOrderList.add(matrix[bottom][col]);
                }
            }
            if(left != right){
                for(int row = bottom - 1; row > top; row--){
                    spiralOrderList.add(matrix[row][left]);
                }
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return spiralOrderList;
    }

}
