package com.vishal.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinOperations {

    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        Set<Integer> visited = new HashSet<>();
        int operations = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int polled = queue.poll();
                if(polled == goal){
                    return operations;
                }
                if(polled >= 0 && polled <= 1000 && !visited.contains(polled)){
                    visited.add(polled);
                    for(int j = 0; j < nums.length; j++){
                        queue.offer(polled + nums[j]);
                        queue.offer(polled - nums[j]);
                        queue.offer(polled ^ nums[j]);
                    }
                }
            }
            operations++;
        }
        return -1;
    }

}
