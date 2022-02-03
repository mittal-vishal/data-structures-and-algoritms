package com.vishal.mergeintervals;

import java.util.Arrays;

public class EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int eraseCount = 0;
        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[0] < prev[1]){
                eraseCount++;
                if(curr[1] < prev[1]){
                    prev = curr;
                }
            }else{
                prev = curr;
            }
        }
        return eraseCount;
    }

}
