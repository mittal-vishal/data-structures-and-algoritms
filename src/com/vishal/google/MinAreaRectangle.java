package com.vishal.google;

import java.util.HashMap;
import java.util.HashSet;

public class MinAreaRectangle {

    public int minAreaRect(int[][] points) {
        HashMap<Integer, HashSet<Integer>> xToYs = new HashMap<>();
        for(int[] point: points){
            xToYs.putIfAbsent(point[0], new HashSet<>());
            xToYs.get(point[0]).add(point[1]);
        }
        //Iterate all possible combination of 2 points
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < points.length-1; i++){
            for(int j = i+1; j < points.length; j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if(x1 != x2 && y1 != y2){
                    //we get diagonal pair
                    if(xToYs.get(x1).contains(y2) && xToYs.get(x2).contains(y1)){
                        //we get the rectangle
                        int area = Math.abs(x2-x1) * Math.abs(y2-y1);
                        result = Math.min(result, area);
                    }
                }
            }
        }
        return result != Integer.MAX_VALUE ? result : 0;
    }

}
