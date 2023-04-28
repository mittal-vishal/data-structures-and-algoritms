package com.vishal.mergeintervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomIII {

    public int mostBooked(int n, int[][] meetings) {
        // sort rooms by start time
        Arrays.sort(meetings, (m1, m2) -> m1[0] - m2[0]);
        // key: int[end time, room number]
        // sort by end time, if the same end time - sort by lowest room number
        PriorityQueue<int[]> busyRooms = new PriorityQueue<>((m1, m2) -> m1[0] != m2[0] ? m1[0] - m2[0]: m1[1] - m2[1]);
        //store index of available room
        PriorityQueue<Integer> availableRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableRooms.add(i); // add all rooms to availability
        }
        int[] roomUsageCount = new int[n];

        for (int[] meeting : meetings) {
            int currMeetingStartTime = meeting[0];
            while (!busyRooms.isEmpty() && currMeetingStartTime >= busyRooms.peek()[0]) { // empty past meetings
                availableRooms.add(busyRooms.remove()[1]); // add freed room to availability
            }
            int delay = 0;
            if (availableRooms.size() == 0) { // all rooms are full
                int[] endedMeeting = busyRooms.remove();
                delay = endedMeeting[0] - currMeetingStartTime; // add delay
                availableRooms.add(endedMeeting[1]); // add free room back to availability
            }
            int currMeetingEndTime = meeting[1] + delay;
            int availableRoom = availableRooms.remove(); // get lowest available room
            busyRooms.add(new int[] {currMeetingEndTime, availableRoom}); // add current meeting
            roomUsageCount[availableRoom]++;
        }

        // find the most used room
        int maxUsedRoom = 0;
        int maxUsage = 0;
        for (int i = 0; i < n; i++) {
            if (roomUsageCount[i] > maxUsage) {
                maxUsage = roomUsageCount[i];
                maxUsedRoom = i;
            }
        }
        return maxUsedRoom;
    }

}
