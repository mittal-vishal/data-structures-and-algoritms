package com.vishal.stack;

import java.util.Arrays;

public class KStack {

    private int[] stack;
    private int[] top;
    private int[] next;
    private int freeSpot;

    public KStack(int capacity, int k){
        stack = new int[capacity];
        top = new int[k];
        next = new int[capacity];
        Arrays.fill(top, -1);
        for(int i = 0; i < capacity - 1; i++){
            next[i] = i+1;
        }
        next[capacity - 1] = -1;
        freeSpot = 0;
    }

    private void push(int item, int n){
        if(freeSpot == -1){
            System.out.println("Overflow");
            return;
        }
        int index = freeSpot;
        stack[index] = item;
        freeSpot = next[index];
        next[index] = top[n-1];
        top[n-1] = index;
    }

    private int pop(int n){
        if(top[n-1] == -1){
            System.out.println("Underflow");
            return -1;
        }
        int index = top[n-1];
        top[n-1] = next[index];
        next[index] = freeSpot;
        freeSpot = index;
        return stack[index];
    }

}
