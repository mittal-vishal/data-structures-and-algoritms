package com.vishal.graph;

import java.util.*;

public class CycleUnidirectedGraph {

	public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[V];
		for(int i = 0; i < V; i++){
			if(!visited[i] && dfs(adj, i, -1, visited)){
				return true;
			}
		}
		return false;
	}

	private boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, int prev, boolean[] visited){
		visited[src] = true;
		for(int neighbour: adj.get(src)){
			if(visited[neighbour] && neighbour != prev){
				return true;
			}
			if(!visited[neighbour] && dfs(adj, neighbour, src, visited)){
				return true;
			}
		}
		return false;
	}

	class Element{
		int node;
		int parent;
		Element(int node, int parent){
			this.node = node;
			this.parent = parent;
		}
	}
	// Function to detect cycle in an undirected graph.
	public boolean isCycleUsingBFS(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[V];
		for(int i = 0; i < V; i++){
			if(!visited[i] && bfs(adj, i, visited)){
				return true;
			}
		}
		return false;
	}

	private boolean bfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited){
		Queue<Element> queue = new LinkedList<>();
		queue.offer(new Element(src,-1));
		visited[src] = true;
		while(!queue.isEmpty()){
			Element polled = queue.poll();
			for(int neighbour: adj.get(polled.node)){
				if(visited[neighbour] && neighbour != polled.parent){
					return true;
				}else if(!visited[neighbour]){
					visited[neighbour] = true;
					queue.offer(new Element(neighbour, polled.node));
				}
			}
		}
		return false;
	}

}
