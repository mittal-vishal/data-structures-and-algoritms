package com.vishal.queue;

import java.util.LinkedList;
import java.util.Queue;

public class TimeTakenToCrossTheDoor {

    public int[] timeTaken(int[] arrival, int[] state) {
        Queue<Integer> entryQueue = new LinkedList<>();
        Queue<Integer> exitQueue = new LinkedList<>();
        int n = state.length;
        for(int i = 0; i < n; i++){
            if(state[i] == 0){
                entryQueue.offer(i);
            }else{
                exitQueue.offer(i);
            }
        }
        int prev = 1;
        int time = 0;
        int[] result = new int[n];
        while(!entryQueue.isEmpty() && !exitQueue.isEmpty()){
            //If both come at same time, honor based on Ist and 2nd cond
            if(arrival[entryQueue.peek()] <= time && arrival[exitQueue.peek()] <= time){
                if(prev == 1){
                    int person = exitQueue.poll();
                    result[person] = time;
                }else{
                    int person = entryQueue.poll();
                    result[person] = time;
                }
            }else if(arrival[entryQueue.peek()] <= time && arrival[exitQueue.peek()] > time){
                int person = entryQueue.poll();
                result[person] = time;
                prev = 0;
            }else if(arrival[exitQueue.peek()] <= time && arrival[entryQueue.peek()] > time){
                int person = exitQueue.poll();
                result[person] = time;
                prev = 1;
            }else{
                prev = 1;
            }
            //at the end, incr the time
            time++;
        }
        while(!entryQueue.isEmpty()){
            int person = entryQueue.poll();
            result[person] = Math.max(time, arrival[person]);
            time = Math.max(time, arrival[person]) + 1;
        }
        while(!exitQueue.isEmpty()){
            int person = exitQueue.poll();
            result[person] = Math.max(time, arrival[person]);
            time = Math.max(time, arrival[person]) + 1;
        }
        return result;
    }

}
