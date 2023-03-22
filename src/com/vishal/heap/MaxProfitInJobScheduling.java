package com.vishal.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaxProfitInJobScheduling {

    class Job{
        int start;
        int end;
        int profit;
        public Job(int start, int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    class Solution {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            List<Job> jobs = new ArrayList<>();
            for(int i = 0; i < startTime.length; i++){
                jobs.add(new Job(startTime[i], endTime[i], profit[i]));
            }
            Collections.sort(jobs, (a, b) -> a.start - b.start);
            int result = 0;
            PriorityQueue<Job> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
            int maxProfit = 0;
            for(int i = 0; i < startTime.length; i++){
                int currJobStart = jobs.get(i).start;
                int currJobEnd = jobs.get(i).end;
                int currJobProfit = jobs.get(i).profit;
                while(!pq.isEmpty() && currJobStart >= pq.peek().end){
                    maxProfit = Math.max(maxProfit, pq.peek().profit);
                    pq.remove();
                }
                maxProfit += currJobProfit;
                pq.offer(new Job(currJobStart, currJobEnd, maxProfit));
            }
            while(!pq.isEmpty()){
                maxProfit = Math.max(maxProfit, pq.peek().profit);
                pq.poll();
            }
            return maxProfit;
        }
    }

}
