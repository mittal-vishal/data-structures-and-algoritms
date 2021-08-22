package com.vishal.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopKElements {

    public static List<Integer> findKLargestNumbers(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++){
            if(i < k){
                pq.offer(nums[i]);
            }else{
                if(nums[i] > pq.peek()){
                    pq.poll();
                    pq.offer(nums[i]);
                }
            }
        }
        return new ArrayList<>(pq);
    }

}
