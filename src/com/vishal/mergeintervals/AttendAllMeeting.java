package com.vishal.mergeintervals;

import java.util.Arrays;

public class AttendAllMeeting {

    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return true;
        }

        //sort based on start time
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < intervals[i-1][1]){
                return false;
            }
        }

        return true;
    }

}
