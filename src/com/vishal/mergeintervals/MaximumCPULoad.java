package com.vishal.mergeintervals;

import java.util.*;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};

class MaximumCPULoad {

    public static int findMaxCPULoad(List<Job> jobs) {
        if(jobs == null || jobs.size() == 0){
            return 0;
        }
        Collections.sort(jobs, (a,b) -> a.start-b.start);
        PriorityQueue<Job> pq = new PriorityQueue<>((a,b) -> a.end-b.end);
        int currLoadTime = 0;
        int maxLoadTime = 0;
        for(int i = 0; i < jobs.size(); i++){
            Job curr = jobs.get(i);
            while (!pq.isEmpty() && curr.start > pq.peek().end){
                currLoadTime -= pq.peek().cpuLoad;
                pq.remove();
            }
            currLoadTime += curr.cpuLoad;
            maxLoadTime = Math.max(maxLoadTime, currLoadTime);
            pq.offer(curr);
        }
        return maxLoadTime;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}

