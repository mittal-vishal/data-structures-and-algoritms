package com.vishal.stack;

import java.util.Stack;

public class NearestSmallestElement {

    public int[] prevSmaller(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[A.length];
        for(int i = 0; i < A.length; i++){
            while(!stack.isEmpty() && stack.peek() >= A[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = -1;
            }else{
                res[i] = stack.peek();
            }
            stack.push(A[i]);
        }
        return res;
    }

}
