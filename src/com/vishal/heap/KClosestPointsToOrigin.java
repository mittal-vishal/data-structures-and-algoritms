package com.vishal.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class PointCustom{
    int x;
    int y;
    int dist;
    public PointCustom(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class KClosestPointsToOrigin {

    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public List<Point> findClosestPoints(Point[] points, int k) {
        ArrayList<Point> result = new ArrayList<>();
        PriorityQueue<PointCustom> minHeap = new PriorityQueue<>((a, b) -> b.dist - a.dist);
        for (int i = 0; i < points.length; i++) {
            int distFromOrigin = (points[i].x * points[i].x) + (points[i].y * points[i].y);
            minHeap.offer(new PointCustom(points[i].x, points[i].y, distFromOrigin));
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        while (!minHeap.isEmpty()) {
            PointCustom polledPoint = minHeap.poll();
            result.add(new Point(polledPoint.x, polledPoint.y));
        }
        return result;
    }
}
