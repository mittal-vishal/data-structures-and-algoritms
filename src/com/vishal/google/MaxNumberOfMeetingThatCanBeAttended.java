package com.vishal.google;

import java.util.Arrays;
import java.util.TreeSet;

public class MaxNumberOfMeetingThatCanBeAttended {

    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> {
            if(a[1] != b[1]){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
        });
        int maxDays = events[events.length-1][1];
        TreeSet<Integer> days = new TreeSet<>();
        for(int i = 1; i <= maxDays; i++){
            days.add(i);
        }
        int count = 0;
        for(int[] event: events){
            int start = event[0];
            int end = event[1];
            Integer available = days.ceiling(start);
            if(available == null || available > end){
                continue;
            }else{
                count++;
                days.remove(available);
            }
        }
        return count;
    }

}
