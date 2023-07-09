package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NumberOfProvinces {

    public int findCircleNumDFS(int[][] isConnected) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = isConnected.length;
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < isConnected[0].length; j++){
                if(i != j && isConnected[i][j] == 1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, graph, visited);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int src, List<List<Integer>> graph, boolean[] visited){
        visited[src] = true;
        for(int neighbour: graph.get(src)){
            if(!visited[neighbour]){
                dfs(neighbour, graph, visited);
            }
        }
    }

    private int result;

    class DSU{

        int[] size;
        int[] parent;

        DSU(int n){
            size = new int[n];
            parent = new int[n];
            Arrays.fill(size, 1);
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        private int findParent(int i){
            if(i == parent[i]){
                return i;
            }
            return parent[i] = findParent(parent[i]);
        }

        private void union(int u, int v){
            int up = findParent(u);
            int vp = findParent(v);
            if(up == vp){
                return;
            }else{
                if(size[up] > size[vp]){
                    parent[vp] = up;
                    size[up] += size[vp];
                }else{
                    parent[up] = vp;
                    size[vp] += size[up];
                }
                result--;
            }
        }

    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[i].length; j++){
                if(i != j && isConnected[i][j] == 1){
                    dsu.union(i, j);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(dsu.findParent(i) == i){
                count++;
            }
        }
        return count;
    }

}

