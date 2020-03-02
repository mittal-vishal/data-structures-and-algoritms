package com.vishal.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPathUndirectedUnweight {

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
		boolean[] visited = new boolean[nov];
		int[] dist = new int[nov];
		int src = sc.nextInt();
		int dest = sc.nextInt();
		sc.close();
		bfs(adj, visited, src, dist, dest);
	}

	private static void bfs(List<List<Integer>> adj, boolean[] visited, int src, int[] dist, int dest) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(src);
		visited[src] = true;
		int popped = 0;
		dist[src] = 0;
		while (!queue.isEmpty()) {
			popped = queue.poll();
			for (int i : adj.get(popped)) {
				if (visited[i] == false) {
					visited[i] = true;
					queue.add(i);
					dist[i] = dist[popped] + 1;
				}
			}
		}
		for(int i = 0; i < dist.length; i++) {
			if(i == dest) {
				System.out.print(dist[i]);
			}
		}
	}

}
