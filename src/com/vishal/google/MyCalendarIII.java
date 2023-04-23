package com.vishal.google;

import java.util.TreeMap;

public class MyCalendarIII {

    private TreeMap<Integer,Integer> calendars;

    public MyCalendarIII() {
        calendars = new TreeMap<>();
    }

    public int book(int startTime, int endTime) {
        calendars.put(startTime, calendars.getOrDefault(startTime, 0) + 1);
        calendars.put(endTime, calendars.getOrDefault(endTime, 0) - 1);
        int overlap = 0;
        int maxRooms = 0;
        for(int event: calendars.values()){
            overlap += event;
            maxRooms = Math.max(maxRooms, overlap);
        }
        return maxRooms;
    }

}
