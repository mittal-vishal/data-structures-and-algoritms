package com.vishal.heap;

import java.util.PriorityQueue;

class KthSmallestElementInSortedMatrix {

    class Element{
        int row;
        int col;
        int val;
        public Element(int row, int col, int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(int i = 0; i < matrix.length; i++){
            pq.offer(new Element(i, 0, matrix[i][0]));
        }
        while(!pq.isEmpty()){
            Element polled = pq.poll();
            if(k == 1){
                return polled.val;
            }
            k--;
            if((polled.col + 1) < matrix[0].length){
                pq.offer(new Element(polled.row, polled.col+1, matrix[polled.row][polled.col+1]));
            }
        }
        return -1;
    }
}