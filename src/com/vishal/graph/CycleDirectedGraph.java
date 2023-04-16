package com.vishal.graph;

import java.util.*;

public class CycleDirectedGraph {

	public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[V];
		boolean[] pathVisited = new boolean[V];
		for(int i = 0; i < V; i++){
			if(!visited[i] && dfs(adj, i, visited, pathVisited)){
				return true;
			}
		}
		return false;
	}

	private boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, boolean[] pathVisited){
		visited[src] = true;
		pathVisited[src] = true;
		for(int neighbour: adj.get(src)){
			if(visited[neighbour] && pathVisited[neighbour]){
				return true;
			}
			if(!visited[neighbour] && dfs(adj, neighbour, visited, pathVisited)){
				return true;
			}
		}
		pathVisited[src] = false;
		return false;
	}

	public boolean isCyclicUsingKahns(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[V];
		int[] indegree = new int[V];
		for(int i = 0; i < V; i++){
			List<Integer> neighbours = adj.get(i);
			for(int j = 0; j < neighbours.size(); j++){
				indegree[neighbours.get(j)]++;
			}
		}
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < indegree.length; i++){
			if(indegree[i] == 0){
				queue.offer(i);
			}
		}
		int index = 0;
		while(!queue.isEmpty()){
			int polled = queue.poll();
			index++;
			for(int neighbour: adj.get(polled)){
				indegree[neighbour]--;
				if(indegree[neighbour] == 0){
					queue.offer(neighbour);
				}
			}
		}
		return index == V ? false: true;
	}

}
