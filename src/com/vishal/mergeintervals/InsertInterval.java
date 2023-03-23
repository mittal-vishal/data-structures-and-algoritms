package com.vishal.mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        List<int[]> mergedList = new ArrayList<>();
        while(i < n && newInterval[0] > intervals[i][1]){
            mergedList.add(intervals[i++]);
        }
        while(i < n && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        mergedList.add(newInterval);
        while(i < n){
            mergedList.add(intervals[i++]);
        }
        int[][] res = new int[mergedList.size()][2];
        for(int j = 0; j < mergedList.size(); j++){
            res[j] = mergedList.get(j);
        }
        return res;
    }
}
