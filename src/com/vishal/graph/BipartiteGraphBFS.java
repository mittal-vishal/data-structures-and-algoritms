package com.vishal.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphBFS {

    public boolean isBipartite(int[][] graph) {
        if(graph == null || graph.length == 0){
            return true;
        }
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for(int i = 0; i < graph.length; i++){
            if(graph[i].length > 0 && colors[i] == -1){
                if(!bfs(graph, i, colors)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int[][] graph, int src, int[] colors){
        Queue<Integer> queue = new LinkedList<>();
        colors[src] = 0;
        queue.offer(src);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                int polled = queue.poll();
                for(int neighbour: graph[polled]){
                    if(colors[neighbour] == -1){
                        colors[neighbour] = colors[polled] == 0 ? 1: 0;
                        queue.offer(neighbour);
                    }else if(colors[neighbour] != -1 && colors[neighbour] == colors[polled]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
