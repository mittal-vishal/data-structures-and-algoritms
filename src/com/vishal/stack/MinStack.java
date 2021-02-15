package com.vishal.stack;

import java.util.Stack;

public class MinStack {

    /** initialize your data structure here. */

    Stack<StackNode> stack;

    static class StackNode{
        int value;
        int minVal;
        StackNode(int value, int minVal){
            this.value = value;
            this.minVal = minVal;
        }
    }

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        int min = Math.min(x, getMin());
        stack.push(new StackNode(x, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        if(!stack.isEmpty()){
            return stack.peek().minVal;
        }else{
            return Integer.MAX_VALUE;
        }
    }
}
