package com.vishal.heap;

import java.util.PriorityQueue;

class KthLargestInStream {

    private PriorityQueue<Integer> pq;
    private int capacity;

    public KthLargestInStream(int k, int[] nums) {
        pq = new PriorityQueue<>();
        capacity = k;
        for(int i = 0; i < nums.length; i++){
            if(i < capacity){
                pq.offer(nums[i]);
            }else if(nums[i] > pq.peek()){
                pq.poll();
                pq.offer(nums[i]);
            }
        }
    }

    public int add(int val) {
        if(pq.size() < capacity){
            pq.offer(val);
        }else{
            if(val > pq.peek()){
                pq.poll();
                pq.offer(val);
            }
        }
        return pq.peek();
    }
}