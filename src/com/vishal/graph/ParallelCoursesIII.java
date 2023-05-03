package com.vishal.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParallelCoursesIII {

    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] relation: relations){
            graph.get(relation[0]).add(relation[1]);
        }
        int[] indegree = new int[n+1];
        for(int i = 1; i <= n; i++){
            for(int neighbour: graph.get(i)){
                indegree[neighbour]++;
            }
        }
        int[] maxTime = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
                maxTime[i] = time[i-1];
            }
        }
        int result = 0;
        while(!queue.isEmpty()){
            int maxParallelTime = 0;
            int curr = queue.poll();
            maxParallelTime = Math.max(maxParallelTime, time[curr-1]);
            for(int neighbour: graph.get(curr)){
                indegree[neighbour]--;
                maxTime[neighbour] = Math.max(maxTime[neighbour], maxTime[curr] + time[neighbour-1]);
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
            result = Math.max(result, maxTime[curr]);
        }
        return result;
    }

}
