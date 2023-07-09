package com.vishal.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
		boolean[] visited = new boolean[V];
		List<Integer> results = new ArrayList<>();
		for(int i = 0; i < V; i++){
			if(!visited[i]){
				bfs(i, visited, adj, results);
			}
		}
		return results;
	}

	public void bfs(int src, boolean[] visited, List<List<Integer>> adj, List<Integer> results) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(src);
		visited[src] = true;
		while(!queue.isEmpty()){
			int currNode = queue.poll();
			results.add(currNode);
			for(int neighbour: adj.get(currNode)){
				if(!visited[neighbour]){
					visited[neighbour] = true;
					queue.offer(neighbour);
				}
			}
		}
	}

}
