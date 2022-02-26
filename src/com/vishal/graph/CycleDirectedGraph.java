package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CycleDirectedGraph {
	
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
		}
		sc.close();
		System.out.println(dfsTraversal(adj, nov));
	}

	private static boolean dfsTraversal(List<List<Integer>> adj, int nov) {
		boolean[] visited = new boolean[nov];
		boolean[] recStack = new boolean[nov];
		for(int i = 0; i < nov; i++) {
			if(!visited[i]) {
				if(dfs(adj, visited, recStack, i)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean dfs(List<List<Integer>> adj, boolean[] visited, boolean[] recStack, int src) {
		visited[src] = true;
		recStack[src] = true;
		for(int i : adj.get(src)) {
			if(!visited[i]) {
				if(dfs(adj, visited, recStack, i)) {
					return true;
				}
			} else if(visited[i] && recStack[i]) {
				return true;
			}
		}
		recStack[src] = false;
		return false;
	}

}
