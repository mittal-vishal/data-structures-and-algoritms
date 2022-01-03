package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathSrcTarget {

    private int target;
    private int[][] graph;
    private List<List<Integer>> results;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.results = new ArrayList<>();
        this.graph = graph;
        LinkedList<Integer> path = new LinkedList<>();
        this.target = graph.length - 1;
        path.addLast(0);
        dfs(0, path);
        return results;
    }

    private void dfs(int src, LinkedList<Integer> path){
        if(src == target){
            this.results.add(new ArrayList<>(path));
            return;
        }
        for(int neighbour: this.graph[src]){
            path.addLast(neighbour);
            dfs(neighbour, path);
            path.removeLast();
        }
    }

}
