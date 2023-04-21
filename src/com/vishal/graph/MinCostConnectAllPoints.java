package com.vishal.graph;

import java.util.HashSet;
import java.util.PriorityQueue;

class MinCostConnectAllPoints {

    class Point{
        int src;
        int dest;
        int dist;
        Point(int src, int dest, int dist){
            this.src = src;
            this.dest = dest;
            this.dist = dist;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> a.dist-b.dist);
        pq.offer(new Point(-1,0,0));
        int cost = 0;
        HashSet<Integer> visited = new HashSet<>();
        int n = points.length;
        while(!pq.isEmpty() && visited.size() < n){
            Point polled = pq.poll();
            if(visited.contains(polled.dest)){
                continue;
            }
            visited.add(polled.dest);
            cost += polled.dist;
            for(int i = 0; i < points.length; i++){
                if(!visited.contains(i)){
                    pq.offer(new Point(polled.dest, i, getDistance(points, polled.dest, i)));
                }
            }
        }
        return cost;
    }

    private int getDistance(int[][] points, int i, int j){
        int[] pointA = points[i];
        int[] pointB = points[j];
        return Math.abs(pointA[0]-pointB[0]) + Math.abs(pointA[1]-pointB[1]);
    }
}
