package com.vishal.graph;

import java.util.Arrays;

public class PathExist {

    static class DSU{
        int[] size;
        int[] parent;

        public DSU(int n){
            size = new int[n];
            Arrays.fill(size, 1);
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public void union(int u, int v){
            int[] redundent = null;
            int uParent = find(u);
            int vParent = find(v);
            if(uParent != vParent){
                if(size[uParent] >= size[vParent]){
                    parent[vParent] = uParent;
                    size[uParent]++;
                }else if(size[vParent] > size[uParent]){
                    parent[uParent] = vParent;
                    size[vParent]++;
                }
            }
        }

        public int find(int node){
            if(parent[node] == node){
                return node;
            }
            parent[node] = find(parent[node]);
            return parent[node];
        }
    }


    public boolean validPath(int n, int[][] edges, int start, int end) {
        DSU dsu = new DSU(n);
        for(int[] edge: edges){
            dsu.union(edge[0], edge[1]);
        }
        if(dsu.find(start) != dsu.find(end)){
            return false;
        }
        return true;
    }
}