package com.vishal.graph;

public class CityWithSmallestNumberOfNeighbours {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i != j){
                    dist[i][j] = Integer.MAX_VALUE;
                }else{
                    dist[i][j] = 0;
                }
            }
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            dist[u][v] = cost;
            dist[v][u] = cost;
        }
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int city = -1;
        int maxNeighbourCityCount = n + 1;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(dist[i][j] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= maxNeighbourCityCount){
                maxNeighbourCityCount = count;
                city = i;
            }
        }
        return city;
    }

}
