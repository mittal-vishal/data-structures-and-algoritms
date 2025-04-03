package com.vishal.mergeintervals;

import java.util.Arrays;

public class CheckIfCutGridIntoSections {

    public boolean checkValidCuts(int n, int[][] rectangles) {
        int m = rectangles.length;
        int[][] xPoints = new int[m][2];
        int[][] yPoints = new int[m][2];
        for(int i = 0; i < m; i++){
            xPoints[i][0] = rectangles[i][0];
            xPoints[i][1] = rectangles[i][2];
            yPoints[i][0] = rectangles[i][1];
            yPoints[i][1] = rectangles[i][3];
        }
        return isPossible(xPoints) ? true : isPossible(yPoints) ? true : false;
    }

    private boolean isPossible(int[][] points){
        Arrays.sort(points, (a, b) -> a[0]-b[0]);
        int[] prev = points[0];
        int cuts = 0;
        for(int i = 1; i < points.length; i++){
            int[] curr = points[i];
            //doesn't overlap
            if(curr[0] >= prev[1]){
                prev = curr;
                cuts++;
            }else{
                prev[1] = Math.max(prev[1], curr[1]);
            }
        }
        return cuts >= 2;
    }

}
