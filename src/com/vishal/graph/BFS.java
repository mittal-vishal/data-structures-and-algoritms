package com.vishal.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

	private static void bfs(List<List<Integer>> adj, int nov) {
		boolean[] visited = new boolean[nov];
		for (int i = 0; i < nov; i++) {
			if (!visited[i]) {
				bfsTraversal(adj, visited, i);
			}
		}
	}

	private static void bfsTraversal(List<List<Integer>> adj, boolean[] visited, int src) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(src);
		visited[src] = true;
		int popped = 0;
		while (!queue.isEmpty()) {
			popped = queue.poll();
			System.out.print(popped + " ");
			for (int i : adj.get(popped)) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}

}
