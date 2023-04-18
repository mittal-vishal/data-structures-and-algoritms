package com.vishal.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBFS {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for(int i = 0; i < n; i++){
            if(colors[i] == -1 && !isBipartite(graph, colors, i)){
                return false;
            }
        }
        return true;
    }

    private boolean isBipartite(int[][] graph, int[] colors, int src){

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        colors[src] = 0;
        while(!queue.isEmpty()){
            int polled = queue.poll();
            int currNodeColor = colors[polled];
            for(int neighbour: graph[polled]){
                //not visited
                if(colors[neighbour] == -1){
                    colors[neighbour] = currNodeColor == 0? 1: 0;
                    queue.offer(neighbour);
                }else if(colors[neighbour] == colors[polled]){
                    return false;
                }
            }
        }
        return true;
    }

}
