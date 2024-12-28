package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfCompleteComponent {

    private int nodeCount;
    private int edgeCount;

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        int completeComp = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                nodeCount = 0;
                edgeCount = 0;
                dfs(i, graph, visited);
                if(((nodeCount*(nodeCount-1))/2) == (edgeCount/2)){
                    completeComp++;
                }
            }
        }
        return completeComp;
    }

    private void dfs(int src, List<List<Integer>> graph, boolean[] visited){
        if(visited[src]){
            return;
        }
        visited[src] = true;
        nodeCount++;
        for(int neighbour: graph.get(src)){
            edgeCount++;
            dfs(neighbour, graph, visited);
        }
    }

}
