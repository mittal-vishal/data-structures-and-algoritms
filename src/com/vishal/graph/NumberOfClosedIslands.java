package com.vishal.graph;

public class NumberOfClosedIslands {

    private boolean isClosed;
    public int closedIsland(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int closedIslands = 0;
        for(int i = 1; i < grid.length - 1; i++){
            for(int j = 1; j < grid[0]. length - 1; j++){
                if(grid[i][j] == 0){
                    this.isClosed = true;
                    dfs(grid, i, j);
                    if(this.isClosed){
                        closedIslands++;
                    }
                }
            }
        }
        return closedIslands;
    }

    private void dfs(int[][] grid, int i, int j){
        if(!isValid(i, j, grid) || grid[i][j] == 1){
            return;
        }
        if((i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) && grid[i][j] == 0){
            this.isClosed = false;
        }
        grid[i][j] = 1;
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        NumberOfClosedIslands closedIslands = new NumberOfClosedIslands();
        int islands = closedIslands.closedIsland(grid);
        System.out.println(islands);
    }

}
