package com.vishal.google;

public class WateringPlants {

    public int wateringPlants(int[] plants, int capacity) {
        int n = plants.length;
        int currCapacity = capacity;
        int steps = 0;
        for(int i = 0; i < n; i++){
            int waterNeeded = plants[i];
            if(currCapacity < waterNeeded){
                steps += 2*i;
                currCapacity = capacity;
            }
            steps++;
            currCapacity -= waterNeeded;
        }
        return steps;
    }

}
