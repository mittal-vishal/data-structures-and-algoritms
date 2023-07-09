package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    static class Element{
        int row;
        int col;
        int dist;
        public Element(int row, int col, int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] result = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        Queue<Element> queue = new LinkedList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(mat[i][j] == 0){
                    queue.offer(new Element(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!queue.isEmpty()){
            Element curr = queue.poll();
            int currRow = curr.row;
            int currCol = curr.col;
            int currDist = curr.dist;
            result[currRow][currCol] = currDist;
            for(int[] dir: dirs){
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];
                if(isValid(newRow, newCol, mat) && !visited[newRow][newCol]){
                    queue.offer(new Element(newRow, newCol, currDist+1));
                    visited[newRow][newCol] = true;
                }
            }
        }
        return result;
    }

    private boolean isValid(int i, int j, int[][] mat){
        if(i >= 0 && i < mat.length && j >= 0 && j < mat[0].length){
            return true;
        }
        return false;
    }

}
