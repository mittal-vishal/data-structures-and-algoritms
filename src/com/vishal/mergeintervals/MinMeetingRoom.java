package com.vishal.mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRoom {

    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(pq.isEmpty() || curr[0] < pq.peek()[1]){
                pq.offer(curr);
            }else{
                pq.poll();
                pq.offer(curr);
            }
        }
        return pq.size();
    }

}
