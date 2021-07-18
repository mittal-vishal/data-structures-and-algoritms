package com.vishal.google;

import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0){
            return 0;
        }

        Map<Character, Integer> taskFreqMap = new HashMap<>();
        for(char task: tasks){
            taskFreqMap.put(task, taskFreqMap.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> taskQueue = new PriorityQueue<>((a, b) -> b - a);
        taskQueue.addAll(taskFreqMap.values());
        List<Integer> taskList = null;
        int unit = 0;
        while(!taskQueue.isEmpty()){
            taskList = new ArrayList<>();
            for(int i = 0; i < n+1 && (!taskQueue.isEmpty()); i++){
                taskList.add(taskQueue.poll());
            }
            for(int freq: taskList){
                if(--freq > 0){
                    taskQueue.offer(freq);
                }
            }
            unit += ((!taskQueue.isEmpty()) ? (n + 1) : (taskList.size()));
        }
        return unit;

    }

}
