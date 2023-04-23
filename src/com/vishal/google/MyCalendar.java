package com.vishal.google;

import java.util.*;

public class MyCalendar {

    private TreeMap<Integer, Integer> calendarMap;

    public MyCalendar() {
        calendarMap = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendarMap.floorKey(start);
        Integer next = calendarMap.ceilingKey(start);
        if((prev == null || calendarMap.get(prev) <= start) &&
                (next == null || end <= next)){
            calendarMap.put(start, end);
            return true;
        }
        return false;
    }
    /*
    *
    * Brute force method
    *
    * private List<Map.Entry<Integer,Integer>> calendars;

    public MyCalendar() {
        this.calendars = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for(Map.Entry<Integer,Integer> prevInterval: calendars){
            if(isOverlap(start, end, prevInterval)){
                return false;
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
    *
    * */
}
