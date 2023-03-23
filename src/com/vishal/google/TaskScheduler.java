package com.vishal.google;

import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> charOccurances = new HashMap<>();
        for(int i = 0; i < tasks.length; i++){
            char currChar = tasks[i];
            charOccurances.put(currChar, charOccurances.getOrDefault(currChar, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        pq.addAll(charOccurances.values());
        int units = 0;
        while(!pq.isEmpty()){
            List<Integer> queue = new ArrayList<>();
            for(int i = 0; i < n+1; i++){
                if(!pq.isEmpty()){
                    queue.add(pq.poll());
                }
            }
            for(int unit: queue){
                if(--unit > 0){
                    pq.offer(unit);
                }
            }
            units += pq.isEmpty()? queue.size(): n+1;
        }
        return units;
    }

}
