package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class NumberOfWaysReachTopStairWithMinCost {

	public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(minCost(cost.length, 0, cost, memo), minCost(cost.length, 1, cost, memo));
    }
    
    private int minCost(int end, int start, int[] cost, int[] memo) {
		if (start == end - 1) {
			return cost[start];
		} else if (start >= end) {
			return 0;
		} else if(memo[start] != -1){
            return memo[start];
        }else {
			memo[start] = cost[start] + Math.min(minCost(end, start + 1, cost, memo), minCost(end, start + 2, cost, memo));
            return memo[start];
		}
	}

}
