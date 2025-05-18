package com.vishal.queue;

import java.util.Arrays;

public class CircularQueue {

    private int[] queue;
    private int rear;
    private int front;
    private int size;

    public CircularQueue(int k) {
        queue = new int[k];
        Arrays.fill(queue, -1);
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            rear = 0;
            front = 0;
            queue[rear] = value;
            size++;
            return true;
        }
        rear++;
        size++;
        rear = rear % queue.length;
        queue[rear] = value;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        queue[front] = -1;
        front++;
        front = front % queue.length;
        size--;
        return true;
    }

    public int Front() {
        return queue[front];
    }

    public int Rear() {
        return queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == queue.length;
    }

}
