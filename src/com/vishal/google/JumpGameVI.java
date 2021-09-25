package com.vishal.google;

import java.util.PriorityQueue;
import java.util.Queue;

public class JumpGameVI {

    public static int maxResult(int[] nums, int k) {
        if(nums.length == 0){
            return 0;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> b[0] - a[0]);
        pq.offer(new int[]{nums[0], 0});
        int maxScore = nums[0];
        for(int i = 1; i < nums.length; i++){
            //poll the elements from pq, if out of range
            while(pq.peek()[1] + k < i){
                pq.poll();
            }
            int[] currElement = pq.peek();
            maxScore = currElement[0] + nums[i];
            pq.offer(new int[]{maxScore, i});
        }
        return maxScore;
    }

    public static void main(String[] args) {
        int[] nums = {1,-1,-2,4,-7,3};
        int k = 2;
        System.out.print(maxResult(nums, k));
    }

}
