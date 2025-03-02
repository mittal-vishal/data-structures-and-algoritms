package com.vishal.graph;

import java.util.*;

public class PossibleBiPartition {

    private int[] colors;
    private List<List<Integer>> graph;

    public boolean possibleBiPartition(int n, int[][] dislikes) {
        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] dislike: dislikes){
            int u = dislike[0];
            int v = dislike[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        colors = new int[n+1];
        Arrays.fill(colors, -1);
        for(int i = 1; i <= n; i++){
            if(colors[i] == -1 && !bfs(n, i)){
                return false;
            }
        }
        return true;
    }

    private boolean bfs(int n, int src){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);
        colors[src] = 0;
        while(!queue.isEmpty()){
            Integer curr = queue.poll();
            for(Integer neighbor: graph.get(curr)){
                if(colors[neighbor] == colors[curr]){
                    return false;
                }
                if(colors[neighbor] == -1){
                    colors[neighbor] = colors[curr] == 0 ? 1 : 0;
                    queue.offer(neighbor);
                }
            }
        }
        return true;
    }

}
