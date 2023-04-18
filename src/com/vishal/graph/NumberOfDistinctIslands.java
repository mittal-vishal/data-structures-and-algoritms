package com.vishal.graph;

import java.util.*;

public class NumberOfDistinctIslands {

    public int numDistinctIslands(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        List<Map.Entry<Integer,Integer>> pairs = new ArrayList<>();
        HashSet<List<Map.Entry<Integer, Integer>>> set = new HashSet<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    dfs(grid, i, j, visited, pairs, i, j);
                    set.add(pairs);
                    pairs = new ArrayList<>();
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, boolean[][]visited, List<Map.Entry<Integer,Integer>> pairs, int baseRow, int baseCol){
        visited[i][j] = true;
        pairs.add(new AbstractMap.SimpleEntry<Integer,Integer>(i-baseRow, j-baseCol));
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] dir: dirs){
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if(isValid(grid, newRow, newCol) && grid[newRow][newCol] == 1 && !visited[newRow][newCol]){
                dfs(grid, newRow, newCol, visited, pairs, baseRow, baseCol);
            }
        }
    }

    private boolean isValid(int[][] grid, int i, int j){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }

}
