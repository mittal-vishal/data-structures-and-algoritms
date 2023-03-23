package com.vishal.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadCPU {

    class Task{
        int index;
        int enqueueTime;
        int processingTime;
        public Task(int index, int enqueueTime, int processingTime){
            this.index = index;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }

    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Task[] taskArr = new Task[n];
        for(int i = 0; i < n; i++){
            taskArr[i] = new Task(i, tasks[i][0], tasks[i][1]);
        }
        Arrays.sort(taskArr, (a, b) -> a.enqueueTime - b.enqueueTime);
        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
            if(a.processingTime == b.processingTime){
                return a.index - b.index;
            }else{
                return a.processingTime - b.processingTime;
            }
        });
        int[] result = new int[n];
        int resIndex = 0;
        int currTime = 0;
        int taskIndex = 0;
        while(resIndex < n){
            while(taskIndex < taskArr.length && taskArr[taskIndex].enqueueTime <= currTime){
                pq.offer(taskArr[taskIndex++]);
            }
            if(pq.isEmpty()){
                currTime = taskArr[taskIndex].enqueueTime;
            }else{
                currTime += pq.peek().processingTime;
                result[resIndex++] = pq.peek().index;
                pq.remove();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SingleThreadCPU singleThreadCPU = new SingleThreadCPU();
        int[][] tasks = {{1,2},{2,4},{3,2},{4,1}};
        int[] res = singleThreadCPU.getOrder(tasks);
        for(int i: res){
            System.out.print(i + " ");
        }
    }

}
