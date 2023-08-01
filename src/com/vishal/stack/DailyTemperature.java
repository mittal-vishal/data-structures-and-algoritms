package com.vishal.stack;

import java.util.Stack;

public class DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = temperatures.length-1; i >= 0; i--){
            int currTemperature = temperatures[i];
            while(!stack.isEmpty() && temperatures[stack.peek()] <= currTemperature){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[i] = stack.peek()-i;
            }
            stack.push(i);
        }
        return result;
    }

}
