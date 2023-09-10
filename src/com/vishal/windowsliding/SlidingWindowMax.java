package com.vishal.windowsliding;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int index = 0;
        int n = nums.length;
        int[] res = new int[n-k+1];
        for(int i = 0; i < n; i++){
            //remove out of bound elements from front of deque
            if(!dq.isEmpty() && dq.getFirst() == i-k){
                dq.pollFirst();
            }
            //remove element if lesser than current elements from back of deque
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i >= k-1){
                res[index++] = nums[dq.getFirst()];
            }
        }
        return res;
    }

}
