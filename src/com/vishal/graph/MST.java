package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MST {

    static class GraphNode{
        int node;
        int cost;
        public GraphNode(int node, int cost){
            this.node = node;
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
            int wt = edge[2];
            graph.get(u).add(new GraphNode(v,wt));
            graph.get(v).add(new GraphNode(u,wt));
        }
        PriorityQueue<GraphNode> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);
        pq.offer(new GraphNode(0, 0));
        int result = 0;
        boolean[] visited = new boolean[V];
        while(!pq.isEmpty()){
            GraphNode curr = pq.poll();
            if(visited[curr.node]){
                continue;
            }
            visited[curr.node] = true;
            result += curr.cost;
            for(GraphNode neighbour: graph.get(curr.node)){
                if(!visited[neighbour.node]){
                    pq.offer(neighbour);
                }
            }
        }
        return result;
    }

}
