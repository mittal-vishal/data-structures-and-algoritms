package com.vishal.queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueueLeetCode {

    Queue<Integer> origQ;
    Queue<Integer> tempQ;
    /** Initialize your data structure here. */
    public StackUsingQueueLeetCode() {
        origQ = new LinkedList<>();
        tempQ = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        while(!origQ.isEmpty()){
            tempQ.add(origQ.poll());
        }
        origQ.add(x);
        while(!tempQ.isEmpty()){
            origQ.add(tempQ.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(!origQ.isEmpty()){
            return origQ.poll();
        }else{
            return -1;
        }
    }

    /** Get the top element. */
    public int top() {
        return origQ.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return origQ.isEmpty();
    }

}
