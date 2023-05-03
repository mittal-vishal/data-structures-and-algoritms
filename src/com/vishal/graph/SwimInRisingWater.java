package com.vishal.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SwimInRisingWater {

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

    public int swimInWater(int[][] grid) {
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.dist-b.dist);
        pq.offer(new Cell(0,0,grid[0][0]));
        int n = grid.length;
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!pq.isEmpty()){
            Cell curr = pq.poll();
            for(int[] dir: dirs){
                int newRow = curr.row + dir[0];
                int newCol = curr.col + dir[1];
                if(isValid(newRow, newCol, grid) && dist[newRow][newCol] > Math.max(grid[newRow][newCol], dist[curr.row][curr.col])){
                    dist[newRow][newCol] = Math.max(grid[newRow][newCol], dist[curr.row][curr.col]);
                    pq.offer(new Cell(newRow, newCol, dist[newRow][newCol]));
                }
            }
        }
        return dist[n-1][n-1];
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }

}
