package com.vishal.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class ShortestPathWithObstacles {

    static class Cell{
        int i;
        int j;
        int obstacles;
        public Cell(int i, int j, int obstacles){
            this.i = i;
            this.j = j;
            this.obstacles = obstacles;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(0, 0, 0));
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int steps = 0;
        boolean[][][] visited = new boolean[rows][cols][k + 1];
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Cell currCell = queue.poll();
                if(currCell.i == rows - 1 && currCell.j == cols - 1){
                    return steps;
                }
                for(int[] dir: dirs){
                    int newI = currCell.i + dir[0];
                    int newJ = currCell.j + dir[1];
                    if(isValid(newI, newJ, grid)){
                        //If obstacle
                        if(grid[newI][newJ] == 1 && currCell.obstacles < k &&
                                !visited[newI][newJ][currCell.obstacles + 1]){
                            queue.offer(new Cell(newI, newJ, currCell.obstacles + 1));
                            visited[newI][newJ][currCell.obstacles + 1] = true;
                        }else if(grid[newI][newJ] == 0
                                && !visited[newI][newJ][currCell.obstacles]){
                            queue.offer(new Cell(newI, newJ, currCell.obstacles));
                            visited[newI][newJ][currCell.obstacles] = true;
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
        int k = 1;
        ShortestPathWithObstacles path = new ShortestPathWithObstacles();
        int shortestPath = path.shortestPath(grid, k);
        System.out.println(shortestPath);
    }
}