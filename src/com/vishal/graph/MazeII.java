package com.vishal.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MazeII {

    class Cell{
        int i;
        int j;
        int dist;
        Cell(int i, int j, int dist){
            this.i = i;
            this.j = j;
            this.dist = dist;
        }
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b) -> a.dist-b.dist);
        int row = maze.length;
        int col = maze[0].length;
        int[][] dist = new int[row][col];
        for(int i = 0; i < row; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[start[0]][start[1]] = 0;
        pq.offer(new Cell(start[0], start[1], 0));
        char[] dirs = {'L', 'R', 'U', 'B'};
        while(!pq.isEmpty()){
            Cell polled = pq.poll();
            if(polled.i == destination[0] && polled.j == destination[1]){
                return polled.dist;
            }
            for(char dir: dirs){
                Cell neighbour = getNeighbour(maze, dir, polled.i, polled.j);
                int newRow = neighbour.i;
                int newCol = neighbour.j;
                int newDist = neighbour.dist;
                if(dist[newRow][newCol] > (newDist + polled.dist)){
                    dist[newRow][newCol] = newDist + polled.dist;
                    pq.offer(new Cell(newRow, newCol, dist[newRow][newCol]));
                }
            }
        }
        return -1;
    }

    private Cell getNeighbour(int[][] maze, char dir, int i, int j){
        int nextRow = i;
        int nextCol = j;
        int dist = 0;
        if(dir == 'L'){
            for(int col = j-1; col >= 0; col--){
                if(maze[i][col] == 0){
                    nextCol = col;
                    dist++;
                }else{
                    break;
                }
            }
        }else if(dir == 'R'){
            for(int col = j+1; col < maze[0].length; col++){
                if(maze[i][col] == 0){
                    nextCol = col;
                    dist++;
                }else{
                    break;
                }
            }
        }else if(dir == 'U'){
            for(int row = i-1; row >= 0; row--){
                if(maze[row][j] == 0){
                    nextRow = row;
                    dist++;
                }else{
                    break;
                }
            }
        }else{
            for(int row = i+1; row < maze.length; row++){
                if(maze[row][j] == 0){
                    nextRow = row;
                    dist++;
                }else{
                    break;
                }
            }
        }
        if(dist == 0) dist = Integer.MAX_VALUE;
        return new Cell(nextRow, nextCol, dist);
    }
}
