package com.vishal.google;

import java.util.Arrays;
import java.util.Stack;

public class CarFleetII {

    public double[] getCollisionTimes(int[][] cars) {
        Stack<Integer> stack = new Stack<>();
        int n = cars.length;
        double[] res = new double[n];
        Arrays.fill(res, -1);
        for(int i = n - 1; i >= 0; i--){
            int[] currCar = cars[i];

            while(!stack.isEmpty() && currCar[1] <= cars[stack.peek()][1]){
                stack.pop();
            }

            while(!stack.isEmpty()){
                double speedDiff = currCar[1] - cars[stack.peek()][1];
                double collisionTime = (cars[stack.peek()][0] - currCar[0]) / speedDiff;
                if(res[stack.peek()] == -1 || collisionTime < res[stack.peek()]){
                    res[i] = collisionTime;
                    break;
                }
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

}
