package com.vishal.graph;

import java.util.Deque;
import java.util.LinkedList;

public class MinCostToMakePathValid {

    class Cell{
        int row;
        int col;
        int cost;
        Cell(int row, int col, int cost){
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }
    public int minCost(int[][] grid) {
        Deque<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(0,0,0));
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        while(!queue.isEmpty()){
            Cell currCell = queue.poll();
            if(currCell.row == row - 1 && currCell.col == col - 1){
                return currCell.cost;
            }else if(visited[currCell.row][currCell.col]){
                continue;
            }
            visited[currCell.row][currCell.col] = true;
            for(int i = 0; i < dirs.length; i++){
                int[] dir = dirs[i];
                int nextRow = currCell.row + dir[0];
                int nextCol = currCell.col + dir[1];
                if(isValid(nextRow, nextCol, grid)){
                    if(i == grid[currCell.row][currCell.col]-1){
                        queue.addFirst(new Cell(nextRow, nextCol, currCell.cost));
                    }else{
                        queue.addLast(new Cell(nextRow, nextCol, currCell.cost+1));
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }
}