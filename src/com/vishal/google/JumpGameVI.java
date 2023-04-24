package com.vishal.google;

import java.util.PriorityQueue;
import java.util.Queue;

public class JumpGameVI {

    class Pair{
        int index;
        int score;
        Pair(int index, int score){
            this.index = index;
            this.score = score;
        }
    }

    public int maxResult(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.score-a.score);
        pq.offer(new Pair(0,nums[0]));
        int maxScore = nums[0];
        for(int i = 1; i < nums.length; i++){
            while(!pq.isEmpty() && (i-pq.peek().index) > k){
                pq.poll();
            }
            maxScore = nums[i] + pq.peek().score;
            pq.offer(new Pair(i, maxScore));
        }
        return maxScore;
    }

}
