package com.vishal.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestColorValueInDirectedGraph {

    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = colors.length();
        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        //build graph and prepare indegree
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int seenNodes = 0;
        int result = 1;
        int[][] count = new int[n][26];
        while(!queue.isEmpty()){
            int currNode = queue.poll();
            seenNodes++;
            result = Math.max(result, ++count[currNode][colors.charAt(currNode)-'a']);
            for(int neighbour: graph.get(currNode)){
                for(int i = 0; i < 26; i++){
                    count[neighbour][i] = Math.max(count[neighbour][i], count[currNode][i]);
                }
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
        return seenNodes == n? result: -1;
    }

}
