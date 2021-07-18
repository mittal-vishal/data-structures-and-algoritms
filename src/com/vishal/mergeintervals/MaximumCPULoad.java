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
        Collections.sort(jobs, (Job a, Job b) -> a.start - b.start);
        PriorityQueue<Job> jobQueue = new PriorityQueue<>((Job a, Job b) -> a.end - b.end);
        int currentLoad = 0, maxLoad = 0;
        for(int i = 0; i < jobs.size(); i++){
            currentLoad += jobs.get(i).cpuLoad;
            jobQueue.offer(jobs.get(i));
            while(jobs.get(i).start > jobQueue.peek().end && (!jobQueue.isEmpty())){
                currentLoad -= jobQueue.poll().cpuLoad;
            }
            maxLoad = Math.max(maxLoad, currentLoad);
        }
        return maxLoad;
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

