package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinHeightTree {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1){
            return List.of(0);
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        int[] degree = new int[n];
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
            degree[u]++;
            degree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < degree.length; i++){
            if(degree[i] == 1){
                queue.offer(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            result.clear();
            for(int i = 0; i < size; i++){
                int currNode = queue.poll();
                result.add(currNode);
                for(int neighbor: graph.get(currNode)){
                    degree[neighbor]--;
                    if(degree[neighbor] == 1){
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return result;
    }

}
