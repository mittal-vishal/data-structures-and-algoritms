package com.vishal.graph;

public class NumberOfEnclaves {

    public int numEnclaves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        //first row
        for(int j = 0; j < col; j++){
            if(!visited[0][j] && grid[0][j] == 1){
                dfs(grid, 0, j, visited);
            }
        }
        //left col
        for(int i = 0; i < row; i++){
            if(!visited[i][0] && grid[i][0] == 1){
                dfs(grid, i, 0, visited);
            }
        }
        //last row
        for(int j = 0; j < col; j++){
            if(!visited[row-1][j] && grid[row-1][j] == 1){
                dfs(grid, row-1, j, visited);
            }
        }
        //right col
        //left col
        for(int i = 0; i < row; i++){
            if(!visited[i][col-1] && grid[i][col-1] == 1){
                dfs(grid, i, col-1, visited);
            }
        }
        int result = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited){
        visited[i][j] = true;
        int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
        for(int k = 0; k < dirs.length; k++){
            int newRow = i+dirs[k][0];
            int newCol = j+dirs[k][1];
            if(isValid(grid, newRow, newCol) && !visited[newRow][newCol] && grid[newRow][newCol] == 1){
                dfs(grid, newRow, newCol, visited);
            }
        }
    }

    private boolean isValid(int[][]grid, int i, int j){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }

}
