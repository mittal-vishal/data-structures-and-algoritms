package com.vishal.dynamicprogramming;

public class CollectMaxPointsInMatrix {

	public static void main(String[] args) {
		int[][] grid = {
				{1, 1, -1, 1, 1},
				{1, 0, 0, -1, 1},
				{1, 1, 1, 1, -1},
				{-1, -1, 1, 1, 1},
				{1, 1, -1, -1, 1}
		};
		System.out.println(getMaxPoints(grid));

	}
	
	private static int getMaxPoints(int[][] grid) {
		return getMaxPoints(grid, 0, 0);
	}
	
	private static int getMaxPoints(int[][] grid, int i, int j) {
		if(isValid(i, j, grid.length, grid[i].length) && grid[i][j] != -1) {
			if(i % 2 == 0) {
				return Math.max(grid[i][j] + getMaxPoints(grid, i+1, j), grid[i][j] + getMaxPoints(grid, i, j+1));
			}else {
				return Math.max(grid[i][j] + getMaxPoints(grid, i+1, j), grid[i][j] + getMaxPoints(grid, i, j-1));
			}
		}else {
			return 0;
		}
	}
	
	private static boolean isValid(int i, int j, int m, int n) {
		if(i >= 0 && i < m && j >= 0 && j < n) {
			return true;
		}else {
			return false;
		}
	}

}
