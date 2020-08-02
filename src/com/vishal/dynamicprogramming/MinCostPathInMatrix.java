package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class MinCostPathInMatrix {

	public static void main(String[] args) {
		int[][] grid = {{348, 391},{618, 193}};
		System.out.println(minPathSum(grid));
	}

	public static int minPathSum(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for(int i = 0; i < memo.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return minPathSum(grid, memo, 0, 0, grid.length - 1, grid[0].length - 1);
    }
    
    private static int minPathSum(int[][] grid, int[][] memo, int i, int j, int m, int n){
        if(!isValid(i, j, grid)){
            return Integer.MAX_VALUE;
        }else if(i == m && j == n){
            return grid[i][j];
        }else if(memo[i][j] != -1){
            return memo[i][j];
        }else{
            memo[i][j] = grid[i][j] + Math.min(
                minPathSum(grid, memo, i + 1, j, m, n),
                minPathSum(grid, memo, i, j + 1, m, n)
            );
            return memo[i][j];
        }
    }
    
    private static boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }else{
            return false;
        }
    }

}
