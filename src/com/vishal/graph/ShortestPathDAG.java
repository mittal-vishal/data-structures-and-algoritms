package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathDAG {

    class Element{
        int node;
        int cost;
        Element(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    public int[] shortestPath(int N,int M, int[][] edges) {
        List<List<Element>> graph = new ArrayList<>();
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            graph.get(u).add(new Element(v, cost));
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N];
        dfs(graph, 0, visited, stack);
        int[] toposort = new int[N];
        int index = 0;
        while(!stack.isEmpty()){
            toposort[index++] = stack.pop();
        }
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for(int i = 0; i < N; i++){
            int node = toposort[i];
            for(Element neighbour: graph.get(node)){
                if(dist[neighbour.node] > (dist[node] + neighbour.cost)){
                    dist[neighbour.node] = dist[node] + neighbour.cost;
                }
            }
        }
        for(int i = 0; i < N; i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        return dist;
    }

    private void dfs(List<List<Element>> graph, int src, boolean[] visited, Stack<Integer> st){
        visited[src] = true;
        for(Element neighbour: graph.get(src)){
            if(!visited[neighbour.node]){
                dfs(graph, neighbour.node, visited, st);
            }
        }
        st.add(src);
    }

}
