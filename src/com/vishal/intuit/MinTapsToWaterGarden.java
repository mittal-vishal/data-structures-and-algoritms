package com.vishal.intuit;

public class MinTapsToWaterGarden {

    public int minTaps(int n, int[] ranges) {
        int start = 0;
        int end = n;
        int[] startEnd = new int[n+1];
        for(int i = 0; i < ranges.length; i++){
            start = Math.max(0, i-ranges[i]);
            end = Math.min(n, i+ranges[i]);
            startEnd[start] = Math.max(startEnd[start], end);
        }
        int maxEnd = 0;
        int currEnd = 0;
        int taps = 0;
        for(int i = 0; i < startEnd.length; i++){
            if(i > maxEnd){
                return -1;
            }
            if(i > currEnd){
                currEnd = maxEnd;
                taps++;
            }
            maxEnd = Math.max(maxEnd, startEnd[i]);
        }
        return taps;
    }

}
