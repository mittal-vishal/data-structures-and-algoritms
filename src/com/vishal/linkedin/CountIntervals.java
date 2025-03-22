package com.vishal.linkedin;

import java.util.TreeMap;

public class CountIntervals {

    private TreeMap<Integer,Integer> intervals;
    private int count;

    public CountIntervals() {
        intervals = new TreeMap<>();
    }

    public void add(int left, int right) {
        while(intervals.floorKey(right) != null && left <= intervals.get(intervals.floorKey(right))){
            int existingIntervalLeft = intervals.floorKey(right);
            int existingIntervalRight = intervals.get(existingIntervalLeft);
            intervals.remove(existingIntervalLeft);
            count -= (existingIntervalRight-existingIntervalLeft+1);
            left = Math.min(left, existingIntervalLeft);
            right = Math.max(right, existingIntervalRight);
        }
        count += (right-left+1);
        intervals.put(left,right);
    }

    public int count() {
        return count;
    }

}
