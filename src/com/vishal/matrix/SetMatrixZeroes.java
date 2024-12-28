package com.vishal.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class SetMatrixZeroes {

    static class Cell{
        int row;
        int col;
        public Cell(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public void setZeroes(int[][] matrix) {
        Queue<Cell> queue = new LinkedList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 0){
                    queue.offer(new Cell(i, j));
                }
            }
        }
        while(!queue.isEmpty()){
            Cell currCell = queue.poll();
            //Mark row as '0'
            for(int j = 0; j < col; j++){
                matrix[currCell.row][j] = 0;
            }
            //Mark col as '0'
            for(int i = 0; i < row; i++){
                matrix[i][currCell.col] = 0;
            }
        }
    }

}
