package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int[] currEdge = edges[i];
            adjList.get(currEdge[0]).add(currEdge[1]);
            adjList.get(currEdge[1]).add(currEdge[0]);
        }
        boolean[] visited = new boolean[n];
        boolean isCycle = hasCycle(adjList, 0, -1, visited);
        for(int i = 0; i < visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        if(!isCycle){
            return true;
        }else{
            return false;
        }
    }

    private boolean hasCycle(List<List<Integer>> adjList, int src, int parent, boolean[] visited){
        visited[src] = true;

        for (int adj: adjList.get(src)) {

            if ((visited[adj] && parent != adj) || (!visited[adj] && hasCycle(adjList, adj, src, visited))){
                return true;
            }
        }

        return false;
    }

}
