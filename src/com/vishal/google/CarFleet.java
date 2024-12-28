package com.vishal.google;

import java.util.*;

public class CarFleet {

    static class Car{
        int pos;
        int speed;
        double time;
        public Car(int pos, int speed, double time){
            this.pos = pos;
            this.speed = speed;
            this.time = time;
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> cars = new ArrayList<>();
        int n = position.length;
        for(int i = 0; i < n; i++){
            double time = (target-position[i])/(speed[i]*1d);
            cars.add(new Car(position[i], speed[i], time));
        }
        Collections.sort(cars, (a, b) -> a.pos-b.pos);
        double lastTimeToReach = cars.get(n-1).time;
        int collisions = 0;
        for(int i = n-2; i >= 0; i--){
            double currTimeToReach = cars.get(i).time;
            if(currTimeToReach <= lastTimeToReach){
                collisions++;
                lastTimeToReach = Math.max(lastTimeToReach, currTimeToReach);
            }else{
                lastTimeToReach = currTimeToReach;
            }
        }
        return n-collisions;
    }

}
