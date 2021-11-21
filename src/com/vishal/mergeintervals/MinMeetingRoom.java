package com.vishal.mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRoom {

    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> meetingQueue = new PriorityQueue<>((a, b) -> a[1]-b[1]);

        meetingQueue.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] currentInterval = intervals[i];
            int[] prevInterval = meetingQueue.poll();
            if(prevInterval[1] <= currentInterval[0]){
                prevInterval[1] = currentInterval[1];
                meetingQueue.offer(prevInterval);
            }else{
                meetingQueue.offer(prevInterval);
                meetingQueue.offer(currentInterval);
            }
        }

        return meetingQueue.size();
    }

}
