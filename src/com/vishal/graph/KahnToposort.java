package com.vishal.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnToposort {

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            List<Integer> neighbours = adj.get(i);
            for(int j = 0; j < neighbours.size(); j++){
                indegree[neighbours.get(j)]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int[] result = new int[V];
        int index = 0;
        while(!queue.isEmpty()){
            int polled = queue.poll();
            result[index++] = polled;
            for(int neighbour: adj.get(polled)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
        return result;
    }

}
