package com.vishal.dynamicprogramming;

import java.util.Arrays;
import java.util.List;

public class MinPathSumTriangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[][] dp = new int[row][row];
        for(int i = 0; i < row; i++){
            Arrays.fill(dp[i], -1);
        }
        return maxSum(triangle, 0, 0, dp);
    }

    private int maxSum(List<List<Integer>> triangle, int row, int col, int[][] dp){
        if(row == triangle.size()){
            return 0;
        }else if(dp[row][col] != -1){
            return dp[row][col];
        }
        int maxSumLeft = maxSum(triangle, row+1, col, dp);
        int maxSumRight = maxSum(triangle, row+1, col+1, dp);
        return dp[row][col] = triangle.get(row).get(col) + Math.min(maxSumLeft, maxSumRight);
    }

}
