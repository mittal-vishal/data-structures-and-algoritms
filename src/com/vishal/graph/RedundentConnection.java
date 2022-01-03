package com.vishal.graph;

import java.util.Arrays;

public class RedundentConnection {

    class DSU{

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
        public int[] union(int u, int v){
            int[] redundent = null;
            int uParent = find(u);
            int vParent = find(v);
            if(uParent == vParent){
                redundent = new int[2];
                redundent[0] = u + 1;
                redundent[1] = v + 1;
            }else{
                if(size[uParent] >= size[vParent]){
                    parent[vParent] = uParent;
                    size[uParent]++;
                }else if(size[vParent] > size[uParent]){
                    parent[uParent] = vParent;
                    size[vParent]++;
                }
            }
            return redundent;
        }

        public int find(int node){
            if(parent[node] == node){
                return node;
            }
            parent[node] = find(parent[node]);
            return parent[node];
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        if(edges == null || edges.length == 0){
            return new int[]{-1, -1};
        }
        int n = edges.length;
        DSU dsu = new DSU(n);
        for(int[] edge: edges){
            int[] redundent = dsu.union(edge[0] - 1, edge[1] - 1);
            if(redundent != null){
                return redundent;
            }
        }
        return new int[]{-1, -1};
    }
}