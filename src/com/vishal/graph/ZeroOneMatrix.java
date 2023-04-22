package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    class Cell{
        int row;
        int col;
        int dist;
        Cell(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        Queue<Cell> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    queue.offer(new Cell(i,j,0));
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()){
            Cell polled = queue.poll();
            int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
            for(int[] dir: dirs){
                int newRow = polled.row + dir[0];
                int newCol = polled.col + dir[1];
                if(isValid(newRow, newCol, mat) && !visited[newRow][newCol] && mat[newRow][newCol] == 1){
                    visited[newRow][newCol] = true;
                    result[newRow][newCol] = result[polled.row][polled.col] + 1;
                    queue.offer(new Cell(newRow, newCol, result[newRow][newCol]));
                }
            }
        }
        return result;
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }

}
