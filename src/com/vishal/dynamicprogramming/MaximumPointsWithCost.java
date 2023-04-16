package com.vishal.dynamicprogramming;

public class MaximumPointsWithCost {

    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] memo = new long[n];
        for(int j = 0; j < n; j++){
            memo[j] = points[0][j];
        }

        for(int i = 1; i < m; i++){
            long[] left = new long[n];
            left[0] = memo[0];
            for(int j = 1; j < n; j++){
                left[j] = Math.max(left[j-1] - 1, memo[j]);
            }
            long[] right = new long[n];
            right[n-1] = memo[n-1];
            for(int j = n-2; j >= 0; j--){
                right[j] = Math.max(right[j+1] - 1, memo[j]);
            }
            for(int j = 0; j < n; j++){
                memo[j] = Math.max(left[j], right[j]) + points[i][j];
            }
        }
        long result = 0;
        for(long num: memo){
            result = Math.max(result, num);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{1,2,3},
                          {1,5,1},
                          {3,1,1}};
        MaximumPointsWithCost maximumPointsWithCost = new MaximumPointsWithCost();
        System.out.println(maximumPointsWithCost.maxPoints(points));
    }

}
