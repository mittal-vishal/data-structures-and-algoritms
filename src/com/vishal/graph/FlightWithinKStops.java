package com.vishal.graph;

import java.util.*;

public class FlightWithinKStops {

    class City{
        int node;
        int cost;
        int stops;
        public City(int node, int cost, int stops){
            this.node = node;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<City>> graph = new ArrayList<>();
        buildGraph(graph, flights, n);
        Queue<City> queue = new LinkedList<>();
        queue.offer(new City(src, 0, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        while(!queue.isEmpty()){
            City polled = queue.poll();
            if(polled.stops > k){
                continue;
            }
            for(City neighbour: graph.get(polled.node)){
                if(dist[neighbour.node] > polled.cost + neighbour.cost && (polled.stops <= k)){
                    dist[neighbour.node] = polled.cost + neighbour.cost;
                    queue.offer(new City(neighbour.node, dist[neighbour.node], polled.stops+1));
                }
            }
        }
        return dist[dst] != Integer.MAX_VALUE ? dist[dst]: -1;
    }

    private void buildGraph(List<List<City>> graph, int[][] flights, int n){
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] flight: flights){
            int src = flight[0];
            int dest = flight[1];
            int dist = flight[2];
            graph.get(src).add(new City(dest, dist, 0));
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
        int src = 0;
        int dest = 3;
        int k = 1;
        FlightWithinKStops flight = new FlightWithinKStops();
        int cost = flight.findCheapestPrice(n, flights, src, dest, k);
        System.out.println(cost);
    }

}
