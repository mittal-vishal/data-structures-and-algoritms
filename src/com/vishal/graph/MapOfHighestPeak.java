package com.vishal.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {

    static class Pair{
        int row;
        int col;
        int height;
        public Pair(int row, int col, int height){
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }

    public int[][] highestPeak(int[][] isWater) {
        Queue<Pair> queue = new LinkedList<>();
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] heights = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(heights[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(isWater[i][j] == 1){
                    queue.offer(new Pair(i, j, 0));
                    heights[i][j] = 0;
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        while(!queue.isEmpty()){
            Pair polled = queue.poll();
            for(int[] dir: dirs){
                int currRow = polled.row + dir[0];
                int currCol = polled.col + dir[1];
                if(!isValid(currRow, currCol, isWater)){
                    continue;
                }
                if(heights[currRow][currCol] > heights[polled.row][polled.col] + 1){
                    heights[currRow][currCol] = heights[polled.row][polled.col] + 1;
                    queue.offer(new Pair(currRow, currCol, heights[currRow][currCol]));
                }
            }
        }
        return heights;
    }

    private boolean isValid(int i, int j, int[][] water){
        if(i >= 0 && i < water.length && j >= 0 && j < water[0].length){
            return true;
        }else{
            return false;
        }
    }

}
