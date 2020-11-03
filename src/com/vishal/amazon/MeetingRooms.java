package com.vishal.amazon;

public class MeetingRooms {
	
	public boolean canAttendMeetings(int[][] intervals) {
        for(int i = 0; i < intervals.length; i++){
            for(int j = i + 1; j < intervals.length; j++){
                if(isOverlappedOptimized(intervals[i], intervals[j])){
                    return false;
                }
            }
        }
        return true;
    }
	
	private boolean isOverlappedOptimized(int[] i1, int[] i2){
        if(Math.min(i1[1], i2[1]) <= Math.max(i1[0], i2[0])){
            return false;
        }else{
            return true;
        }
    }
    
    private boolean isOverlapped(int[] i1, int[] i2){
        if((i1[0] == i2[0] && i1[1] == i2[1]) ||
            (i1[0] >= i2[0] && i1[0] < i2[1]) ||
            (i2[0] >= i1[0] && i2[0] < i1[1])){
                return true;
        }
        return false;
    }

}
