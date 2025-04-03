package com.vishal.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinObstaclesToReachCorner {

    static class Cell{
        int row;
        int col;
        int cost;
        public Cell(int row, int col, int cost){
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
    public int minimumObstacles(int[][] grid) {
        Deque<Cell> queue = new ArrayDeque<>();
        Cell source = grid[0][0] == 0 ? new Cell(0,0,0) : new Cell(0,0,1);
        queue.offer(source);
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            Cell curr = queue.poll();
            if(curr.row == m-1 && curr.col == n-1){
                return curr.cost;
            }else if(visited[curr.row][curr.col]){
                continue;
            }
            visited[curr.row][curr.col] = true;
            for(int[] dir: dirs){
                int newRow = curr.row + dir[0];
                int newCol = curr.col + dir[1];
                if(isValid(newRow, newCol, grid)){
                    if(grid[curr.row][curr.col] == 0){
                        queue.addFirst(new Cell(newRow, newCol, curr.cost));
                    }else{
                        queue.addLast(new Cell(newRow, newCol, curr.cost+1));
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[i].length){
            return true;
        }else{
            return false;
        }
    }

}
