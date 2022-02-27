package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

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

    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0){
            return;
        }
        Queue<Cell> queue = new LinkedList<>();
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    queue.offer(new Cell(i, j, 0));
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()){
            Cell polledCell = queue.poll();
            for(int[] dir: dirs){
                int currRow = polledCell.row + dir[0];
                int currCol = polledCell.col + dir[1];
                if(!isValid(currRow, currCol, rooms) ||
                        rooms[currRow][currCol] == -1 || rooms[currRow][currCol] == 0){
                    continue;
                }
                if(rooms[polledCell.row][polledCell.col] + 1 < rooms[currRow][currCol]){
                    rooms[currRow][currCol] = rooms[polledCell.row][polledCell.col] + 1;
                    queue.offer(new Cell(currRow, currCol, rooms[currRow][currCol]));
                }
            }
        }
    }

    private boolean isValid(int i, int j, int[][] rooms){
        if(i >= 0 && i < rooms.length && j >= 0 && j < rooms[0].length){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] rooms = {{2147483647,-1,0,2147483647}, {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1}, {0,-1,2147483647,2147483647}};
        WallsAndGates wallsAndGates = new WallsAndGates();
        wallsAndGates.wallsAndGates(rooms);
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }

}