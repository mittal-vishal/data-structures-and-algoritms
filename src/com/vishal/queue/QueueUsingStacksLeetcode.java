package com.vishal.queue;

import java.util.Stack;

public class QueueUsingStacksLeetcode {

    /** Initialize your data structure here. */
    Stack<Integer> stackNewer;
    Stack<Integer> stackOldest;

    public QueueUsingStacksLeetcode() {
        stackNewer = new Stack<>();
        stackOldest = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackNewer.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        shiftStacks();
        return stackOldest.pop();
    }

    public void shiftStacks(){
        if(stackOldest.isEmpty()){
            while(!stackNewer.isEmpty()){
                stackOldest.push(stackNewer.pop());
            }
        }
    }

    /** Get the front element. */
    public int peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackOldest.isEmpty() && stackNewer.isEmpty();
    }

}
