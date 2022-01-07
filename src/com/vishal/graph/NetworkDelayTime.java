package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {

    static class Node{
        int label;
        int time;
        public Node(int label, int time){
            this.label = label;
            this.time = time;
        }
    }


    public int networkDelayTime(int[][] times, int n, int k) {
        if(times == null || times.length == 0 || k == -1){
            return -1;
        }
        List<List<Node>> adjList = new ArrayList<>();
        buildGraph(adjList, times, n);
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->a.time-b.time);
        pq.offer(new Node(k-1, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k-1] = 0;
        boolean[] visited = new boolean[n];
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            visited[curr.label] = true;
            for(Node neighbour: adjList.get(curr.label)){
                if(!visited[neighbour.label] && (dist[curr.label] + neighbour.time) < dist[neighbour.label]){
                    dist[neighbour.label] = dist[curr.label] + neighbour.time;
                    pq.offer(new Node(neighbour.label, dist[neighbour.label]));
                }
            }
        }
        int delay = -1;
        for(int distance: dist){
            if(distance == Integer.MAX_VALUE){
                return -1;
            }
            delay = Math.max(delay, distance);
        }
        return delay;
    }

    private void buildGraph(List<List<Node>> adjList, int[][] times, int n){
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] time: times){
            adjList.get(time[0]-1).add(new Node(time[1]-1, time[2]));
        }
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
