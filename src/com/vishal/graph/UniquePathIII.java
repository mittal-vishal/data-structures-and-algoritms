package com.vishal.graph;

public class UniquePathIII {

    public int uniquePathsIII(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int si = -1;
        int sj = -1;
        int zeroCount = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    si = i;
                    sj = j;
                }else if(grid[i][j] == 0){
                    zeroCount++;
                }
            }
        }
        return dfs(si, sj, grid, zeroCount);
    }

    private int dfs(int i, int j, int[][] grid, int zeroCount){
        if(!isValid(i, j, grid) || grid[i][j] == -1){
            return 0;
        }
        if(grid[i][j] == 2){
            return zeroCount == -1 ? 1: 0;
        }
        //mark as visited
        grid[i][j] = -1;
        zeroCount--;
        int pathCount = dfs(i + 1, j, grid, zeroCount) +
                dfs(i - 1, j, grid, zeroCount) +
                dfs(i, j - 1, grid, zeroCount) +
                dfs(i, j + 1, grid, zeroCount);
        //backtrack
        grid[i][j] = 0;
        zeroCount++;
        return pathCount;
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }

}
