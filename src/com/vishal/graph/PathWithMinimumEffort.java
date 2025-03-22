package com.vishal.graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {

    static class Cell{
        int row;
        int col;
        int effort;
        public Cell(int row, int col, int effort){
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }

    public int minimumEffortPath(int[][] heights) {
        int[][] efforts = new int[heights.length][heights[0].length];
        Queue<Cell> queue = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        queue.offer(new Cell(0,0,0));
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int i = 0; i < heights.length; i++){
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;
        while(!queue.isEmpty()){
            Cell currCell = queue.poll();
            for(int[] dir: dirs){
                int newRow = currCell.row + dir[0];
                int newCol = currCell.col + dir[1];
                if(isValid(newRow, newCol, heights)){
                    int currEffort = Math.max(efforts[currCell.row][currCell.col],
                            Math.abs(heights[newRow][newCol]-heights[currCell.row][currCell.col]));
                    if(currEffort < efforts[newRow][newCol]){
                        efforts[newRow][newCol] = currEffort;
                        queue.offer(new Cell(newRow, newCol, currEffort));
                    }
                }
            }
        }
        return efforts[heights.length-1][heights[0].length-1];
    }

    private boolean isValid(int i, int j, int[][] heights){
        if(i >= 0 && i < heights.length && j >= 0 && j < heights[i].length){
            return true;
        }else{
            return false;
        }
    }

}
