package com.vishal.google;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinFuelStopsRequired {

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> fuelQueue = new PriorityQueue<>((a,b) -> b-a);
        Arrays.sort(stations, (int[] a, int[] b) -> a[0] - b[0]);
        int pos = -1;
        int fuel = -1;
        int currMiles = 0;
        int refuel = 0;
        int totalDist = 0;
        for(int i = 0; i < stations.length; i++){
            pos = stations[i][0] - currMiles;
            fuel = stations[i][1];
            if(startFuel < pos){
                while(startFuel < pos && !fuelQueue.isEmpty()){
                    startFuel += fuelQueue.poll();
                    refuel++;
                }
            }
            if(startFuel < pos){
                return -1;
            }
            startFuel -= pos;
            totalDist += pos;
            currMiles = stations[i][0];
            fuelQueue.offer(fuel);
            if(totalDist + startFuel >= target){
                return refuel;
            }
        }
        while(totalDist + startFuel < target && !fuelQueue.isEmpty()){
            startFuel += fuelQueue.poll();
            refuel++;
        }
        if(startFuel + totalDist < target){
            return -1;
        }
        return refuel;
    }

    public static void main(String[] args) {
        int target = 100;
        int startFuel = 25;
        int[][] stations = {{25,25},{50,25},{75,205}};
        System.out.print(minRefuelStops(target, startFuel, stations));
    }

}
