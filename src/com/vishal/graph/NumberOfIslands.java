package com.vishal.graph;

public class NumberOfIslands {
	
	public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }else{
            int count = 0;
            for(int i =0; i< grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    if(grid[i][j] == '1'){
                        count++;
                        dfs(grid, i, j);
                    }
                }
            }
            return count;
        }
    }
    
    private void dfs(char[][] grid, int i, int j){
        if(isValid(i, j, grid.length, grid[0].length) && grid[i][j] == '1'){
            grid[i][j] = '0';
            dfs(grid, i, j-1);
            dfs(grid, i, j+1);
            dfs(grid, i-1, j);
            dfs(grid, i+1, j);
        }
    }
    
    private boolean isValid(int i, int j, int n, int m){
        if(i >= 0 && i < n && j >= 0 && j < m){
            return true;
        }else{
            return false;
        }
    }

}
