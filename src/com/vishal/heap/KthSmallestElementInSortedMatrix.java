package com.vishal.heap;

import java.util.PriorityQueue;

class MatrixElement{
    int val;
    int row;
    int col;
    public MatrixElement(int val, int row, int col){
        this.val = val;
        this.row = row;
        this.col = col;
    }
}

class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<MatrixElement> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for(int i = 0; i < matrix.length; i++){
            pq.offer(new MatrixElement(matrix[i][0], i, 0));
        }
        while(!pq.isEmpty() && k-- > 0){
            MatrixElement lowestElement = pq.poll();
            if(k == 0){
                return lowestElement.val;
            }
            if(matrix[0].length > lowestElement.col + 1){
                pq.offer(new MatrixElement(matrix[lowestElement.row][lowestElement.col + 1], lowestElement.row, lowestElement.col + 1));
            }
        }
        return -1;
    }
}