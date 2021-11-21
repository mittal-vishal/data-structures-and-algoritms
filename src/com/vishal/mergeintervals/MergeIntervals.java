package com.vishal.mergeintervals;

import java.util.*;

public class MergeIntervals {

    public int[][] mergeOptimal(int[][] intervals) {
        LinkedList<int[]> intervalList = new LinkedList<>();
        if(intervals == null || intervals.length == 0){
            return new int[0][0];
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        intervalList.addLast(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int[] prevInterval = intervalList.removeLast();
            int[] currInterval = intervals[i];
            if(prevInterval[1] >= currInterval[0]){
                prevInterval[0] = Math.min(prevInterval[0], currInterval[0]);
                prevInterval[1] = Math.max(prevInterval[1], currInterval[1]);
                intervalList.addLast(prevInterval);
            }else{
                intervalList.addLast(prevInterval);
                intervalList.addLast(currInterval);
            }
        }

        int[][] mergeIntervals = new int[intervalList.size()][2];
        int index = 0;
        for(int i = 0; i < intervalList.size(); i++){
            mergeIntervals[index++] = intervalList.get(i);
        }

        return mergeIntervals;
    }

    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length < 2){
            return intervals;
        }

        for(int i = 0; i < intervals.length; i++){
            for(int j = 0; j < intervals.length; j++){
                if(i != j && isOverlapped(intervals[i], intervals[j])){
                    //merge the intervals
                    intervals[i][0] = Math.min(intervals[i][0], intervals[j][0]);
                    intervals[j][0] = Math.min(intervals[i][0], intervals[j][0]);
                    intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                    intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
                }
            }
        }

        Set<List<Integer>> intervalSet = new HashSet<>();
        for(int[] interval: intervals){
            intervalSet.add(new ArrayList(Arrays.asList(interval[0],interval[1])));
        }

        int[][] resultant = new int[intervalSet.size()][2];
        int index = 0;
        for(List<Integer> interval: intervalSet){
            resultant[index][0] = interval.get(0);
            resultant[index][1] = interval.get(1);
            index++;
        }
        return resultant;
    }

    private boolean isOverlapped(int[] a, int[] b){
        if(a[1] >= b[0] && a[0] <= b[1]){
            return true;
        }
        return false;
    }

}
