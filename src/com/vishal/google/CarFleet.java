package com.vishal.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CarFleet {

    public static void main(String[] args) {
        int[] positions = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        int target = 12;
        CarFleet fleet = new CarFleet();
        int fleets = fleet.carFleet(target, positions, speed);
        System.out.print(fleets);
    }

    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> timeToReachMap = new TreeMap<>();
        int totalCars = position.length;
        for(int i = 0; i < totalCars; i++){
            double carSpeed = speed[i];
            double timeToReach = (target - position[i]) / carSpeed;
            timeToReachMap.put(position[i], timeToReach);
        }
        List<Double> timeToReachList = new ArrayList<>(timeToReachMap.values());
        double currTimeToReach = 0d;
        int totalFleet = 0;
        for(int i = timeToReachList.size() - 1; i >= 0; i--){
            if(currTimeToReach == 0d || timeToReachList.get(i) > currTimeToReach){
                totalFleet++;
                currTimeToReach = timeToReachList.get(i);
            }else{
                currTimeToReach = Math.max(currTimeToReach, timeToReachList.get(i));;
            }
        }
        return totalFleet;
    }

}
