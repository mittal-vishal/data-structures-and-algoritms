package com.vishal.stack;

import java.util.Stack;

class MinStack {

    class StackNode{
        int val;
        int min;
        public StackNode(int val){
            this.val = val;
        }
    }

    private Stack<StackNode> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        StackNode stackNode = new StackNode(val);
        if(stack.isEmpty()){
            stackNode.min = val;
        }else{
            stackNode.min = Math.min(stack.peek().min, val);
        }
        stack.push(stackNode);
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
        }
    }

    public int top() {
        if(!stack.isEmpty()){
            return stack.peek().val;
        }else{
            return -1;
        }
    }

    public int getMin() {
        if(!stack.isEmpty()){
            return stack.peek().min;
        }else{
            return -1;
        }
    }
}