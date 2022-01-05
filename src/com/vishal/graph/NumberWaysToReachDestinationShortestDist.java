package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NumberWaysToReachDestinationShortestDist {

    static class Node{
        int id;
        int dist;
        public Node(int id){
            this.id = id;
        }
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
        boolean[] visited = new boolean[n];
        while(!pq.isEmpty()){
            Node polled = pq.poll();
            visited[polled.id] = true;
            if(polled.dist > dist[polled.id]){
                continue;
            }
            for(Node neighbour: adjList.get(polled.id)){
                if(visited[neighbour.id]){
                    continue;
                }
                if((dist[polled.id] + neighbour.dist) < dist[neighbour.id]){
                    dist[neighbour.id] = dist[polled.id] + neighbour.dist;
                    pq.offer(new Node(neighbour.id, dist[neighbour.id]));
                    ways[neighbour.id] = ways[polled.id];
                }else if((dist[polled.id] + neighbour.dist) == dist[neighbour.id]){
                    ways[neighbour.id] = (ways[neighbour.id] + ways[polled.id]) % modulo;
                }
            }
        }
        return ways[n-1];
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};
        NumberWaysToReachDestinationShortestDist ways = new NumberWaysToReachDestinationShortestDist();
        int ans = ways.countPaths(n, roads);
        System.out.println(ans);
    }

}
