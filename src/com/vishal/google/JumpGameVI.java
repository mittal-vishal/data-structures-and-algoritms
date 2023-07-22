package com.vishal.google;

import java.util.PriorityQueue;
import java.util.Queue;

public class JumpGameVI {

    public static void main(String[] args) {
        int[] arr = {1,-1,-2,4,-7,3};
        int k = 2;
        JumpGameVI jumpGame = new JumpGameVI();
        int result = jumpGame.maxResult(arr, k);
        System.out.println(result);
    }

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
