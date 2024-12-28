package com.vishal.mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomIII {

    class Solution {
        public int mostBooked(int n, int[][] meetings) {
            int[] rooms = new int[n];
            //Sort meeting based on start date
            Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
            //Room avaiability heap, returns min value
            PriorityQueue<Integer> roomAvailability = new PriorityQueue<>();
            //Tracking of occupied rooms availa
            PriorityQueue<int[]> occupiedRoomAvailability = new PriorityQueue<>((a,b) ->{
                if(a[0] != b[0]){
                    return a[0] - b[0];
                }else{
                    return a[1] - b[1];
                }
            });
            //All rooms available initially
            for(int i = 0; i < n; i++){
                roomAvailability.offer(i);
            }
            //Process meeting by meeting
            for(int[] meeting: meetings){
                //Update room availability if existing meetings are over
                while(!occupiedRoomAvailability.isEmpty() && meeting[0] >= occupiedRoomAvailability.peek()[0]){
                    roomAvailability.offer(occupiedRoomAvailability.poll()[1]);
                }
                //If free room not available, then schedule current meeting with delay.
                int delay = 0;
                if(roomAvailability.isEmpty()){
                    int[] earliestMeetingToComplete = occupiedRoomAvailability.poll();
                    delay = earliestMeetingToComplete[0] - meeting[0];
                    roomAvailability.offer(earliestMeetingToComplete[1]);
                }
                int meetingRoom = roomAvailability.poll();
                occupiedRoomAvailability.offer(new int[]{meeting[1] + delay, meetingRoom});
                rooms[meetingRoom]++;
            }
            //Return the room which help maximum meeting
            int maxMeeting = 0;
            int result = -1;
            for(int i = 0; i < rooms.length; i++){
                if(rooms[i] > maxMeeting){
                    maxMeeting = rooms[i];
                    result = i;
                }
            }
            return result;
        }
    }

}
