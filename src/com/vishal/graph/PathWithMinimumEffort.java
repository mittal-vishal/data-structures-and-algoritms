package com.vishal.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {

    private int INT_MAX = (int)1e8;

    class Cell{
        int row;
        int col;
        int diff;
        public Cell(int row, int col, int diff){
            this.row = row;
            this.col = col;
            this.diff = diff;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int[][] dist = new int[row][col];
        for(int i = 0; i < row; i++){
            Arrays.fill(dist[i], INT_MAX);
        }
        dist[0][0] = 0;
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.diff-b.diff);
        pq.offer(new Cell(0,0,0));
        while(!pq.isEmpty()){
            Cell polled = pq.poll();
            if(polled.row == row-1 && polled.col == col-1){
                return polled.diff;
            }
            int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
            for(int i = 0; i < dirs.length; i++){
                int newRow = polled.row + dirs[i][0];
                int newCol = polled.col + dirs[i][1];
                if(isValid(newRow, newCol, heights)){
                    int newDiff = Math.abs(heights[newRow][newCol]-heights[polled.row][polled.col]);
                    int pathMaxDiff = Math.max(newDiff, polled.diff);
                    if(dist[newRow][newCol] > pathMaxDiff){
                        dist[newRow][newCol] = pathMaxDiff;
                        pq.offer(new Cell(newRow, newCol, pathMaxDiff));
                    }
                }
            }
        }
        return 0;
    }

    private boolean isValid(int i, int j, int[][] heights){
        if(i >= 0 && i < heights.length && j >= 0 && j < heights[0].length){
            return true;
        }
        return false;
    }

}
