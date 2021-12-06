package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    static  class GraphNode{
        int src;
        int dest;
        int cost;
        public GraphNode(int src, int dest, int cost){
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        if(times == null || times.length == 0){
            return -1;
        }
        //build the graph
        List<List<GraphNode>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < times.length; i++){
            int[] node = times[i];
            adjList.get(node[0]-1).add(new GraphNode(node[0]-1, node[1]-1, node[2]));
        }
        //Disjkstra
        PriorityQueue<GraphNode> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k-1] = 0;
        pq.add(new GraphNode(-1, k-1, 0));
        boolean[] visited = new boolean[n];
        while(!pq.isEmpty()){
            GraphNode polledNode = pq.poll();
            visited[polledNode.dest] = true;
            List<GraphNode> neighbourList = adjList.get(polledNode.dest);
            for(GraphNode neighbour: neighbourList){
                if(!visited[neighbour.dest] && dist[neighbour.dest] > dist[polledNode.dest] + neighbour.cost){
                    dist[neighbour.dest] = dist[polledNode.dest] + neighbour.cost;
                    neighbour.cost = dist[neighbour.dest];
                    pq.offer(neighbour);
                }
            }
        }
        int max = -1;
        for(int weight: dist){
            max = Math.max(max, weight);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int nodes = 4;
        int src = 2;
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        int minTime = networkDelayTime.networkDelayTime(times, nodes, src);
        System.out.println(minTime);
    }

}
