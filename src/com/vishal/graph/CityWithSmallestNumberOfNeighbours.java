package com.vishal.graph;

public class CityWithSmallestNumberOfNeighbours {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j){
                    dist[i][j] = 0;
                }else if(dist[i][j] == 0){
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        int city = -1;
        int maxThreshold = distanceThreshold + 1;

        for(int i = 0; i < n; i++){
            int thresholdCount = 0;
            for(int j = 0; j < n; j++){
                if(dist[i][j] <= distanceThreshold){
                    thresholdCount++;
                }
            }
            if(thresholdCount <= maxThreshold){
                maxThreshold = thresholdCount;
                city = i;
            }
        }
        return city;
    }

}
