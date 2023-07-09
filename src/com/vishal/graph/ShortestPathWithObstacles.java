package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

class ShortestPathWithObstacles {

    static class Cell{
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
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(0,0,0));
        int row = grid.length;
        int col = grid[0].length;
        boolean[][][] visited = new boolean[row][col][k+1];
        visited[0][0][0] = true;
        int[][] dirs = {{1,0}, {-1,0}, {0,-1}, {0,1}};
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Cell currCell = queue.poll();
                if(currCell.obstacles > k){
                    continue;
                }
                if(currCell.row == row - 1 && currCell.col == col-1){
                    return steps;
                }
                for(int[] dir: dirs){
                    int newRow = currCell.row + dir[0];
                    int newCol = currCell.col + dir[1];
                    if(isValid(newRow, newCol, grid)){
                        if(grid[newRow][newCol] == 0 && !visited[newRow][newCol][currCell.obstacles]){
                            visited[newRow][newCol][currCell.obstacles] = true;
                            queue.offer(new Cell(newRow, newCol, currCell.obstacles));
                        }else if(currCell.obstacles < k && !visited[newRow][newCol][currCell.obstacles + 1]){
                            visited[newRow][newCol][currCell.obstacles + 1] = true;
                            queue.offer(new Cell(newRow, newCol, currCell.obstacles + 1));
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private boolean isValid(int row, int col, int[][] grid){
        if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length){
            return true;
        }
        return false;
    }
}