package com.vishal.mergeintervals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    };

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        LinkedList<Interval> mergedIntervals = new LinkedList<>();
        if(intervals == null || intervals.size() == 0){
            return Arrays.asList(newInterval);
        }
        int insertAt = -1;
        for(int i = 0; i < intervals.size(); i++){
            if(newInterval.start < intervals.get(i).start){
                mergedIntervals.add(newInterval);
                insertAt = i;
                break;
            }
            mergedIntervals.add(intervals.get(i));
        }

        if(insertAt == -1){
            mergedIntervals.add(newInterval);
            return mergedIntervals;
        }

        for(int i = insertAt; i < intervals.size(); i++){
            if(intervals.get(i).start > mergedIntervals.getLast().end){
                mergedIntervals.add(intervals.get(i));
            }else{
                Interval last = mergedIntervals.removeLast();
                mergedIntervals.add(new Interval(last.start, Math.max(last.end, intervals.get(i).end)));
            }
        }

        return mergedIntervals;
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length == 0){
            return new int[][]{newInterval};
        }

        int startIdx = -1;
        LinkedList<LinkedList<Integer>> mergeIntervals = new LinkedList<>();
        for(int i = 0; i < intervals.length; i++){
            if(newInterval[0] <= intervals[i][1]){
                startIdx = i;
                break;
            }else{
                mergeIntervals.add(new LinkedList(Arrays.asList(intervals[i][0], intervals[i][1])));
            }
        }

        mergeIntervals.add(new LinkedList(Arrays.asList(newInterval[0], newInterval[1])));

        if(startIdx != -1){
            for(int i = startIdx; i < intervals.length; i++){
                if(intervals[i][0] > mergeIntervals.getLast().get(1)){
                    mergeIntervals.add(new LinkedList(Arrays.asList(intervals[i][0], intervals[i][1])));
                }else{
                    List<Integer> lastInterval = mergeIntervals.removeLast();
                    mergeIntervals.add(new LinkedList(Arrays.asList(Math.min(lastInterval.get(0), intervals[i][0]), Math.max(lastInterval.get(1), intervals[i][1]))));
                }
            }
        }

        int[][] resultant = new int[mergeIntervals.size()][2];
        for(int i = 0; i < mergeIntervals.size(); i++){
            resultant[i][0] = mergeIntervals.get(i).get(0);
            resultant[i][1] = mergeIntervals.get(i).get(1);
        }
        return resultant;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2, 5};
        insert(intervals, newInterval);
    }
}
