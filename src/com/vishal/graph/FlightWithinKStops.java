package com.vishal.graph;

import java.util.*;

public class FlightWithinKStops {

    class Flight{
        int number;
        int dist;
        int stops;
        public Flight(int number, int dist, int stops){
            this.number = number;
            this.dist = dist;
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
        PriorityQueue<Flight> pq = new PriorityQueue<>((a,b) -> a.dist-b.dist);
        pq.offer(new Flight(src, 0, 0));
        while(!pq.isEmpty()){
            Flight curr = pq.poll();
            int currStops = curr.stops;
            int currNumber = curr.number;
            int currDist = curr.dist;
            if(curr.number == dst)  return currDist;
            if(currStops > k)   continue;
            for(Flight nextFlight: flightList.get(currNumber)){
                int nextNumber = nextFlight.number;
                int nextStops = currStops + 1;
                int nextDist = currDist + nextFlight.dist;
                if(dist[nextNumber] > nextDist || stops[nextNumber] > nextStops){
                    dist[nextNumber] = nextDist;
                    pq.offer(new Flight(nextNumber, nextDist, nextStops));
                    stops[nextNumber] = nextStops;
                }
            }
        }
        return -1;
    }

    private void buildGraph(List<List<Flight>> flightList, int[][] flights, int n){
        for(int i = 0; i < n; i++){
            flightList.add(new ArrayList<>());
        }
        for(int [] flight: flights){
            flightList.get(flight[0]).add(new Flight(flight[1], flight[2], 0));
        }
    }

}
