package com.vishal.graph;

public class GetMaxGold {

    public int getMaximumGold(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxGold = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] != 0){
                    int gold = dfs(i, j, grid, visited);
                    maxGold = Math.max(maxGold, gold);
                }
            }
        }
        return maxGold;
    }

    private int dfs(int i, int j, int[][] grid, boolean[][] visited){
        if(!isValid(i, j, grid) || grid[i][j] == 0 || visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        int top = dfs(i-1, j, grid, visited);
        int bottom = dfs(i+1, j, grid, visited);
        int left = dfs(i, j-1, grid, visited);
        int right = dfs(i, j+1, grid, visited);
        visited[i][j] = false;
        return grid[i][j] + Math.max(top, Math.max(bottom, Math.max(left, right)));
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }

}
