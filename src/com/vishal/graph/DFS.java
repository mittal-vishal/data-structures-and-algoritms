package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {

	public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[V];
		ArrayList<Integer> result = new ArrayList<>();
		for(int i = 0; i < V; i++){
			if(!visited[i]){
				dfs(i, result, visited, adj);
			}
		}
		return result;
	}

	private void dfs(int src, ArrayList<Integer> result, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
		visited[src] = true;
		result.add(src);
		for(int neighbour: adj.get(src)){
			if(!visited[neighbour]){
				dfs(neighbour, result, visited, adj);
			}
		}
	}

}
