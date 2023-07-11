package com.vishal.graph;

public class NumberOfOperationToMakeNetworkConnected {

    static class DSU{
        int[] size;
        int[] parent;
        int n;
        public DSU(int n){
            this.n = n;
            this.size = new int[n];
            this.parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }
        private int findParent(int i){
            if(i == parent[i]){
                return i;
            }
            return parent[i] = findParent(parent[i]);
        }
        private void union(int u, int v){
            int pu = findParent(u);
            int pv = findParent(v);
            if(pu == pv){
                return;
            }else if(size[pu] > size[pv]){
                parent[pv] = pu;
                size[pu] += size[pv];
            }else{
                parent[pu] = pv;
                size[pv] += size[pu];
            }
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DSU dsu = new DSU(n);
        int extraEdges = 0;
        for(int[] connection: connections){
            int u = connection[0];
            int v = connection[1];
            if(dsu.findParent(u) != dsu.findParent(v)){
                dsu.union(u,v);
            }else if(dsu.findParent(u) == dsu.findParent(v)){
                dsu.union(u,v);
                extraEdges++;
            }
        }
        int components = 0;
        for(int i = 0; i < n; i++){
            if(i == dsu.findParent(i)){
                components++;
            }
        }
        return extraEdges >= (components-1) ? (components-1): -1;
    }

}
