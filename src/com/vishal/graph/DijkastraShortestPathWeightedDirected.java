package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class DijkastraShortestPathWeightedDirected {

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
			adj.get(v).add(graphNode);
		}
		int source = sc.nextInt();
		int dest = sc.nextInt();
		sc.close();
		System.out.println(find(adj, nov, source, dest));
	}

	private static int find(List<List<GraphNode>> adj, int nov, int source, int dest) {
		PriorityQueue<GraphNode> pq = new PriorityQueue<>((GraphNode o1, GraphNode o2) -> o1.getCost() - o2.getCost());
		Set<Integer> visitedSet = new HashSet<>();
		int dist[] = new int[nov];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0;
		pq.add(new GraphNode(source, 0));
		GraphNode popped = null;
		while (!pq.isEmpty()) {
			popped = pq.poll();
			for (GraphNode adjNode : adj.get(popped.getNode())) {
				if (!visitedSet.contains(adjNode.getNode())
						&& dist[adjNode.getNode()] > dist[popped.getNode()] + adjNode.getCost()) {
					dist[adjNode.getNode()] = dist[popped.getNode()] + adjNode.getCost();
					pq.add(new GraphNode(adjNode.getNode(), dist[adjNode.getNode()]));
				}
			}
			visitedSet.add(popped.getNode());
		}
		for (int i = 0; i < dist.length; i++) {
			if (dest == i) {
				return dist[i];
			}
		}
		return -1;
	}

}
