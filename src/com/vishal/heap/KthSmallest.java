package com.vishal.heap;

import java.util.PriorityQueue;

public class KthSmallest {

    public static int findKthSmallestNumber(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);
        for(int i = 0; i < nums.length; i++){
            if(i < k){
                maxHeap.offer(nums[i]);
            }else{
                if(nums[i] < maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.offer(nums[i]);
                }
            }
        }
        return maxHeap.peek();
    }

}
