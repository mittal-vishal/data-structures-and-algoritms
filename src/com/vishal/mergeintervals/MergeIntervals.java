package com.vishal.mergeintervals;

import java.util.*;

public class MergeIntervals {

    public int[][] mergeOptimized(int[][] intervals) {
        if(intervals == null || intervals.length < 2){
            return intervals;
        }

        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);

        LinkedList<LinkedList<Integer>> intervalList = new LinkedList<>();

        for(int[] interval: intervals){
            if(intervalList.size() == 0 || intervalList.getLast().get(1) < interval[0]){
                intervalList.add(new LinkedList(Arrays.asList(interval[0], interval[1])));
            }else{
                List<Integer> last = intervalList.removeLast();
                intervalList.add(new LinkedList(Arrays.asList(last.get(0), Math.max(last.get(1), interval[1]))));
            }
        }

        int[][] resultant = new int[intervalList.size()][2];
        for(int i = 0; i < intervalList.size(); i++){
            resultant[i][0] = intervalList.get(i).get(0);
            resultant[i][1] = intervalList.get(i).get(1);
        }
        return resultant;
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
