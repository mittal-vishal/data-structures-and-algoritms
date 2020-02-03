package com.vishal.heap;

import java.util.PriorityQueue;

public class MinCostRopes {

	public static void main(String[] args) {
		int cost[] = { 4, 2, 7, 6, 9 };
		System.out.println(find(cost));
	}

	private static int find(int[] cost) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int firstRope = -1;
		int secondRope = -1;
		int totalCost = 0;
		for (int i = 0; i < cost.length; i++) {
			pq.add(cost[i]);
		}
		while (!pq.isEmpty()) {
			firstRope = pq.poll();
			secondRope = pq.poll();
			totalCost = totalCost + firstRope + secondRope;
			if (!pq.isEmpty()) {
				pq.add(firstRope + secondRope);
			}
		}
		return totalCost;
	}

}
