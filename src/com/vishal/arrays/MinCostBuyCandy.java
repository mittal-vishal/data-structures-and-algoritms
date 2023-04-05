package com.vishal.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MinCostBuyCandy {

    public int minimumCost(int[] cost) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        List<Integer> costs = Arrays.stream(cost).boxed().collect(Collectors.toList());
        pq.addAll(costs);
        int minCost = 0;
        while(!pq.isEmpty()){
            minCost += pq.poll();
            minCost += pq.isEmpty()? 0: pq.poll();
            if(!pq.isEmpty()){
                pq.poll();
            }
        }
        return minCost;
    }

}
