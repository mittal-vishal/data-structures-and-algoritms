package com.vishal.heap;

import java.util.PriorityQueue;

public class MinNumberOfRefuelingStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int fuelFreq = 0;
        for(int i = 0; i < stations.length; i++){
            int distance = stations[i][0];
            int fuel = stations[i][1];
            while(startFuel < distance){
                if(pq.isEmpty()){
                    return -1;
                }
                startFuel += pq.poll();
                fuelFreq++;
            }
            if(startFuel > target){
                return fuelFreq;
            }
            pq.offer(fuel);
        }
        while(startFuel < target){
            if(pq.isEmpty()){
                return -1;
            }
            startFuel += pq.poll();
            fuelFreq++;
        }
        return fuelFreq;
    }

}
