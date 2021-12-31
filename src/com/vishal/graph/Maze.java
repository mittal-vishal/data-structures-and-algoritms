package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

class Maze {

    class Cell{
        int row;
        int col;
        public Cell(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0 || maze[0].length == 0){
            return true;
        }
        Cell src = new Cell(start[0], start[1]);
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(src);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[src.row][src.col] = true;
        char[] dirs = {'L','R','U', 'D'};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Cell polledCell = queue.poll();
                if(polledCell.row == destination[0] && polledCell.col == destination[1]) {
                    return true;
                }
                for(char dir: dirs){
                    Cell nextCell = getNext(maze, polledCell, dir);
                    if(visited[nextCell.row][nextCell.col] == false){
                        visited[nextCell.row][nextCell.col] = true;
                        queue.offer(nextCell);
                    }
                }
            }
        }
        return false;
    }

    private Cell getNext(int[][] maze, Cell curr, char dir){
        int currRow = curr.row;
        int currCol = curr.col;
        if(dir == 'U'){
            for(int i = currRow - 1; i >= 0; i--){
                if(isValid(i, currCol, maze) && maze[i][currCol] == 0){
                    currRow = i;
                }else{
                    break;
                }
            }
        }else if(dir == 'D'){
            for(int i = currRow + 1; i < maze.length; i++){
                if(isValid(i, currCol, maze) && maze[i][currCol] == 0){
                    currRow = i;
                }else{
                    break;
                }
            }
        }else if(dir == 'L'){
            for(int i = currCol - 1; i >= 0; i--){
                if(isValid(currRow, i, maze) && maze[currRow][i] == 0){
                    currCol = i;
                }else{
                    break;
                }
            }
        }else{
            for(int i = currCol + 1; i < maze[0].length; i++){
                if(isValid(currRow, i, maze) && maze[currRow][i] == 0){
                    currCol = i;
                }else{
                    break;
                }
            }
        }
        return new Cell(currRow, currCol);
    }

    private boolean isValid(int row, int col, int[][] maze){
        if(row >= 0 && row < maze.length && col >= 0 && col < maze[0].length){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] src = {0,4};
        int[] target = {1,2};
        Maze maze = new Maze();
        boolean isExist = maze.hasPath(grid, src, target);
        System.out.println(isExist);
    }
}
