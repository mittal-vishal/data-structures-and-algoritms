package com.vishal.graph;

public class UniquePathIII {

    public int uniquePathsIII(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] startCell = null;
        int zeroCount = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    zeroCount++;
                }
                if(grid[i][j] == 1){
                    startCell = new int[]{i, j};
                }
            }
        }
        return dfs(grid, startCell[0], startCell[1], zeroCount);
    }

    private int dfs(int[][] grid, int i, int j, int zeroCount){
        if(!isValid(i, j, grid) || grid[i][j] == -1){
            return 0;
        }else if(grid[i][j] == 2){
            return zeroCount == -1 ? 1 : 0;
        }
        //mark as visited
        grid[i][j] = -1;
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        int result = 0;
        for(int[] dir: dirs){
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            result += dfs(grid, newRow, newCol, zeroCount-1);
        }
        //backtrack
        grid[i][j] = 0;
        return result;
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[i].length){
            return true;
        }else{
            return false;
        }
    }

}
