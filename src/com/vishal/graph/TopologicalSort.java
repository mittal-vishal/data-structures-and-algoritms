package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {

	private int[] toposort(int V, ArrayList<ArrayList<Integer>> adj)
	{
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < V; i++){
			if(!visited[i]){
				dfs(adj, i, visited, stack);
			}
		}
		int[] result = new int[stack.size()];
		int index = 0;
		while(!stack.isEmpty()){
			result[index++] = stack.pop();
		}
		return result;
	}

	private void dfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited, Stack<Integer> stack){
		visited[src] = true;
		for(int neighbour: adj.get(src)){
			if(!visited[neighbour]){
				dfs(adj, neighbour, visited, stack);
			}
		}
		stack.add(src);
	}

}
