package com.vishal.google;

import java.util.*;

public class MyCalendarTwo {

    private TreeMap<Integer,Integer> calendars;

    public MyCalendarTwo() {
        calendars = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        calendars.put(start, calendars.getOrDefault(start, 0) + 1);
        calendars.put(end, calendars.getOrDefault(end, 0) - 1);
        int overlap = 0;
        for(int event: calendars.values()){
            overlap += event;
            if(overlap > 2){
                calendars.put(start, calendars.getOrDefault(start, 0) - 1);
                calendars.put(end, calendars.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }

    /*
    * private List<Map.Entry<Integer,Integer>> calendars;
    private List<Map.Entry<Integer,Integer>> overlaps;

    public MyCalendarTwo() {
        calendars = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for(Map.Entry<Integer,Integer> prevInterval: overlaps){
            if(isOverlap(start, end, prevInterval)){
                return false;
            }
        }
        for(Map.Entry<Integer,Integer> prevInterval: calendars){
            if(isOverlap(start, end, prevInterval)){
                overlaps.add(prevInterval);
            }
        }
        calendars.add(new AbstractMap.SimpleEntry<>(start,end));
        return true;
    }

    private boolean isOverlap(int start, int end, Map.Entry<Integer,Integer> prevInterval){
        if(Math.max(start, prevInterval.getKey()) < Math.min(end, prevInterval.getValue())){
            return true;
        }
        return false;
    }
    * */
}

