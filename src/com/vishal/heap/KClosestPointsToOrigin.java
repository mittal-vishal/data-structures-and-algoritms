package com.vishal.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Point{
    int x;
    int y;
    int dist;
    public Point(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> b.dist - a.dist);
        for(int i = 0; i < points.length; i++){
            int distance = (points[i][0]*points[i][0]) + (points[i][1]*points[i][1]);
            pq.offer(new Point(points[i][0], points[i][1], distance));
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[][] result = new int[k][2];
        int index = 0;
        while(!pq.isEmpty()){
            Point polled = pq.poll();
            result[index][0] = polled.x;
            result[index][1] = polled.y;
            index++;
        }
        return result;
    }
}
