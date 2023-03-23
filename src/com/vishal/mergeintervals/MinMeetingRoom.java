package com.vishal.mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinMeetingRoom {

    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]- b[1]);
        pq.offer(intervals[0]);
        int result = 1;
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            while(!pq.isEmpty() && curr[0] >= pq.peek()[1]){
                pq.remove();
            }
            pq.offer(curr);
            result = Math.max(result, pq.size());
        }
        return result;
    }

}
