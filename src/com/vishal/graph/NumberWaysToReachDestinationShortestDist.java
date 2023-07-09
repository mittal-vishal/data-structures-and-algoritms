package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberWaysToReachDestinationShortestDist {

    static class Node{
        int id;
        int dist;
        public Node(int id, int dist){
            this.id = id;
            this.dist = dist;
        }
    }

    public int countPaths(int n, int[][] roads) {
        int modulo = 1000000007;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new Node(0, 0));
        int[] ways = new int[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        ways[0] = 1;
        dist[0] = 0;

        List<List<Node>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] road: roads){
            adjList.get(road[0]).add(new Node(road[1], road[2]));
            adjList.get(road[1]).add(new Node(road[0], road[2]));
        }
        while(!pq.isEmpty()){
            Node polled = pq.poll();
            if(polled.dist > dist[polled.id]){
                continue;
            }
            for(Node neighbour: adjList.get(polled.id)){
                if((dist[neighbour.id] > dist[polled.id] + neighbour.dist)){
                    dist[neighbour.id] = dist[polled.id] + neighbour.dist;
                    ways[neighbour.id] = ways[polled.id];
                    pq.offer(new Node(neighbour.id, dist[neighbour.id]));
                }else if((dist[polled.id] + neighbour.dist) == dist[neighbour.id]){
                    ways[neighbour.id] = (ways[neighbour.id] + ways[polled.id]) % modulo;
                }
            }
        }
        return ways[n-1];
    }

}
