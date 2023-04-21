package com.vishal.graph;

import java.util.*;

class ShortestDistMatrixDijkstra {

	static class GraphNode{
		int node;
		int cost;
		GraphNode(int node, int cost){
			this.node = node;
			this.cost = cost;
		}
	}

	static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
	{
		List<List<GraphNode>> graph = new ArrayList<>();
		for(int i = 0; i < adj.size(); i++){
			graph.add(new ArrayList<>());
			ArrayList<ArrayList<Integer>> neighbours = adj.get(i);
			for(ArrayList<Integer> graphNodeData: neighbours){
				graph.get(i).add(new GraphNode(graphNodeData.get(0), graphNodeData.get(1)));
			}
		}
		PriorityQueue<GraphNode> pq = new PriorityQueue<>((a,b) -> a.cost-b.cost);
		pq.offer(new GraphNode(S, 0));
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[S] = 0;
		while(!pq.isEmpty()){
			GraphNode polled = pq.poll();
			for(GraphNode neighbour: graph.get(polled.node)){
				if(dist[neighbour.node] > (dist[polled.node] + neighbour.cost)){
					dist[neighbour.node] = dist[polled.node] + neighbour.cost;
					pq.offer(new GraphNode(neighbour.node, dist[neighbour.node]));
				}
			}
		}
		return dist;
	}

}