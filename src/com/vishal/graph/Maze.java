package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

class Maze {

    class Cell{
        int i;
        int j;
        Cell(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        char[] dirs = {'L', 'R', 'U', 'B'};
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(start[0], start[1]));
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        while(!queue.isEmpty()){
            Cell polled = queue.poll();
            if(polled.i == destination[0] && polled.j == destination[1]){
                return true;
            }
            for(char ch: dirs){
                Cell neighbour = getNextValidCell(maze, ch, polled.i, polled.j);
                int newRow = neighbour.i;
                int newCol = neighbour.j;
                if(!visited[newRow][newCol]){
                    queue.offer(new Cell(newRow,newCol));
                    visited[newRow][newCol] = true;
                }
            }
        }
        return false;
    }

    private Cell getNextValidCell(int[][] maze, char ch, int i, int j){
        int nextRow = i;
        int nextCol = j;
        if(ch == 'L'){
            for(int col = j-1; col >= 0; col--){
                if(maze[i][col] == 0){
                    nextCol = col;
                }else{
                    break;
                }
            }
        }else if(ch == 'R'){
            for(int col = j+1; col < maze[0].length; col++){
                if(maze[i][col] == 0){
                    nextCol = col;
                }else{
                    break;
                }
            }
        }else if(ch == 'U'){
            for(int row = i-1; row >= 0; row--){
                if(maze[row][j] == 0){
                    nextRow = row;
                }else{
                    break;
                }
            }
        }else{
            for(int row = i+1; row < maze.length; row++){
                if(maze[row][j] == 0){
                    nextRow = row;
                }else{
                    break;
                }
            }
        }
        return new Cell(nextRow,nextCol);
    }
}
