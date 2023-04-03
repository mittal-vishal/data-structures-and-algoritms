package com.vishal.stack;

import java.util.Stack;

public class NextGreaterElementLeetcodeTwo {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int index = n-1;
        for(int i = 2*n-1; i >= 0; i--){
            int currNum = nums[i%n];
            while(!stack.isEmpty() && currNum >= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty() && i < n){
                result[index--] = -1;
            }else if(i < n){
                result[index--] = stack.peek();
            }
            stack.push(currNum);
        }
        return result;
    }

}
