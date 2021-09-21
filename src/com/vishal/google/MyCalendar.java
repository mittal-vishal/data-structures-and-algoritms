package com.vishal.google;

import java.util.TreeMap;

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
}
