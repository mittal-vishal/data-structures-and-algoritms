package com.vishal.goldmansachs;

import java.util.Arrays;

public class BottomLeftToTopRight {
	public static void main(String[] args) {
		int[][] grid = {{1, 3},
						{2, 4}};
		System.out.println(minPathSum(grid));
	}
	
	public static int minPathSum(int[][] grid) {
        int memo[][] = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            Arrays.fill(memo[i], -1);
        }
        return minPathSum(grid, memo, grid.length - 1, 0, 0, grid[0].length - 1);
    }
    
    private static int minPathSum(int[][] grid, int[][] memo, int i, int j, int m, int n){
        if(!isValid(i, j, grid)){
            return Integer.MAX_VALUE;
        }else if(i == m && j == n){
            return grid[i][j];
        }else if(memo[i][j] != -1){
            return memo[i][j];
        }else{
            memo[i][j] =  grid[i][j] + Math.min(
                minPathSum(grid, memo, i - 1, j, m, n),
                minPathSum(grid, memo, i, j + 1, m, n)
            );
            return memo[i][j];
        }
    }
    
    private static boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i <= grid.length - 1 && j >= 0 && j <= grid[0].length - 1){
            return true;
        }else{
            return false;
        }
    }
}
