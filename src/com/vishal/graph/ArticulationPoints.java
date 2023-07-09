package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class ArticulationPoints {

    private int[] insertionTime;
    private int[] lowestInsertionTime;
    private ArrayList<Integer> result;
    private int timer;
    private boolean[] articulationPoint;

    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        this.insertionTime = new int[V];
        this.lowestInsertionTime = new int[V];
        this.result = new ArrayList<>();
        this.timer = 0;
        this.articulationPoint = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, -1, adj, visited);
            }
        }
        for(int i = 0; i < V; i++){
            if(articulationPoint[i]){
                result.add(i);
            }
        }
        if(result.size() > 0){
            return result;
        }else{
            return new ArrayList<>(Arrays.asList(-1));
        }
    }

    private void dfs(int src, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[src] = true;
        insertionTime[src] = timer;
        lowestInsertionTime[src] = timer;
        timer++;
        int child = 0;
        for(int neighbour: adj.get(src)){
            if(neighbour == parent){
                continue;
            }
            if(!visited[neighbour]){
                dfs(neighbour, src, adj, visited);
                lowestInsertionTime[src] = Math.min(lowestInsertionTime[src], lowestInsertionTime[neighbour]);
                if(parent != -1 && lowestInsertionTime[neighbour] >= insertionTime[src]){
                    articulationPoint[src] = true;
                }
                child++;
            }else{
                lowestInsertionTime[src] = Math.min(lowestInsertionTime[src], insertionTime[neighbour]);
            }
        }
        if(parent == -1 && child > 1){
            articulationPoint[src] = true;
        }
    }

}
