package com.vishal.heap;

import java.util.PriorityQueue;

class CapitalPair{
    int cap;
    int index;
    public CapitalPair(int cap, int index){
        this.cap = cap;
        this.index = index;
    }
}
class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if(w < 0){
            return 0;
        }
        PriorityQueue<Integer> maxProfitQueue = new PriorityQueue<>((a, b) -> b-a);
        PriorityQueue<CapitalPair> minCapQueue = new PriorityQueue<>((a,b) -> a.cap - b.cap);

        //Push all capital price in minCap queue
        for(int i = 0; i < capital.length; i++){
            minCapQueue.offer(new CapitalPair(capital[i], i));
        }

        int maxRetCap = w;
        for(int i = 0; i < k; i++){
            while(!minCapQueue.isEmpty() && maxRetCap >= minCapQueue.peek().cap){
                maxProfitQueue.offer(profits[minCapQueue.poll().index]);
            }
            maxRetCap += !maxProfitQueue.isEmpty() ? maxProfitQueue.poll() : 0;
        }
        return maxRetCap;
    }
}
