package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {

	public static void main(String[] args) {
		//Directed Graph, we considered disconnected cases
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
		}
		sc.close();
		boolean[] visited = new boolean[nov];
		dfs(adj, visited, nov);
	}

	private static void dfs(List<List<Integer>> adj, boolean[] visited, int nov) {
		for (int i = 0; i < nov; i++) {
			if (!visited[i]) {
				dfsTraversal(adj, visited, i);
			}
		}
	}

	private static void dfsTraversal(List<List<Integer>> adj, boolean[] visited, int src) {
		visited[src] = true;
		System.out.print(src + " ");
		for(int i : adj.get(src)) {
			if(!visited[i]) {
				dfsTraversal(adj, visited, i);
			}
		}
	}

}
