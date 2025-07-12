package com.vishal.slidingwindowcounting;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowCounting {

    private int maxRequest;
    private int windowSizeInMs;
    private Deque<Long> requestTs;

    public SlidingWindowCounting(int maxRequest, int windowSizeInMs){
        this.maxRequest = maxRequest;
        this.requestTs = new ArrayDeque<>();
        this.windowSizeInMs = windowSizeInMs;
    }

    public synchronized boolean tryConsume(){
        //clear invalid entry from requestTs
        long currentTs = System.currentTimeMillis();
        while(!requestTs.isEmpty() && (currentTs - requestTs.peekFirst()) >= windowSizeInMs){
            requestTs.pollFirst();
        }
        if(requestTs.size() < maxRequest){
            requestTs.offerLast(currentTs);
            return true;
        }
        return false;
    }

}
