package com.vishal.dynamicprogramming;

public class MinCostPathInMatrix {

	public static void main(String[] args) {
		int[][] grid = {{348, 391},{618, 193}};
		System.out.println(minPathSum(grid));
	}

	public static int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dp[i][j] = -1;
            }
        }
        return minPathSum(grid, 0, 0, dp);
    }
    
    private static int minPathSum(int[][] grid, int i, int j, int[][] dp){
        if(!isValid(i, j, grid.length, grid[0].length)){
            return Integer.MAX_VALUE;
        }
        else if(dp[i][j] != -1){
            return dp[i][j];
        }
        else if(i == grid.length - 1 && j == grid[0].length - 1){
            return grid[i][j];
        }else{
            dp[i][j] = grid[i][j] + Math.min(
                minPathSum(grid, i + 1, j, dp),
                minPathSum(grid, i,j + 1, dp));
            return dp[i][j];
        }   
    }
                          
    private static boolean isValid(int i, int j, int m, int n){
        if(i >= 0 && i < m && j >= 0 && j < n){
            return true;
        }else{
            return false;
        }
    }

}
