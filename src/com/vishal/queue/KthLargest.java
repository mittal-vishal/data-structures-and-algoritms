package com.vishal.queue;

import java.util.PriorityQueue;

public class KthLargest {

	private PriorityQueue<Integer> pq;
	private int limit;

	public KthLargest(int k, int[] nums) {
		pq = new PriorityQueue<>();
		limit = k;
		for(int i = 0; i < nums.length; i++){
			pq.offer(nums[i]);
			if(pq.size() > limit){
				pq.remove();
			}
		}
	}

	public int add(int val) {
		pq.offer(val);
		if(pq.size() > limit){
			pq.remove();
		}
		return pq.peek();
	}


}
