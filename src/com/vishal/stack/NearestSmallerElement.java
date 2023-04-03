package com.vishal.stack;

import java.util.Stack;

public class NearestSmallerElement {

    public int[] prevSmaller(int[] nums, int n) {
        int[] result = new int[n];
        int index = n-1;
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            int currStudentMark = nums[i];
            while(!stack.isEmpty() && currStudentMark <= stack.peek()){
                stack.pop();
            }
            if(stack.isEmpty()){
                result[index--] = -1;
            }else{
                result[index--] = stack.peek();
            }
            stack.push(currStudentMark);
        }
        return result;
    }

}
