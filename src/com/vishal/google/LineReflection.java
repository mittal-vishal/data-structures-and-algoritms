package com.vishal.google;

import java.util.HashSet;

public class LineReflection {

    public boolean isReflected(int[][] points) {
        if(points.length == 0){
            return true;
        }
        HashSet<String> uniquePoints = new HashSet<>();
        int max = points[0][0];
        int min = points[0][0];
        for(int[] point: points){
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            String pointStr = point[0] + "," + point[1];
            uniquePoints.add(pointStr);
        }
        int sum = max + min;
        for(int[] point: points){
            String pointStr = sum - point[0] + "," + point[1];
            if(!uniquePoints.contains(pointStr)){
                return false;
            }
        }
        return true;
    }

}
