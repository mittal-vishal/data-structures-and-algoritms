package com.vishal.stack;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeSet;

class DinnerPlates {

    ArrayList<Stack> stackList;
    int capacity;
    TreeSet<Integer> pushSet;
    TreeSet<Integer> popSet;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        stackList = new ArrayList<>();
        pushSet = new TreeSet<>();
        popSet = new TreeSet<>();
    }

    public void push(int val) {
        int index = pushSet.isEmpty() ? -1: pushSet.first();
        if(index == -1){
            index = stackList.size();
            pushSet.add(index);
            stackList.add(new Stack<>());
        }
        Stack<Integer> currStack = stackList.get(index);
        if(currStack.isEmpty()){
            popSet.add(index);
        }
        currStack.push(val);
        if(currStack.size() == capacity){
            pushSet.remove(index);
        }
    }

    public int pop() {
        if(popSet.isEmpty()){
            return -1;
        }
        int index = popSet.last();
        return popAtStack(index);
    }

    public int popAtStack(int index) {
        Stack<Integer> currStack = index < stackList.size() ? stackList.get(index): null;
        if(currStack == null || currStack.isEmpty()){
            return -1;
        }else{
            int item = currStack.pop();
            if(currStack.isEmpty()){
                popSet.remove(index);
            }
            pushSet.add(index);
            return item;
        }
    }
}
