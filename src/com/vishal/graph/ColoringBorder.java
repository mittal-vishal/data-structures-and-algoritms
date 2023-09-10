package com.vishal.graph;

public class ColoringBorder {

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[row][col] == color){
            return grid;
        }
        boolean[][] visited = new boolean[m][n];
        dfs(grid, row, col, grid[row][col], color, visited);
        return grid;
    }

    private void dfs(int[][] grid, int i, int j, int currColor, int targetColor, boolean[][] visited){
        if(!isValid(i, j, grid) || grid[i][j] != currColor || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        boolean isBorder = false;
        //border condition
        if(i == 0 || j == 0 || i == grid.length-1 || j == grid[0].length-1 || grid[i-1][j] != currColor ||
                grid[i+1][j] != currColor || grid[i][j-1] != currColor || grid[i][j+1] != currColor){
            isBorder = true;
        }
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int[] dir: dirs){
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            dfs(grid, newRow, newCol, currColor, targetColor, visited);
        }
        if(isBorder){
            grid[i][j] = targetColor;
        }
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }

}
