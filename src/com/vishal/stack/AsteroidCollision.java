package com.vishal.stack;

import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int asteroid: asteroids){
            boolean isPush = true;
            while(!stack.isEmpty() && stack.peek() > 0 && asteroid < 0){
                if(Math.abs(asteroid) > Math.abs(stack.peek())){
                    stack.pop();
                    continue;
                }else if(Math.abs(asteroid) == Math.abs(stack.peek())){
                    stack.pop();
                }
                isPush = false;
                break;
            }
            if(isPush){
                stack.push(asteroid);
            }
        }
        int[] res = new int[stack.size()];
        while(!stack.isEmpty()){
            res[stack.size()-1] = stack.pop();
        }
        return res;
    }

}
