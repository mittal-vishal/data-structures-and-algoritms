package com.vishal.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

    public int[][] mergeOptimized(int[][] intervals) {
        if(intervals == null || intervals.length < 2){
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        LinkedList<int[]> mergedIntervals = new LinkedList<>();
        for(int[] interval: intervals){
            if(mergedIntervals.isEmpty() || mergedIntervals.getLast()[1] < interval[0]){
                mergedIntervals.add(interval);
            }else{
                mergedIntervals.getLast()[1] = Math.max(mergedIntervals.getLast()[1], interval[1]);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length < 2){
            return intervals;
        }

        for(int i = 0; i < intervals.length; i++){
            for(int j = 0; j < intervals.length; j++){
                if(i != j){
                    if(isOverLapped(intervals[i], intervals[j])){
                        intervals[i][0] = Math.min(intervals[i][0], intervals[j][0]);
                        intervals[j][0] = Math.min(intervals[i][0], intervals[j][0]);
                        intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                        intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
                    }
                }
            }
        }

        List<List<Integer>> uniqueIntervalsList = new ArrayList<>();
        for(int[] interval: intervals){
            if(!uniqueIntervalsList.contains(Arrays.asList(interval[0], interval[1]))){
                uniqueIntervalsList.add(Arrays.asList(interval[0], interval[1]));
            }
        }

        int[][] resultant = new int[uniqueIntervalsList.size()][2];
        for(int i = 0; i < uniqueIntervalsList.size(); i++){
            resultant[i][0] = uniqueIntervalsList.get(i).get(0);
            resultant[i][1] = uniqueIntervalsList.get(i).get(1);
        }

        return resultant;
    }

    private boolean isOverLapped(int[] a, int[] b){
        if(a[1] >= b[0] && a[0] <= b[1]){
            return true;
        }else{
            return false;
        }
    }

}
