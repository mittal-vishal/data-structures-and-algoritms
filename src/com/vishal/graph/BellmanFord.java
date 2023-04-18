package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {

    private static int INT_MAX = (int)1e8;
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, INT_MAX);
        dist[S] = 0;
        for(int i = 0; i < V; i++){
            for(ArrayList<Integer> edge: edges){
                int u = edge.get(0);
                int v = edge.get(1);
                int w = edge.get(2);
                if(dist[u] != INT_MAX && (dist[u] + w) < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }
        for(ArrayList<Integer> edge: edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            if(dist[u] != INT_MAX && (dist[u] + w) < dist[v]){
                int[] res = {-1};
                return res;
            }
        }
        return dist;
    }

}
