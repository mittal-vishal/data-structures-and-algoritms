package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {

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
		boolean[] visited = new boolean[nov];
		topological(adj, visited, nov);
	}

	private static void topological(List<List<Integer>> adj, boolean[] visited, int nov) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < nov; i++) {
			if (!visited[i]) {
				dfsTraversal(adj, visited, i, stack);
			}
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private static void dfsTraversal(List<List<Integer>> adj, boolean[] visited, int src, Stack<Integer> stack) {
		visited[src] = true;
		for(int i : adj.get(src)) {
			if(!visited[i]) {
				dfsTraversal(adj, visited, i, stack);
			}
		}
		stack.push(src);
	}

}
