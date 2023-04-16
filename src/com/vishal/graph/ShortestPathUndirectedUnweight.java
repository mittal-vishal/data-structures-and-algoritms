package com.vishal.graph;

import java.util.*;

public class ShortestPathUndirectedUnweight {

	public int[] shortestPath(int[][] edges,int n,int m ,int src) {
		int[] dist = new int[n];
		Arrays.fill(dist, -1);
		dist[src] = 0;
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < n; i++){
			graph.add(new ArrayList<>());
		}
		for(int[] edge: edges){
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(src);
		boolean[] visited = new boolean[n];
		visited[src] = true;
		while(!queue.isEmpty()){
			int polled = queue.poll();
			for(int neighbour: graph.get(polled)){
				if(!visited[neighbour]){
					visited[neighbour] = true;
					queue.offer(neighbour);
					dist[neighbour] = dist[polled] + 1;
				}
			}
		}
		return dist;
	}

}
