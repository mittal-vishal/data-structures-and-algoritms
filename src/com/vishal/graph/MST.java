package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MST {

    static class GraphNode{
        int node;
        int parent;
        int cost;
        GraphNode(int node, int parent, int cost){
            this.node = node;
            this.parent = parent;
            this.cost = cost;
        }
    }
    static int spanningTree(int V, int E, int edges[][]){
        List<List<GraphNode>> graph = new ArrayList<>();
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            graph.get(u).add(new GraphNode(v, u, cost));
            graph.get(v).add(new GraphNode(u, v, cost));
        }
        PriorityQueue<GraphNode> pq = new PriorityQueue<>((a, b) -> a.cost- b.cost);
        pq.offer(new GraphNode(0, -1, -1));
        int cost = 0;
        boolean[] visited = new boolean[V];
        while(!pq.isEmpty()){
            GraphNode polled = pq.poll();
            if(visited[polled.node]){
                continue;
            }
            visited[polled.node] = true;
            if(polled.parent != -1){
                cost += polled.cost;
            }
            for(GraphNode neighbour: graph.get(polled.node)){
                if(!visited[neighbour.node]){
                    pq.offer(neighbour);
                }
            }
        }
        return cost;
    }

}
