package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

class RottenOranges {

    class Cell{
        int i;
        int j;
        public Cell(int i, int j){
            this.i = i;
            this.j = i;
        }
    }

    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        Queue<Cell> rootenQueue = new LinkedList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    rootenQueue.offer(new Cell(i, j));
                }
            }
        }

        int mints = 0;
        int[][] cordinates = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        while(!rootenQueue.isEmpty()){
            int queueSize = rootenQueue.size();
            boolean isRotten = false;
            for(int i = 0; i < queueSize; i++){
                Cell polledCell = rootenQueue.poll();
                for(int j = 0; j < cordinates.length; j++){
                    int[] currCordinate = cordinates[j];
                    int newI = polledCell.i + currCordinate[0];
                    int newJ = polledCell.j + currCordinate[1];
                    if(isValid(newI, newJ, grid) && !visited[newI][newJ] && grid[newI][newJ] == 1){
                        isRotten = true;
                        visited[newI][newJ] = true;
                        rootenQueue.offer(new Cell(newI, newJ));
                    }
                }
            }
            if(isRotten){
                mints++;
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    return -1;
                }
            }
        }
        return mints;
    }

    private boolean isValid(int i , int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
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
