package com.vishal.graph;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int islands = 0;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(grid, i, j, visited);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int i, int j, boolean[][] visited){
        if(!isValid(i, j, grid)){
            return;
        }
        if(grid[i][j] == '1' && !visited[i][j]){
            visited[i][j] = true;
            dfs(grid, i-1, j, visited);
            dfs(grid, i+1, j, visited);
            dfs(grid, i, j-1, visited);
            dfs(grid, i, j+1, visited);
        }
    }

    private boolean isValid(int i, int j, char[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }

}
