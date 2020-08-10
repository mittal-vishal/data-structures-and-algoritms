package com.vishal.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nov = sc.nextInt();
		int edges = sc.nextInt();
		List<List<Integer>> adj = new ArrayList<>(nov);
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
		bfs(adj, visited, nov);
	}

	private static void bfs(List<List<Integer>> adj, boolean[] visited, int nov) {
		for (int i = 0; i < nov; i++) {
			if (!visited[i]) {
				bfsTraversal(adj, visited, i);
			}
		}
	}

	private static void bfsTraversal(List<List<Integer>> adj, boolean[] visited, int nov) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(nov);
		visited[nov] = true;
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
