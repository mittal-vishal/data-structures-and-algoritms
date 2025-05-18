package com.vishal.amazon;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    return dfs(i, j, grid, visited);
                }
            }
        }
        return -1;
    }

    private int dfs(int i, int j, int[][] grid, boolean[][] visited){
        if(!isValid(i, j, grid) || grid[i][j] == 0){
            return 1;
        }else if(visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        int perimeter = 0;
        perimeter += dfs(i-1, j, grid, visited);
        perimeter += dfs(i, j+1, grid, visited);
        perimeter += dfs(i+1, j, grid, visited);
        perimeter += dfs(i, j-1, grid, visited);
        return perimeter;
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }else{
            return false;
        }
    }

}
