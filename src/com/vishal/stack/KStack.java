package com.vishal.stack;

import java.util.Arrays;

public class KStack {

    int[] stack;
    int[] top;
    int[] next;
    int free;
    int k;

    public KStack(int size, int k){
        stack = new int[size];
        this.k = k;
        free = 0;
        top = new int[k];
        next = new int[size];
        Arrays.fill(top, -1);
        for(int i = 0; i < (size - 1); i++){
            next[i] = i + 1;
        }
        next[size - 1] = -1;
    }

    public void push(int item, int n){
        if(next[free] == -1){
            System.out.println("Overflow");
        }
        int i = free;
        free = next[free];
        next[i] = top[n - 1];
        top[n - 1] = i;
        stack[free] = item;
    }

    public int pop(int n){
        int i = top[n - 1];
        top[n - 1] = next[i];
        next[i] = free;
        free = i;
        return stack[i];
    }

}
