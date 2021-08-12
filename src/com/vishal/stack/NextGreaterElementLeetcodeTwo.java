package com.vishal.stack;

import java.util.Stack;

public class NextGreaterElementLeetcodeTwo {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = 2*n-1; i >= 0; i--){
            while(!stack.isEmpty() && nums[i%n] >= stack.peek()){
                stack.pop();
            }
            if(i < n){
                if(!stack.isEmpty()){
                    res[i] = stack.peek();
                }else{
                    res[i] = -1;
                }
            }
            stack.push(nums[i%n]);
        }
        return res;
    }

}
