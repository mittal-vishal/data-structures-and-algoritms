package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ShortestPathDirectedWeighted {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nov = sc.nextInt();
		int edges = sc.nextInt();
		List<List<GraphNode>> adj = new ArrayList<>();
		for (int i = 0; i < nov; i++) {
			adj.add(new ArrayList<>());
		}
		int u = 0, v = 0, c = 0;
		GraphNode graphNode = null;
		for (int i = 0; i < edges; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			c = sc.nextInt();
			graphNode = new GraphNode(v, c);
			adj.get(u).add(graphNode);
		}
		int source = sc.nextInt();
		int dest = sc.nextInt();
		sc.close();
		boolean[] visited = new boolean[nov];
		find(adj, visited, nov, source, dest);
	}

	private static void find(List<List<GraphNode>> adj, boolean[] visited, int nov, int source, int dest) {
		int dist[] = new int[nov];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0;
		Stack<Integer> stack = new Stack<>();
		dfs(adj, visited, nov, source, stack);
		int popped = -1;
		while (!stack.isEmpty()) {
			popped = stack.pop();
			for (GraphNode graphNode : adj.get(popped)) {
				if (dist[graphNode.getNode()] > dist[popped] + graphNode.getCost()) {
					dist[graphNode.getNode()] = dist[popped] + graphNode.getCost();
				}
			}
		}
		for (int i = 0; i < dist.length; i++) {
			if (dest == i) {
				System.out.println(dist[i]);
			}
		}
	}

	private static void dfs(List<List<GraphNode>> adj, boolean[] visited, int nov, int source, Stack<Integer> stack) {
		visited[source] = true;
		for (GraphNode graphNode : adj.get(source)) {
			if (!visited[graphNode.getNode()]) {
				dfs(adj, visited, nov, graphNode.getNode(), stack);
			}
		}
		stack.add(source);
	}

}
