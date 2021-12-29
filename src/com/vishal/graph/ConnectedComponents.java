package com.vishal.graph;

import java.util.Arrays;
import java.util.HashSet;

class ConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        if(edges == null || edges.length == 0){
            return n;
        }
        DSU dsu = new DSU(n);
        for(int[] edge: edges){
            dsu.union(edge[0], edge[1]);
        }

        HashSet<Integer> uniqueParentSet = new HashSet<>();
        for(int i = 0; i < n; i++){
            int uniqueParent = dsu.findParent(i);
            uniqueParentSet.add(uniqueParent);
        }

        return uniqueParentSet.size();
    }
}

class DSU{
    int[] size;
    int[] parent;

    public DSU(int n){
        size = new int[n];
        parent = new int[n];
        Arrays.fill(size, 1);
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    public void union(int u, int v){
        int uParent = findParent(u);
        int vParent = findParent(v);
        if(uParent == vParent){
            return;
        }
        if(size[uParent] > size[vParent]){
            parent[vParent] = u;
            size[uParent] += size[vParent];
        }else{
            parent[uParent] = v;
            size[vParent] += size[uParent];
        }
    }

    public int findParent(int node){
        if(parent[node]  == node){
            return node;
        }
        //path compression
        parent[node] = findParent(parent[node]);
        return parent[node];
    }
}