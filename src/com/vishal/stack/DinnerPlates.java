package com.vishal.stack;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

class DinnerPlates {

    private ArrayList<Stack> stackList;
    private int capacity;
    private TreeSet<Integer> pushable;
    private TreeSet<Integer> popable;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        stackList = new ArrayList<>();
        pushable = new TreeSet<>();
        popable = new TreeSet<>();
    }

    public void push(int val) {
        int index = pushable.isEmpty() ? -1: pushable.first();
        if(index == -1){
            index = stackList.size();
            pushable.add(stackList.size());
            stackList.add(new Stack<>());
        }
        Stack<Integer> currStack = stackList.get(index);
        if(currStack.isEmpty()){
            popable.add(index);
        }
        currStack.add(val);
        if(currStack.size() == capacity){
            pushable.remove(index);
        }
    }

    public int pop() {
        if(popable.isEmpty()){
            return -1;
        }
        int index = popable.last();
        return popAtStack(index);
    }

    public int popAtStack(int index) {
        Stack<Integer> currStack = index < stackList.size() ? stackList.get(index): null;
        if(currStack == null || currStack.isEmpty()){
            return -1;
        }else{
            int item = currStack.pop();
            if(currStack.isEmpty()){
                popable.remove(index);
            }
            pushable.add(index);
            return item;
        }
    }
}