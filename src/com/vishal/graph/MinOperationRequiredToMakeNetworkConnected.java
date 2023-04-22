package com.vishal.graph;

import java.util.Arrays;

public class MinOperationRequiredToMakeNetworkConnected {

    class DSU{
        private int n;
        private int[] size;
        private int[] parent;

        DSU(int n){
            this.size = new int[n];
            this.parent = new int[n];
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
            }
            if(size[up] > size[vp]){
                parent[vp] = up;
                size[up] += size[vp];
            }else{
                parent[up] = vp;
                size[vp] += size[up];
            }
        }

    }
    public int makeConnected(int n, int[][] connections) {
        DSU dsu = new DSU(n);
        int extraEdges = 0;
        for(int[] connection: connections){
            int u = connection[0];
            int v = connection[1];
            if(dsu.findParent(u) == dsu.findParent(v)){
                extraEdges++;
            }else{
                dsu.union(u, v);
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(i == dsu.parent[i]){
                count++;
            }
        }
        int result = count-1;
        if(result <= extraEdges){
            return result;
        }
        return -1;
    }

}
