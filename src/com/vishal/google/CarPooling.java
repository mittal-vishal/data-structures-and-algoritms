package com.vishal.google;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        for(int i = 0; i < trips.length; i++){
            int[] currTrip = trips[i];
            while(!pq.isEmpty() && currTrip[1] >= pq.peek()[2]){
                capacity += pq.poll()[0];
            }
            capacity -= currTrip[0];
            if(capacity < 0){
                return false;
            }
            pq.offer(currTrip);
        }
        return true;
    }

}
