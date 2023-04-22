package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class ConnectingCitiesWithMinCost {

    class Route{
        int src;
        int node;
        int cost;
        public Route(int src, int node, int cost){
            this.src = src;
            this.node = node;
            this.cost = cost;
        }
    }
    public int minimumCost(int n, int[][] connections) {
        List<List<Route>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] connection: connections){
            int u = connection[0];
            int v = connection[1];
            int cost = connection[2];
            graph.get(u).add(new Route(u,v,cost));
            graph.get(v).add(new Route(v,u,cost));
        }
        PriorityQueue<Route> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);
        pq.offer(new Route(-1, 1, 0));
        int cost = 0;
        int relax = 0;
        boolean[] visited = new boolean[n+1];
        while(!pq.isEmpty()){
            Route polled = pq.poll();
            if(visited[polled.node]){
                continue;
            }
            visited[polled.node] = true;
            cost += polled.cost;
            relax++;
            for(Route neighbour: graph.get(polled.node)){
                if(!visited[neighbour.node]){
                    pq.offer(neighbour);
                }
            }
        }
        return relax == n? cost: -1;
    }
}