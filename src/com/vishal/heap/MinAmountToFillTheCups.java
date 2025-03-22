package com.vishal.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinAmountToFillTheCups {

    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        for(int i = 0; i < amount.length; i++){
            pq.offer(amount[i]);
        }
        int time = 0;
        List<Integer> temp = new ArrayList<>();
        while(!pq.isEmpty()){
            int size = pq.size();
            boolean isConsumed = false;
            for(int i = 0; i < Math.min(2, size) && !pq.isEmpty(); i++){
                int currCapacity = pq.poll();
                if(currCapacity == 0){
                    continue;
                }
                isConsumed = true;
                if(--currCapacity > 0){
                    temp.add(currCapacity);
                }
            }
            for(int unit: temp){
                pq.offer(unit);
            }
            if(isConsumed){
                time++;
            }
            temp.clear();
        }
        return time;
    }

}
