package com.vishal.stack;

import java.util.Stack;

public class ValidateStackSequence {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for(int pushItem: pushed){
            stack.push(pushItem);
            while(!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return j == popped.length;
    }

}
