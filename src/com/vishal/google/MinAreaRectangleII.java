package com.vishal.google;

import java.util.HashSet;

public class MinAreaRectangleII {

    public double minAreaFreeRect(int[][] points) {
        HashSet<String> uniquePoints = new HashSet<>();
        for(int[] point: points){
            String hash = point[0] + "," + point[1];
            uniquePoints.add(hash);
        }
        int n = points.length;
        double result = Double.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                for(int k = j+1; k < n; k++){
                    //check if three sides are right angled using pythogorus
                    if(getDistance(points[i], points[k]) + getDistance(points[k], points[j]) != getDistance(points[i], points[j])){
                        continue;
                    }
                    //calculate 4th pair x3,y4
                    int x4 = points[i][0] + points[j][0] - points[k][0];
                    int y4 = points[i][1] + points[j][1] - points[k][1];
                    if(!uniquePoints.contains(x4 + "," + y4)){
                        continue;
                    }
                    //calculate area
                    double area = getArea(points[i], points[j], points[k]);
                    if(area == 0){
                        continue;
                    }
                    result = Math.min(result, area);
                }
            }
        }
        return result != Double.MAX_VALUE ? result : 0d;
    }

    private double getArea(int pt1[], int[] pt2, int[] pt3){
        double width = getDistance(pt1, pt3);
        double height = getDistance(pt3, pt2);
        return Math.sqrt(width*height);
    }

    private double getDistance(int[] pt1, int[] pt2){
        return Math.pow(pt1[0] - pt2[0], 2) + Math.pow(pt1[1] - pt2[1],2);
    }

}
