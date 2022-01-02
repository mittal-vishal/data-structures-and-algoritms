package com.vishal.graph;

public class MaxAreaIsland {

    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    int area = dfs(i, j, grid, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int i, int j, int[][] grid, boolean[][] visited){
        if(!isValid(i, j, grid) || visited[i][j] || grid[i][j] == 0){
            return 0;
        }
        visited[i][j] = true;
        int up = dfs(i - 1, j, grid, visited);
        int bottom = dfs(i + 1, j, grid, visited);
        int left = dfs(i, j - 1, grid, visited);
        int right = dfs(i, j + 1, grid, visited);
        return (1 + up + bottom + left + right);
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }

}
