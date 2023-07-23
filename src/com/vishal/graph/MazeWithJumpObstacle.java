package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MazeWithJumpObstacle {

    /*
    *
    * [0,1,0]
    * [1,0,0]
    *
    *
    * */

    public static void main(String[] args) {
        int[][] maze = {{0,1,0},{1,0,0}};
        int k = 5;
        System.out.println(getMinimumMoves(maze, k));;
    }

    static class Cell{
        int row;
        int col;
        int steps;
        public Cell(int row, int col, int steps){
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    public static int getMinimumMoves(int[][] maze, int k) {
        //base check
        if(maze == null || maze.length == 0 || maze[0].length == 0){
            return 0;
        }
        if(maze[0][0] == 1){
            return -1;
        }
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(0,0,0));
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int row = maze.length;
        int col = maze[0].length;
        boolean[][] visited = new boolean[row][col];
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Cell curr = queue.poll();
                if(visited[curr.row][curr.col]){
                    continue;
                }
                if(curr.row == row-1 && curr.col == col-1){
                    return steps;
                }
                visited[curr.row][curr.col] = true;
                for(int[] dir: dirs){
                    int newRow = curr.row;
                    int newCol = curr.col;
                    for(int jump = 1; jump <= k; jump++){
                        newRow += dir[0];
                        newCol += dir[1];
                        if(isValid(newRow, newCol, row, col) && !visited[newRow][newCol] && maze[newRow][newCol] == 0){
                            queue.offer(new Cell(newRow, newCol, curr.steps+1));
                        }else if(isValid(newRow, newCol, row, col) && maze[newRow][newCol] == 1){
                            break;
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private static boolean isValid(int i, int j, int m, int n){
        if(i >= 0 && i < m && j >= 0 && j < n){
            return true;
        }
        return false;
    }

}
