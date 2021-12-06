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

    public static class Route{
        int srcCity;
        int city;
        int cost;
        public Route(int srcCity, int city, int cost){
            this.srcCity = srcCity;
            this.city = city;
            this.cost = cost;
        }
    }

    public int minimumCost(int n, int[][] connections) {
        List<List<Route>> inputRouteList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            inputRouteList.add(new ArrayList<>());
        }
        for(int i = 0; i < connections.length; i++){
            int[] connection = connections[i];
            inputRouteList.get(connection[0] - 1).add(new Route(connection[0] - 1, connection[1] - 1, connection[2]));
            inputRouteList.get(connection[1] - 1).add(new Route(connection[1] - 1, connection[0] - 1, connection[2]));
        }

        PriorityQueue<Route> pq = new PriorityQueue<>((a, b) -> a.cost-b.cost);
        pq.offer(new Route(-1, 0, 0));
        boolean[] visited = new boolean[n];
        int minCost = 0;
        int totalCity = 0;
        while(!pq.isEmpty()){
            Route polledRoute = pq.poll();
            if(visited[polledRoute.city]){
                continue;
            }
            totalCity++;
            visited[polledRoute.city] = true;
            minCost += polledRoute.cost;
            for(Route adjRoute: inputRouteList.get(polledRoute.city)){
                if(!visited[adjRoute.city]){
                    pq.offer(new Route(polledRoute.city, adjRoute.city, adjRoute.cost));
                }
            }
        }
        minCost = totalCity == n ? minCost: -1;
        return minCost;
    }
}