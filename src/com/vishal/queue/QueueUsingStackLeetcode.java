package com.vishal.queue;

import java.util.Stack;

public class QueueUsingStackLeetcode {

    /** Initialize your data structure here. */
    Stack<Integer> origStack;
    Stack<Integer> tempStack;

    public QueueUsingStackLeetcode() {
        origStack = new Stack<>();
        tempStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!origStack.isEmpty()){
            tempStack.push(origStack.pop());
        }
        origStack.push(x);
        while(!tempStack.isEmpty()){
            origStack.push(tempStack.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(origStack.isEmpty()){
            return -1;
        }else{
            return origStack.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if(origStack.isEmpty()){
            return -1;
        }else{
            return origStack.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return origStack.isEmpty();
    }

}
