package com.vishal.prefix;

import java.util.Arrays;

public class MinOperationToMakeUniValue {

    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        //base case and flatten if valid
        int[] flattenGrid = new int[m*n];
        int index = 0;
        int totalSum = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int element = grid[i][j];
                if(element % x != grid[0][0] % x){
                    return -1;
                }else{
                    flattenGrid[index++] = grid[i][j];
                    totalSum += grid[i][j];
                }
            }
        }
        Arrays.sort(flattenGrid);
        int prefix = 0;
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < flattenGrid.length; i++){
            int operation = 0;
            int num = flattenGrid[i];
            int diff = (flattenGrid[i]*i) - prefix;
            operation += diff/x;
            int rightPrefix = (totalSum - prefix) - ((flattenGrid.length-i)*flattenGrid[i]);
            operation += rightPrefix/x;
            result = Math.min(result, operation);
            prefix += flattenGrid[i];
        }
        return result;
    }

}
