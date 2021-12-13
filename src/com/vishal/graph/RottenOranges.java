package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

class RottenOranges {

    class Cell{
        int x;
        int y;
        public Cell(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return -1;
        }
        Queue<Cell> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.offer(new Cell(i, j));
                }
            }
        }

        int minutes = 0;
        int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean isRotten = false;
            for(int i = 0; i < size; i++) {
                Cell polled = queue.poll();
                for (int j = 0; j < dirs.length; j++) {
                    int[] currDir = dirs[j];
                    int nx = polled.x + currDir[0];
                    int ny = polled.y + currDir[1];
                    if (isValid(nx, ny, grid) && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2;
                        queue.offer(new Cell(nx, ny));
                        isRotten = true;
                    }
                }
            }
            if(isRotten){
                minutes++;
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return minutes;
    }

    private boolean isValid(int x, int y, int[][] grid){
        if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        RottenOranges rottenOranges = new RottenOranges();
        int minutess = rottenOranges.orangesRotting(grid);
        System.out.println(minutess);
    }
}
