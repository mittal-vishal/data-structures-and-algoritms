package com.vishal.google;

import java.util.PriorityQueue;

public class MinFuelStopsRequired {

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int milesCovered = 0;
        int pos = -1, fuel = -1;
        int refuel = 0;

        for(int i = 0; i < stations.length; i++){
            pos = stations[i][0];
            fuel = stations[i][1];
            while(!pq.isEmpty() && startFuel + milesCovered < pos){
                startFuel += pq.poll();
                refuel++;
            }
            if(startFuel + milesCovered < pos){
                return -1;
            }
            if(startFuel + milesCovered >= target){
                return refuel;
            }
            pq.offer(fuel);
            startFuel -= (pos - milesCovered);
            milesCovered = pos;
        }

        while(!pq.isEmpty() && startFuel + milesCovered < target){
            startFuel += pq.poll();
            refuel++;
        }

        if(startFuel + milesCovered < target){
            return -1;
        }else{
            return refuel;
        }
    }

    public static void main(String[] args) {
        int target = 100;
        int startFuel = 25;
        int[][] stations = {{25,25},{50,25},{75,205}};
        System.out.print(minRefuelStops(target, startFuel, stations));
    }

}
