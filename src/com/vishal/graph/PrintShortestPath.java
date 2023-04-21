package com.vishal.graph;

import java.util.*;

public class PrintShortestPath {

    static class GraphNode{
        int node;
        int cost;
        GraphNode(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        List<List<GraphNode>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            graph.get(u).add(new GraphNode(v, cost));
            graph.get(v).add(new GraphNode(u, cost));
        }
        PriorityQueue<GraphNode> pq = new PriorityQueue<>((a, b) -> a.cost-b.cost);
        pq.offer(new GraphNode(1, 0));
        int[] parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        while(!pq.isEmpty()){
            GraphNode polled = pq.poll();
            for(GraphNode neighbour: graph.get(polled.node)){
                if(dist[neighbour.node] > (dist[polled.node] + neighbour.cost)){
                    dist[neighbour.node] = dist[polled.node] + neighbour.cost;
                    parent[neighbour.node] = polled.node;
                    pq.offer(new GraphNode(neighbour.node, dist[neighbour.node]));
                }
            }
        }
        if(dist[n] == Integer.MAX_VALUE){
            return new ArrayList<>(Arrays.asList(-1));
        }
        List<Integer> paths = new ArrayList<>();
        int node = n;
        while(parent[node] != node){
            paths.add(node);
            node = parent[node];
        }
        paths.add(1);
        Collections.reverse(paths);
        return paths;
    }

}
