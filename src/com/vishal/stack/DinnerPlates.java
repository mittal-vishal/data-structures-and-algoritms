package com.vishal.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

class DinnerPlates {

    private List<Stack<Integer>> stacks;
    private TreeSet<Integer> pushSet;
    private TreeSet<Integer> popSet;
    private int capacity;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        this.stacks = new ArrayList<>();
        this.pushSet = new TreeSet<>();
        this.popSet = new TreeSet<>();
    }

    public void push(int val) {
        int index = pushSet.isEmpty() ? -1: pushSet.first();
        if(index == -1){
            index = stacks.size();
            pushSet.add(index);
            stacks.add(new Stack<>());
        }
        Stack<Integer> currStack = stacks.get(index);
        currStack.push(val);
        if(currStack.size() == 1){
            popSet.add(index);
        }
        if(currStack.size() == capacity){
            pushSet.remove(index);
        }
    }

    public int pop() {
        int index = popSet.isEmpty()? -1: popSet.last();
        if(index == -1){
            return -1;
        }
        return popAtStack(index);
    }

    public int popAtStack(int index) {
        if(index < 0 || index >= stacks.size()){
            return -1;
        }
        Stack<Integer> stack = stacks.get(index);
        if(stack.size() == 1){
            popSet.remove(index);
        }
        if(stack.size() == capacity){
            pushSet.add(index);
        }
        return stack.isEmpty()? -1: stack.pop();
    }
}
