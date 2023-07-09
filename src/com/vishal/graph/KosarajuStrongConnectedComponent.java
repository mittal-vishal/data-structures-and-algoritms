package com.vishal.graph;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuStrongConnectedComponent {

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, adj, visited, stack);
            }
        }

        //Reverse the graph
        ArrayList<ArrayList<Integer>> revGraph = new ArrayList<>();
        for(int i = 0; i < V; i++){
            revGraph.add(new ArrayList<>());
        }

        for(int i = 0; i < adj.size(); i++){
            visited[i] = false;
            for(int neighbour: adj.get(i)){
                revGraph.get(neighbour).add(i);
            }
        }

        int result = 0;
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(!visited[node]){
                dfs(node, revGraph, visited);
                result++;
            }
        }
        return result;
    }

    private void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> st){
        visited[src] = true;
        for(int neighbour: adj.get(src)){
            if(!visited[neighbour]){
                dfs(neighbour, adj, visited, st);
            }
        }
        st.push(src);
    }

    private void dfs(int src, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[src] = true;
        for(int neighbour: adj.get(src)){
            if(!visited[neighbour]){
                dfs(neighbour, adj, visited);
            }
        }
    }

}
