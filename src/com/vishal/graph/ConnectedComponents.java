package com.vishal.graph;

import java.util.Arrays;

class ConnectedComponents {
    static class DisjointSet{
        int[] size;
        int[] parent;
        DisjointSet(int n){
            size = new int[n+1];
            parent = new int[n+1];
            Arrays.fill(size, 1);
            for(int i = 0; i <= n; i++){
                parent[i] = i;
            }
        }

        public void union(int u, int v){
            int ultParentU = findParent(u);
            int ultParentV = findParent(v);
            if(ultParentU == ultParentV){
                return;
            }
            if(size[ultParentU] > size[ultParentV]){
                parent[ultParentV] = ultParentU;
                size[ultParentU] += size[ultParentV];
            }else{
                parent[ultParentU] = ultParentV;
                size[ultParentV] += size[ultParentU];
            }
        }

        public int findParent(int node){
            if(parent[node] == node){
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }
    }

    public int countComponents(int n, int[][] edges) {
        DisjointSet dsu = new DisjointSet(n);
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            dsu.union(u, v);
        }
        int components = 0;
        for(int i = 0; i < n; i++){
            if(dsu.findParent(i) == i){
                components++;
            }
        }
        return components;
    }
}