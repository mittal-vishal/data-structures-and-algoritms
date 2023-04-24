package com.vishal.google;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class JumpGameIV {

    class Pair{
        int index;
        int jumps;
        Pair(int index, int jumps){
            this.index = index;
            this.jumps = jumps;
        }
    }
    public int minJumps(int[] arr) {
        if(arr == null || arr.length < 2){
            return 0;
        }
        HashMap<Integer, LinkedList<Integer>> elementOccurance = new HashMap<>();
        int n = arr.length;
        for(int i = 0; i < n; i++){
            elementOccurance.putIfAbsent(arr[i], new LinkedList<>());
            elementOccurance.get(arr[i]).add(i);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0,0));
        boolean[] visited = new boolean[n];
        visited[0] = true;
        while(!queue.isEmpty()){
            Pair polled = queue.poll();
            if(polled.index == n-1){
                return polled.jumps;
            }
            LinkedList<Integer> neighbours = elementOccurance.get(arr[polled.index]);
            neighbours.add(polled.index-1);
            neighbours.add(polled.index+1);
            while(neighbours.size() > 0){
                int neighbour = neighbours.poll();
                if(neighbour >= 0 && neighbour < n && !visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(new Pair(neighbour, polled.jumps+1));
                }
            }
        }
        return 0;
    }

}
