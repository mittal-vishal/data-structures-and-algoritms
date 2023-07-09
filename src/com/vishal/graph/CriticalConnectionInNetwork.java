package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionInNetwork {

    private int[] insertionTime;
    private int[] lowestInsertionTime;
    private List<List<Integer>> result;
    private int timer;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        boolean[] visited = new boolean[n];
        this.insertionTime = new int[n];
        this.lowestInsertionTime = new int[n];
        this.result = new ArrayList<>();
        this.timer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(List<Integer> connection: connections){
            int u = connection.get(0);
            int v = connection.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, -1, graph, visited);
            }
        }
        return result;
    }

    private void dfs(int src, int parent, List<List<Integer>> graph, boolean[] visited){
        visited[src] = true;
        insertionTime[src] = timer;
        lowestInsertionTime[src] = timer;
        timer++;
        for(int neighbour: graph.get(src)){
            if(neighbour == parent){
                continue;
            }
            if(!visited[neighbour]){
                dfs(neighbour, src, graph, visited);
                lowestInsertionTime[src] = Math.min(lowestInsertionTime[src], lowestInsertionTime[neighbour]);
                //check for bridge
                if(lowestInsertionTime[neighbour] > insertionTime[src]){
                    result.add(Arrays.asList(src, neighbour));
                }
            }else{
                lowestInsertionTime[src] = Math.min(lowestInsertionTime[src], lowestInsertionTime[neighbour]);
            }
        }
    }

}
