package com.vishal.google;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        if(trips == null || trips.length == 0){
            return true;
        }
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(trips[0]);
        capacity -= trips[0][0];
        if(capacity < 0){
            return false;
        }
        for(int i = 1; i < trips.length; i++){
            int[] currTrip = trips[i];
            while(!pq.isEmpty() && pq.peek()[2] <= currTrip[1]){
                capacity += pq.poll()[0];
            }
            //Overlap trip
            if(pq.isEmpty() || pq.peek()[2] > currTrip[1]){
                capacity -= currTrip[0];
                pq.offer(currTrip);
                if(capacity < 0){
                    return false;
                }
            }
        }
        return true;
    }

}
