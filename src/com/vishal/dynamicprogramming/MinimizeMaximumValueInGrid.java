package com.vishal.dynamicprogramming;

public class MinimizeMaximumValueInGrid {

    public static void main(String[] args) {
        int[] a = {-5,-1,-3};
        int[] b = {-5,5,-2};
        MinimizeMaximumValueInGrid t = new MinimizeMaximumValueInGrid();
        System.out.println(t.solution(a, b));
    }

    private int result;
    public int solution(int[] A, int[] B) {
        int n = A.length;
        result = Integer.MAX_VALUE;
        int[][] grid = new int[2][n];
        prepareGrid(A, B, grid);
        minimize(0, 0, grid, Integer.MIN_VALUE);
        return result;
    }

    private void prepareGrid(int[] A, int[] B, int[][] grid){
        for(int i = 0; i < A.length; i++){
            grid[0][i] = A[i];
        }
        for(int i = 0; i < B.length; i++){
            grid[1][i] = B[i];
        }
    }

    private int minimize(int i, int j, int[][] grid, int currMax){
        if(!isValid(i, j, grid)){
            return Integer.MIN_VALUE;
        }else if(i == grid.length-1 && j == grid[0].length-1){
            result = Math.min(result, currMax);
            return grid[i][j];
        }
        currMax = Math.max(currMax, grid[i][j]);
        int right = minimize(i, j+1, grid, currMax);
        int bottom = minimize(i+1, j, grid, currMax);
        return Math.max(right, bottom);
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }

}
