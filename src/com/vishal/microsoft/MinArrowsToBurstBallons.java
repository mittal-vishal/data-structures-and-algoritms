package com.vishal.microsoft;

import java.util.Arrays;

public class MinArrowsToBurstBallons {

    public int findMinArrowShots(int[][] points) {
        if(points.length == 0){
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int[] prev = points[0];
        int minArrow = 1;
        int range = points[0][1];
        for(int i = 1; i < points.length; i++){
            int[] curr = points[i];
            if(curr[0] <= range){
                continue;
            }else{
                minArrow++;
                range = curr[1];
            }
        }
        return minArrow;
    }

}
