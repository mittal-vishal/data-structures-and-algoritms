package com.vishal.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetectSquare {

    class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private List<Point> points;
    private HashMap<String, Integer> pointCount;

    public DetectSquare() {
        this.points = new ArrayList<>();
        this.pointCount = new HashMap<>();
    }

    public void add(int[] point) {
        Point currPoint = new Point(point[0],point[1]);
        points.add(currPoint);
        String pointStr = currPoint.x + "#" + currPoint.y;
        pointCount.put(pointStr, pointCount.getOrDefault(pointStr, 0) + 1);
    }

    public int count(int[] point) {
        int px = point[0];
        int py = point[1];
        int result = 0;
        for(Point listPoint: points){
            int x = listPoint.x;
            int y = listPoint.y;
            //If not diagonal then skip and move forward
            if(x == px || y == py || Math.abs(x-px) != Math.abs(y-py)){
                continue;
            }
            //For valid square diagonal, check top left and bottom right point of square
            String expectedTopLeftPoint = x + "#" + py;
            String expectedBottomRightPoint = px + "#" + y;
            result += pointCount.getOrDefault(expectedTopLeftPoint, 0) * pointCount.getOrDefault(expectedBottomRightPoint, 0);
        }
        return result;
    }

}
