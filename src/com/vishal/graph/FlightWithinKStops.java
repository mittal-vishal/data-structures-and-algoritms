package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FlightWithinKStops {

    static class Node{
        int city;
        int cost;
        int stops;
        public Node(int city, int cost, int stops){
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(flights == null || flights.length == 0){
            return -1;
        }
        //Build graph
        List<List<Node>> adjList = new ArrayList<>();
        buildGraph(adjList, flights, n);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);
        pq.offer(new Node(src, 0, 0));
        boolean[] visited = new boolean[n];
        while(!pq.isEmpty()){
            Node current = pq.poll();
            visited[current.city] = true;
            if(current.city == dst){
                return current.cost;
            }
            if(current.stops > k){
                continue;
            }
            for(Node neighbour: adjList.get(current.city)){
                if(visited[neighbour.city]){
                    continue;
                }
                if((dist[current.city] + neighbour.cost) < dist[neighbour.city]){
                    dist[neighbour.city] = current.cost + neighbour.cost;
                    pq.offer(new Node(neighbour.city, dist[neighbour.city], current.stops + 1));
                }else if(current.stops < stops[neighbour.city]){
                    pq.offer(new Node(neighbour.city, current.cost + neighbour.cost, current.stops + 1));
                }
                stops[neighbour.city] = current.stops;
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    private void buildGraph(List<List<Node>> adjList, int[][] flights, int n){
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int [] flight: flights){
            adjList.get(flight[0]).add(new Node(flight[1], flight[2], 0));
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
