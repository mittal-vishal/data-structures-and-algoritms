package com.vishal.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

class ShortestDistMatrixDijkstra {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int nov = sc.nextInt();
			int[][] grid = new int[nov][nov];
			for (int i = 0; i < nov; i++) {
				for (int j = 0; j < nov; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			int[] src = { 0, 0 };
			int[] dest = { nov - 1, nov - 1 };
			new Implementation().dijkstra(grid, src, dest, nov);
			System.out.println();
		}
		sc.close();
	}
}

class Implementation {
	
	public class GraphNode {
		private int row;
		private int col;
		private int cost;

		public GraphNode(int row, int col, int cost) {
			super();
			this.row = row;
			this.col = col;
			this.cost = cost;
		}
	}

	public void dijkstra(int[][] grid, int[] src, int[] dest, int nov) {
		int[] validRow = { 0, 0, -1, 1 };
		int[] validCol = { -1, 1, 0, 0 };
		PriorityQueue<GraphNode> pq = new PriorityQueue<>((GraphNode o1, GraphNode o2) -> o1.cost - o2.cost);
		Set<GraphNode> visitedSet = new HashSet<>();
		int dist[][] = new int[nov][nov];
		for (int[] distArray : dist) {
			Arrays.fill(distArray, Integer.MAX_VALUE);
		}
		dist[src[0]][src[1]] = grid[0][0];
		pq.add(new GraphNode(src[0], src[1], grid[src[0]][src[1]]));
		GraphNode popped = null;
		GraphNode adjNode = null;
		while (!pq.isEmpty()) {
			popped = pq.poll();
			for (int i = 0; i < validRow.length; i++) {
				if (isValid(popped.row + validRow[i], popped.col + validCol[i], nov)) {
					adjNode = new GraphNode(popped.row + validRow[i], popped.col + validCol[i],
							grid[popped.row + validRow[i]][popped.col + validCol[i]]);
					if (!visitedSet.contains(adjNode)
							&& dist[adjNode.row][adjNode.col] > dist[popped.row][popped.col] + adjNode.cost) {
						dist[adjNode.row][adjNode.col] = dist[popped.row][popped.col] + adjNode.cost;
						pq.add(new GraphNode(adjNode.row, adjNode.col, dist[adjNode.row][adjNode.col]));
					}
				}
			}
			visitedSet.add(popped);
		}
		System.out.print(dist[dest[0]][dest[1]]);
	}

	private boolean isValid(int i, int j, int n) {
		if (i >= 0 && i < n && j >= 0 && j < n)
			return true;
		else
			return false;
	}
}