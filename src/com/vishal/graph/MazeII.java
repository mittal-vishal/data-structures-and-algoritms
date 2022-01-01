package com.vishal.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MazeII {

    class Cell{
        int row;
        int col;
        int dist;
        public Cell(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        Cell srcCell = new Cell(start[0], start[1]);
        srcCell.dist = 0;
        pq.offer(srcCell);
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[] dists = new int[maze.length * maze[0].length];
        Arrays.fill(dists, Integer.MAX_VALUE);
        while(!pq.isEmpty()){
            Cell polledCell = pq.poll();
            visited[polledCell.row][polledCell.col] = true;
            for(int i = 0; i < dirs.length; i++){
                int[] dir = dirs[i];
                int row = polledCell.row;
                int col = polledCell.col;
                int dist = polledCell.dist;
                while(isValid(row, col, maze) && maze[row][col] == 0){
                    row += dir[0];
                    col += dir[1];
                    dist++;
                }
                dist--;
                row -= dir[0];
                col -= dir[1];
                if(!visited[row][col] && dist < dists[(maze[0].length * row) + col]){
                    dists[(maze[0].length * row) + col] = dist;
                    Cell newCell = new Cell(row, col);
                    newCell.dist = dist;
                    pq.offer(newCell);
                }
            }
        }
        int index = (maze[0].length * destination[0]) + destination[1];
        return dists[index] != Integer.MAX_VALUE ? dists[index]: -1;
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
        int[] target = {4,4};
        MazeII maze = new MazeII();
        int dist = maze.shortestDistance(grid, src, target);
        System.out.println(dist);
    }
}
