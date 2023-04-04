package com.vishal.heap;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(int i = 0; i < stones.length; i++){
            pq.offer(stones[i]);
        }
        while(!pq.isEmpty() && pq.size() != 1){
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if(Math.abs(stone1-stone2) > 0){
                pq.offer(Math.abs(stone1-stone2));
            }
        }
        return pq.isEmpty()? 0: pq.peek();
    }

}
