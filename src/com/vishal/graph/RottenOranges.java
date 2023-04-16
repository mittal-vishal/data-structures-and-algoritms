package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

class RottenOranges {

    class Element{
        int i;
        int j;
        Element(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Element> queue = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2){
                    queue.offer(new Element(i, j));
                }
            }
        }
        int days = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean isRotten = false;
            for(int i = 0; i < size; i++){
                Element polled = queue.poll();
                for(int j = 0; j < dirs.length; j++){
                    int[] cordinate = dirs[j];
                    int newX = polled.i + cordinate[0];
                    int newY = polled.j + cordinate[1];
                    if(isValid(newX, newY, grid) && grid[newX][newY] == 1){
                        grid[newX][newY] = 2;
                        isRotten = true;
                        queue.offer(new Element(newX,newY));
                    }
                }
            }
            if(!isRotten){
                break;
            }
            days++;
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return days;
    }

    private boolean isValid(int i , int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }else{
            return false;
        }
    }
}
