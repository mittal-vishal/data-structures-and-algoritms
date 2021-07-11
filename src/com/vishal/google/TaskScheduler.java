package com.vishal.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0){
            return 0;
        }
        if(n == 0){
            return tasks.length;
        }
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(char task: tasks){
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }
        PriorityQueue<Integer> taskQueue = new PriorityQueue<>((a, b) -> b-a );
        taskQueue.addAll(freqMap.values());

        int cycles = 0;

        while(!taskQueue.isEmpty()){
            ArrayList<Integer> cycleTaskList = new ArrayList<>();
            for(int i = 0; i < n + 1; i++){
                if(!taskQueue.isEmpty()){
                    cycleTaskList.add(taskQueue.poll());
                }
            }
            for(int taskFreq: cycleTaskList){
                if(--taskFreq > 0){
                    taskQueue.add(taskFreq);
                }
            }
            cycles += taskQueue.isEmpty() ? cycleTaskList.size() : n + 1;
        }

        return cycles;

    }

}
