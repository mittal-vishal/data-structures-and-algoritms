package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    class Cell{
        int i;
        int j;
        public Cell(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid[0].length == 0){
            return 0;
        }else if(grid[0][0] == 1){
            return 0;
        }
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(0, 0));
        int rows = grid.length;
        int cols = grid[0].length;
        int dist = 1;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, 1}, {1, 1}, {-1, -1}, {1, -1}};
        boolean[][] visited = new boolean[rows][cols];
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Cell polled = queue.poll();
                visited[polled.i][polled.j] = true;
                if(polled.i == cols - 1 && polled.j == cols - 1 && grid[polled.i][polled.j] == 0){
                    return dist;
                }
                for(int j = 0; j < dirs.length; j++){
                    int[] dir = dirs[j];
                    int newI = polled.i + dir[0];
                    int newJ = polled.j + dir[1];
                    if(isValid(newI, newJ, grid) && !visited[newI][newJ] && grid[newI][newJ] == 0){
                        queue.offer(new Cell(newI, newJ));
                    }
                }
            }
            dist++;
        }
        return -1;
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,0,0},{1,1,0},{1,1,0}};
        ShortestPathInBinaryMatrix shortestPath = new ShortestPathInBinaryMatrix();
        int dist = shortestPath.shortestPathBinaryMatrix(matrix);
        System.out.println(dist);
    }

}
