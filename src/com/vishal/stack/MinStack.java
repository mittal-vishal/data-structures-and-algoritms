package com.vishal.stack;

import java.util.Stack;

class StackNode{
    int data;
    int min;
    public StackNode(int data, int min){
        this.data = data;
        this.min = min;
    }
}

class MinStack {

    Stack<StackNode> stack;
    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(new StackNode(val, val));
        }else{
            int min = Math.min(val, stack.peek().min);
            stack.push(new StackNode(val, min));
        }
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
        }
    }

    public int top() {
        return (!stack.isEmpty()) ? stack.peek().data: -1;
    }

    public int getMin() {
        return (!stack.isEmpty()) ? stack.peek().min: Integer.MAX_VALUE;
    }
}