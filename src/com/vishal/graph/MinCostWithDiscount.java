package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostWithDiscount {

    static class Node{
        int id;
        int dist;
        int discount;
        public Node(int id, int dist){
            this.id = id;
            this.dist = dist;
        }
        public Node(int id, int dist, int discount){
            this.id = id;
            this.dist = dist;
            this.discount = discount;
        }
    }

    public int minimumCost(int n, int[][] highways, int discounts) {
        if(highways == null || highways.length == 0){
            return -1;
        }
        int[][] dist = new int[n][discounts + 1];
        for(int i = 0; i < dist.length; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        List<List<Node>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < highways.length; i++){
            int[] road = highways[i];
            adjList.get(road[0]).add(new Node(road[1], road[2]));
            adjList.get(road[1]).add(new Node(road[0], road[2]));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new Node(0, 0, 0));
        dist[0][0] = 0;
        boolean[] visited = new boolean[n];
        while(!pq.isEmpty()){
            Node polled = pq.poll();
            visited[polled.id] = true;
            if(polled.id == n-1){
                return polled.dist;
            }
            for(Node neighbour: adjList.get(polled.id)){
                if(!visited[neighbour.id]){
                    if((dist[polled.id][polled.discount] + neighbour.dist) < dist[neighbour.id][polled.discount]){
                        dist[neighbour.id][polled.discount] = dist[polled.id][polled.discount] + neighbour.dist;
                        pq.offer(new Node(neighbour.id, dist[neighbour.id][polled.discount], polled.discount));
                    }
                    if(polled.discount < discounts &&
                            (polled.dist + neighbour.dist/2) < dist[neighbour.id][polled.discount + 1]){
                        dist[neighbour.id][polled.discount + 1] = dist[polled.id][polled.discount] + (neighbour.dist/2);
                        pq.offer(new Node(neighbour.id, dist[neighbour.id][polled.discount+1], polled.discount + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] highways = {{0,1,4},{2,1,3},{1,4,11},{3,2,3},{3,4,2}};
        int discount = 1;
        MinCostWithDiscount mincost = new MinCostWithDiscount();
        int cost = mincost.minimumCost(n, highways, discount);
        System.out.println(cost);
    }

}
