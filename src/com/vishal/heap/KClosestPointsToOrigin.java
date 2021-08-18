package com.vishal.heap;

import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    class Pair{
        int x;
        int y;
        int dist;
        public Pair(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    class Solution {
        public int[][] kClosest(int[][] points, int k) {

            PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.dist - b.dist);
            int srcX = 0;
            int srcY = 0;

            for(int i = 0; i < points.length; i++){
                int x = points[i][0];
                int y = points[i][1];
                int num = ((x - srcX)*(x - srcX)) + ((y - srcY)*(y - srcY));
                pq.offer(new Pair(x, y, num));
            }

            int[][] res = new int[k][2];
            int index = 0;

            while(!pq.isEmpty() && k > 0){
                Pair poppedPair = pq.poll();
                k--;
                res[index][0] = poppedPair.x;
                res[index][1] = poppedPair.y;
                index++;
            }

            return res;
        }
    }

}
