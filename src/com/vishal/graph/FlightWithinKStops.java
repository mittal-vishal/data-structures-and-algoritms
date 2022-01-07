package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FlightWithinKStops {

    static class Flight{
        int label;
        int cost;
        int stops;
        public Flight(int label, int cost){
            this.label = label;
            this.cost = cost;
        }
        public Flight(int label, int cost, int stops){
            this.label = label;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(flights == null || flights.length == 0){
            return -1;
        }
        //Build graph
        List<List<Flight>> flightList = new ArrayList<>();
        buildGraph(flightList, flights, n);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        dist[src] = 0;
        stops[src] = 0;
        PriorityQueue<Flight> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);
        pq.offer(new Flight(src, 0, 0));
        while(!pq.isEmpty()){
            Flight curr = pq.poll();
            if(curr.label == dst){
                return curr.cost;
            }
            if(curr.stops > k){
                continue;
            }
            for(Flight neighbour: flightList.get(curr.label)){
                if((dist[curr.label] + neighbour.cost) < dist[neighbour.label]){
                    dist[neighbour.label] = curr.cost + neighbour.cost;
                    pq.offer(new Flight(neighbour.label, dist[neighbour.label], curr.stops + 1));
                }else if(curr.stops < stops[neighbour.label]){
                    pq.offer(new Flight(neighbour.label, curr.cost + neighbour.cost, curr.stops + 1));
                }
                stops[neighbour.label] = curr.stops;
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    private void buildGraph(List<List<Flight>> flightList, int[][] flights, int n){
        for(int i = 0; i < n; i++){
            flightList.add(new ArrayList<>());
        }
        for(int [] flight: flights){
            flightList.get(flight[0]).add(new Flight(flight[1], flight[2], 0));
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
