package com.vishal.graph;

import java.util.Deque;
import java.util.LinkedList;

public class MinCostToMakePathValid {
    static class Pair{
        int row;
        int col;
        int cost;
        public Pair(int row, int col, int cost){
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
    public int minCost(int[][] grid) {
        Deque<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, 0));
        int[][] dirs = {{}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while(!queue.isEmpty()){
            Pair polled = queue.removeFirst();
            if(polled.row == grid.length - 1 && polled.col == grid[0].length - 1){
                return polled.cost;
            }
            visited[polled.row][polled.col] = true;
            for(int i = 1; i <= 4; i++){
                int[] currDir = dirs[i];
                int currRow = polled.row + currDir[0];
                int currCol = polled.col + currDir[1];
                if(!isValid(currRow, currCol, grid) || visited[currRow][currCol]){
                    continue;
                }
                if(grid[polled.row][polled.col] == i){
                    queue.addFirst(new Pair(currRow, currCol, polled.cost));
                }else{
                    queue.addLast(new Pair(currRow, currCol, polled.cost + 1));
                }
            }
        }
        return -1;
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }else{
            return false;
        }
    }
}