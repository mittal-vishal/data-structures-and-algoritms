package com.vishal.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeState {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        boolean[] safeState = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(graph, i, visited, pathVisited, safeState);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < safeState.length; i++){
            if(safeState[i]){
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(int[][] graph, int i, boolean[] visited, boolean[] pathVisited, boolean[] safeState){
        visited[i] = true;
        pathVisited[i] = true;
        for(int neighbour: graph[i]){
            if(!visited[neighbour] && dfs(graph, neighbour, visited, pathVisited, safeState)){
                return true;
            }else if(pathVisited[neighbour]){
                return true;
            }
        }
        pathVisited[i] = false;
        safeState[i] = true;
        return false;
    }

    public List<Integer> eventualSafeNodesUsingBFS(int[][] graph) {
        int n = graph.length;
        int[] indegree = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            int[] edges = graph[i];
            for(int v: edges){
                adjList.get(v).add(i);
            }
        }
        for(int i = 0; i < n; i++){
            for(int neighbour: adjList.get(i)){
                indegree[neighbour]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        boolean[] safeState = new boolean[n];
        while(!queue.isEmpty()){
            int polled = queue.poll();
            safeState[polled] = true;
            for(int neighbour: adjList.get(polled)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(safeState[i]){
                result.add(i);
            }
        }
        return result;
    }

}
