package com.vishal.mergeintervals;

import java.util.Arrays;

public class CountIntervalWithoutMeeting {

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0]-b[0]);
        int prev = meetings[0][1];
        int count = 0;
        for(int i = 1; i < meetings.length; i++){
            int curr[] = meetings[i];
            int gap = (curr[0] - prev > 0) ? curr[0] - prev  - 1 : 0;
            count += gap;
            prev = Math.max(prev, curr[1]);
        }
        int[] first = meetings[0];
        count += (first[0] - 1);
        count += (days - prev);
        return count;
    }

}
