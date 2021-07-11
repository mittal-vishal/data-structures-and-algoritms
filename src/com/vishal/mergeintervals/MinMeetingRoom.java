package com.vishal.mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRoom {

    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);

        PriorityQueue<Integer> roomQueue = new PriorityQueue<>();
        roomQueue.add(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < roomQueue.peek()){
                roomQueue.add(intervals[i][1]);
            }else{
                roomQueue.poll();
                roomQueue.add(intervals[i][1]);
            }
        }

        return roomQueue.size();
    }

}
