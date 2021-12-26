package com.vishal.graph;

import java.util.Arrays;

public class BipartitegraphDFS {

    public boolean isBipartite(int[][] graph) {
        if(graph == null || graph.length == 0){
            return true;
        }
        int nodes = graph.length;
        int[] colors = new int[nodes];
        Arrays.fill(colors, -1);
        for(int i = 0; i < nodes; i++){
            if(colors[i] == -1 && graph[i].length > 0){
                if(!dfs(graph, colors, i, -1)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int src, int parent){
        if(colors[src] != -1 && colors[src] == colors[parent]){
            return false;
        }
        if(colors[src] == -1){
            if(parent == -1 || colors[parent] == 1){
                colors[src] = 0;
            }else{
                colors[src] = 1;
            }
            for(int neighbour: graph[src]){
                if(!dfs(graph, colors, neighbour, src)){
                    return false;
                }
            }
        }
        return true;
    }

}
