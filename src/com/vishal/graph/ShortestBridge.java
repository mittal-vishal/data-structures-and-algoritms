package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    static class Cell{
        int i;
        int j;
        public Cell(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    private final int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public int shortestBridge(int[][] grid) {
        //perform dfs and mark first island as visited
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    dfs(i, j, grid, visited);
                    j = n;
                    i = m;
                }
            }
        }
        Queue<Cell> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]){
                    queue.offer(new Cell(i, j));
                }
            }
        }
        int dist = 0;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                Cell curr = queue.poll();
                for(int[] dir: dirs){
                    int newRow = curr.i + dir[0];
                    int newCol = curr.j + dir[1];
                    if(!isValid(newRow, newCol, grid) || visited[newRow][newCol]){
                        continue;
                    }
                    visited[newRow][newCol] = true;
                    if(grid[newRow][newCol] == 1){
                        return dist;
                    }else {
                        queue.offer(new Cell(newRow, newCol));
                    }
                }
            }
            dist++;
        }
        return dist-1;
    }

    private void dfs(int i, int j, int[][] grid, boolean[][] visited){
        if(!isValid(i, j, grid) || grid[i][j] == 0 || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        for(int[] dir: dirs){
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            dfs(newRow, newCol, grid, visited);
        }
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[i].length){
            return true;
        }else{
            return false;
        }
    }

}
