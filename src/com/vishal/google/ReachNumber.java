package com.vishal.google;

public class ReachNumber {

    public int reachNumber(int target) {
        int sum = 0;
        int steps = 0;
        target = Math.abs(target);
        while(sum < target){
            steps++;
            sum += steps;
        }

        while(((Math.abs(target - sum)) % 2) != 0){
            steps++;
            sum += steps;
        }

        return steps;
    }

}
