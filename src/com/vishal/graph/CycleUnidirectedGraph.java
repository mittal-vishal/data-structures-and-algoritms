package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CycleUnidirectedGraph {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nov = sc.nextInt();
		int edges = sc.nextInt();
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < nov; i++) {
			adj.add(new ArrayList<>());
		}
		int u = 0, v = 0;
		for (int i = 0; i < edges; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		sc.close();
		System.out.println(dfsTraversal(adj, nov));
	}

	private static boolean dfsTraversal(List<List<Integer>> adj, int nov) {
		boolean[] visited = new boolean[nov];
		for(int i = 0; i < nov; i++) {
			if(!visited[i]) {
				if(dfs(adj, visited, i, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean dfs(List<List<Integer>> adjList, boolean[] visited, int src, int parent) {
		visited[src] = true;

		for (int adj: adjList.get(src)) {

			if ((visited[adj] && parent != adj) || (!visited[adj] && dfs(adjList, visited, adj, src))){
				return true;
			}
		}

		return false;
	}

}
