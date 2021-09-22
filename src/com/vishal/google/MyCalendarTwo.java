package com.vishal.google;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {

    private List<int[]> calendarList;
    private List<int[]> overlapList;

    public MyCalendarTwo() {
        calendarList = new ArrayList<>();
        overlapList = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for(int[] interval: overlapList){
            if(isOverLap(interval, new int[]{start, end})){
                return false;
            }
        }
        for(int[] interval: calendarList){
            if(isOverLap(interval, new int[]{start, end})){
                overlapList.add(new int[]{Math.max(start, interval[0]), Math.min(end, interval[1])});
            }
        }
        calendarList.add(new int[]{start, end});
        return true;
    }

    private boolean isOverLap(int[] a, int[] b){
        if(Math.max(a[0], b[0]) < Math.min(a[1], b[1])){
            return true;
        }else{
            return false;
        }
    }
}

