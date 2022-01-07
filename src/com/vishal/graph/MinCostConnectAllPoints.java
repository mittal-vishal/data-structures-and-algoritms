package com.vishal.graph;

import java.util.PriorityQueue;

class MinCostConnectAllPoints {

    class Point{
        int src;
        int target;
        int dist;
        public Point(int src, int target, int dist){
            this.src = src;
            this.target = target;
            this.dist = dist;
        }

    }

    public int minCostConnectPoints(int[][] points) {
        if(points == null || points.length == 0){
            return -1;
        }
        int minCost = 0;
        int totalPoints = points.length;
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new Point(-1, 0, 0));
        boolean[] visited = new boolean[points.length];
        while(!pq.isEmpty() && totalPoints > 0){
            Point curr = pq.poll();
            if(visited[curr.target]){
                continue;
            }
            minCost += curr.dist;
            visited[curr.target] = true;
            for(int i = 0; i < points.length; i++){
                if(!visited[i]){
                    pq.offer(new Point(curr.target, i, getDistance(curr.target, i, points)));
                }
            }
        }
        return minCost;
    }

    private int getDistance(int i, int j, int[][] points){
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}
