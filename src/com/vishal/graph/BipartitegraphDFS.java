package com.vishal.graph;

import java.util.Arrays;

public class BipartitegraphDFS {

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for(int i = 0; i < n; i++){
            if(colors[i] == -1 && !isBipartite(graph, i, 0, colors)){
                return false;
            }
        }
        return true;
    }

    private boolean isBipartite(int[][] graph, int src, int color, int[] colors){
        colors[src] = color;
        int toBeColored = color == 0? 1: 0;
        for(int neighbour: graph[src]){
            if(colors[neighbour] == -1 && !isBipartite(graph, neighbour, toBeColored, colors)){
                return false;
            }else if(colors[neighbour] != -1 && colors[neighbour] == color){
                return false;
            }
        }
        return true;
    }

}
