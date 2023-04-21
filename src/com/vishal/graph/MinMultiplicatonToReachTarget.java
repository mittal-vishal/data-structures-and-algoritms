package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MinMultiplicatonToReachTarget {

    private int MOD = 100000;

    int minimumMultiplications(int[] arr, int start, int end) {
        boolean[] visited = new boolean[100000];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int polled = queue.poll();
                if(polled == end){
                    return steps;
                }
                for(int num: arr){
                    int neighbour = (polled*num) % MOD;
                    if(!visited[neighbour]){
                        visited[neighbour] = true;
                        queue.offer(neighbour);
                    }
                }
            }
            steps++;
        }
        return -1;
    }


}
