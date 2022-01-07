package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class ConnectingCitiesWithMinCost {

    public static void main(String[] args) {
        int[][] connections= {{1,2,5},{1,3,6},{2,3,1}};
        int n = 3;
        ConnectingCitiesWithMinCost minCost = new ConnectingCitiesWithMinCost();
        System.out.println(minCost.minimumCost(n, connections));
    }

    static class Route{
        int src;
        int dest;
        int cost;
        public Route(int src, int dest, int cost){
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }

    public int minimumCost(int n, int[][] connections) {
        if(n == 0 || connections == null || connections.length == 0){
            return -1;
        }
        List<List<Route>> adjList = new ArrayList<>();
        //build graph
        buildGraph(adjList, connections, n);
        boolean[] visited = new boolean[n];
        PriorityQueue<Route> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        pq.offer(new Route(-1, 0, 0));
        int minCost = 0;
        int totalCity = 0;
        while(!pq.isEmpty()){
            Route curr = pq.poll();
            if(visited[curr.dest]){
                continue;
            }
            totalCity++;
            visited[curr.dest] = true;
            minCost += curr.cost;
            for(Route neighbour: adjList.get(curr.dest)){
                if(!visited[neighbour.dest]){
                    pq.offer(new Route(curr.dest, neighbour.dest, neighbour.cost));
                }
            }
        }
        return totalCity != n ? -1: minCost;
    }

    private void buildGraph(List<List<Route>> adjList, int[][] connections, int n){
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] connection: connections){
            adjList.get(connection[0] - 1).add(new Route(connection[0] - 1, connection[1] - 1, connection[2]));
            adjList.get(connection[1] - 1).add(new Route(connection[1] - 1, connection[0] - 1, connection[2]));
        }
    }
}