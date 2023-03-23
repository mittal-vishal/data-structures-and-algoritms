package com.vishal.heap;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.AbstractMap.SimpleEntry;

class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Map.Entry<Integer, Integer>> capitalQueue = new PriorityQueue<>((a,b) -> a.getValue()-b.getValue());
        PriorityQueue<Map.Entry<Integer, Integer>> profitQueue = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        int n = profits.length;
        for(int i = 0; i < n; i++){
            capitalQueue.offer(new SimpleEntry<Integer, Integer>(i, capital[i]));
        }
        int maxProfit = 0;
        int capitalValue = w;
        for(int i = 0; i < k; i++){
            while(!capitalQueue.isEmpty() && capitalQueue.peek().getValue() <= capitalValue){
                profitQueue.offer(new SimpleEntry<Integer, Integer>(capitalQueue.peek().getKey(), profits[capitalQueue.peek().getKey()]));
                capitalQueue.remove();
            }
            capitalValue += profitQueue.isEmpty()? 0: profitQueue.poll().getValue();
        }
        return capitalValue;
    }
}
