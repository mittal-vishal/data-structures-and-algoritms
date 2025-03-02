package com.vishal.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxProfitInJobScheduling {

    private List<Job> jobs;
    static class Job{
        int start;
        int end;
        int profit;
        public Job(int start, int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        jobs = new ArrayList<>();
        for(int i = 0; i < n; i++){
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        Collections.sort(jobs, (a, b) -> a.start-b.start);
        Integer[] dp = new Integer[n+1];
        return maxProfit(jobs, 0, dp);
    }

    private int maxProfit(List<Job> jobs, int i, Integer[] dp){
        if(i == jobs.size()){
            return 0;
        }else if(dp[i] != null){
            return dp[i];
        }
        int consideredJobEnd = jobs.get(i).end;
        int nextIndex = getNextIndex(i+1, consideredJobEnd);
        int pick = jobs.get(i).profit + maxProfit(jobs,nextIndex, dp);
        int notPick = maxProfit(jobs,i+1, dp);
        return dp[i] = Math.max(pick, notPick);
    }

    private int getNextIndex(int start, int prevJobEnd){
        int beg = start;
        int end = jobs.size()-1;
        int result = jobs.size();
        while(beg <= end){
            int mid = beg + (end-beg)/2;
            if(jobs.get(mid).start >= prevJobEnd){
                result = mid;
                end = mid-1;
            }else{
                beg = mid+1;
            }
        }
        return result;
    }

}
