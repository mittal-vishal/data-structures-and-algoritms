package com.vishal.heap;

import java.util.PriorityQueue;

public class ConnectRopes {

    public static int minimumCostToConnectRopes(int[] ropeLengths) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i < ropeLengths.length; i++){
            minHeap.offer(ropeLengths[i]);
        }
        int cost = 0;
        while(minHeap.size() > 1){
            int ropeA = minHeap.poll();
            int ropeB = minHeap.poll();
            cost += (ropeA+ropeB);
            minHeap.offer(ropeA+ropeB);
        }
        return cost;
    }

}
