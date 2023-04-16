package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {

	public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> results = new ArrayList<>();
		boolean[] visited = new boolean[V];
		dfs(adj, 0, visited, results);
		return results;
	}

	private void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, ArrayList<Integer> results){
		visited[src] = true;
		results.add(src);
		for(int neighbour: adj.get(src)){
			if(!visited[neighbour]){
				dfs(adj, neighbour, visited, results);
			}
		}
	}

}
