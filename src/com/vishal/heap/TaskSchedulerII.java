package com.vishal.heap;

import java.util.HashMap;

public class TaskSchedulerII {

    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer, Long> taskDays = new HashMap<>();
        long day = 1l;
        for(int i = 0; i < tasks.length; i++){
            if(!taskDays.containsKey(tasks[i])){
                taskDays.put(tasks[i], day);
            }else{
                long rest = (space+1) - (day-taskDays.get(tasks[i])) < 0 ? 0 : (space+1) - (day-taskDays.get(tasks[i]));
                day += rest;
                taskDays.put(tasks[i], day);
            }
            if(i < tasks.length-1){
                day++;
            }
        }
        return day;
    }

}
