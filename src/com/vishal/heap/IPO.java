package com.vishal.heap;

import java.util.PriorityQueue;

class Capital{
    int cap;
    int index;
    public Capital(int cap, int index){
        this.cap = cap;
        this.index = index;
    }
}
class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if(w < 0){
            return 0;
        }
        PriorityQueue<Capital> capitalQueue = new PriorityQueue<>((a,b) -> a.cap-b.cap);
        PriorityQueue<Integer> profitQueue = new PriorityQueue<>((a,b) -> b-a);
        //put all capital in capital queue to get minimum capital
        for(int i = 0; i < capital.length; i++){
            capitalQueue.offer(new Capital(capital[i], i));
        }
        //for K transaction, maximize the profit with existing initial capital
        int maxCap = w;
        for(int i = 0; i < k; i++){
            while(!capitalQueue.isEmpty() && maxCap >= capitalQueue.peek().cap){
                Capital leastCap = capitalQueue.poll();
                profitQueue.add(profits[leastCap.index]);
            }
            maxCap += !profitQueue.isEmpty() ? profitQueue.poll(): 0;
        }
        return maxCap;
    }
}
