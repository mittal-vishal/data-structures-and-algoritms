package com.vishal.stack;

import java.util.ArrayList;
import java.util.Stack;

public class StackPlates {

    ArrayList<Stack<Integer>> stackList;
    int index;

    private static final int STACK_CAPACITY = 5;

    public StackPlates(){
        stackList = new ArrayList<>();
        index = 0;
    }

    public void pushItem(int item){
        Stack<Integer> currStack = getLastStack();
        if(currStack == null){
            currStack = new Stack<>();
        }else if(currStack.size() < STACK_CAPACITY){
            currStack.push(item);
        }else{
            currStack = new Stack<>();
            index++;
        }
        currStack.push(item);
        stackList.add(index, currStack);
    }

    public int popItem(){
        Stack<Integer> currStack = getLastStack();
        if(currStack.isEmpty()){
           currStack = stackList.get(--index);
        }
        int item = currStack.pop();
        stackList.add(index,currStack);
        return item
    }

    public Stack<Integer> getLastStack(){
        return stackList.get(index);
    }


}
