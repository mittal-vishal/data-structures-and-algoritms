package com.vishal.mergeintervals;

import java.util.*;

public class MergeIntervals {

    public int[][] mergeOptimal(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[][]{};
        }
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        LinkedList<int[]> mergeIntervals = new LinkedList<>();
        mergeIntervals.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            //If overlapping
            if(curr[0] <= mergeIntervals.getLast()[1]){
                mergeIntervals.getLast()[1] = Math.max(mergeIntervals.getLast()[1], curr[1]);
            }else{
                mergeIntervals.add(curr);
            }
        }
        int[][] res = new int[mergeIntervals.size()][2];
        for(int i = 0; i < mergeIntervals.size(); i++){
            res[i] = mergeIntervals.get(i);
        }
        return res;
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
