package com.vishal.microsoft;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {

    static class Cell{
        int row;
        int col;
        int dist;
        public Cell(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int maxDistance(int[][] grid) {
        Queue<Cell> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    queue.offer(new Cell(i, j, 0));
                }else{
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()){
            Cell polled = queue.poll();
            for(int[] dir: dirs){
                int currRow = polled.row + dir[0];
                int currCol = polled.col + dir[1];
                if(!isValid(currRow, currCol, grid) || grid[currRow][currCol] == 1) {
                    continue;
                }
                if(grid[polled.row][polled.col] + 1 < grid[currRow][currCol]){
                    grid[currRow][currCol] = grid[polled.row][polled.col] + 1;
                    queue.offer(new Cell(currRow, currCol, grid[currRow][currCol]));
                }
            }
        }
        int res = -1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                res = Math.max(res, grid[i][j]);
            }
        }
        if(res == 1){
            return -1;
        }
        return res != Integer.MAX_VALUE ? res - 1: -1;
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        AsFarFromLandAsPossible asFarAs = new AsFarFromLandAsPossible();
        int res = asFarAs.maxDistance(grid);
        System.out.println(res);
    }

}
