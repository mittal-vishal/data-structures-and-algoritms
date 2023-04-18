package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    class Cell{
        int row;
        int col;
        int dist;
        public Cell(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1){
            return -1;
        }
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(0,0,1));
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        visited[0][0] = true;
        while(!queue.isEmpty()){
            Cell polled = queue.poll();
            if(polled.row == row-1 && polled.col == col-1){
                return polled.dist;
            }
            int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{-1,1},{1,1},{-1,-1},{1,-1}};
            for(int i = 0; i < dirs.length; i++){
                int newRow = polled.row + dirs[i][0];
                int newCol = polled.col + dirs[i][1];
                if(isValid(newRow, newCol, grid) && !visited[newRow][newCol] && grid[newRow][newCol] == 0){
                    visited[newRow][newCol] = true;
                    queue.offer(new Cell(newRow, newCol, polled.dist + 1));
                }
            }
        }
        return -1;
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }

}
