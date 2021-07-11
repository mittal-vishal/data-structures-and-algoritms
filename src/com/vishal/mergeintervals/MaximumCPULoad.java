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
        Collections.sort(jobs, (Job a, Job b) -> a.start - b.start);
        PriorityQueue<Job> jobsQueue = new PriorityQueue<>((Job a, Job b) -> a.end - b.end);
        jobsQueue.add(jobs.get(0));
        int maxCpuLoad = 0;
        for(int i = 1; i < jobs.size(); i++){
            if(jobs.get(i).start <= jobsQueue.peek().end){
                jobsQueue.add(jobs.get(i));
            }else{
                int cpuLoad = 0;
                while(!jobsQueue.isEmpty() && jobs.get(i).start > jobsQueue.peek().end){
                    cpuLoad += jobsQueue.poll().cpuLoad;
                }
                jobsQueue.add(jobs.get(i));
                maxCpuLoad = Math.max(cpuLoad, maxCpuLoad);
            }
        }
        int cpuLoad = 0;
        while(!jobsQueue.isEmpty()){
            cpuLoad += jobsQueue.poll().cpuLoad;
        }
        maxCpuLoad = Math.max(cpuLoad, maxCpuLoad);
        return maxCpuLoad;
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

