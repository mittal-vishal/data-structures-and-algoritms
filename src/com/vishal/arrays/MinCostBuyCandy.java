package com.vishal.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MinCostBuyCandy {

    public int minimumCost(int[] cost) {
        List<Integer> candies = Arrays.stream(cost)
                .boxed().collect(Collectors.toList());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);
        pq.addAll(candies);
        int minCost = 0;
        while(!pq.isEmpty()){
            minCost += pq.poll();
            minCost += !pq.isEmpty() ? pq.poll(): 0;
            if(!pq.isEmpty()){
                pq.poll();
            }
        }
        return minCost;
    }

}
