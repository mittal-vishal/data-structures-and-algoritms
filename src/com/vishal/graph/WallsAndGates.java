package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

    static class Cell{
        int i;
        int j;
        public Cell(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public void wallsAndGates(int[][] rooms) {
        Queue<Cell> queue = new LinkedList<>();
        int m = rooms.length;
        int n = rooms[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0){
                    queue.offer(new Cell(i,j));
                }
            }
        }
        int dist = 1;
        int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Cell curr = queue.poll();
                for(int[] dir: dirs){
                    int newRow = curr.i + dir[0];
                    int newCol = curr.j + dir[1];
                    if(isValid(newRow, newCol, rooms) && rooms[newRow][newCol] > dist){
                        rooms[newRow][newCol] = dist;
                        queue.offer(new Cell(newRow,newCol));
                    }
                }
            }
            dist++;
        }
    }
    private boolean isValid(int i, int j, int[][] rooms){
        if(i < 0 || j < 0 || i == rooms.length || j == rooms[i].length){
            return false;
        }
        if(rooms[i][j] == -1 || rooms[i][j] == 0){
            return false;
        }
        return true;
    }

}