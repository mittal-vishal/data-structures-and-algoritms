package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

class ShortestPathWithObstacles {

    class Cell{
        int row;
        int col;
        int obstacles;
        public Cell(int row, int col, int obstacles){
            this.row = row;
            this.col = col;
            this.obstacles = obstacles;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][][] visited = new boolean[row][col][k+1];
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(0,0,0));
        visited[0][0][0] = true;
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        int steps = 0;
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                Cell polled = queue.poll();
                if(polled.obstacles > k){
                    continue;
                }else if(polled.row == row-1 && polled.col == col-1){
                    return steps;
                }
                for(int[] dir: dirs){
                    int newRow = polled.row+dir[0];
                    int newCol = polled.col+dir[1];
                    if(isValid(newRow, newCol, row, col) && !visited[newRow][newCol][polled.obstacles]){
                        visited[newRow][newCol][polled.obstacles] = true;
                        if(grid[newRow][newCol] == 1 && polled.obstacles <= k){
                            queue.offer(new Cell(newRow, newCol, polled.obstacles+1));
                        }else{
                            queue.offer(new Cell(newRow, newCol, polled.obstacles));
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private boolean isValid(int i, int j, int n, int m){
        if(i >= 0 && i < n && j >= 0 && j < m){
            return true;
        }
        return false;
    }
}