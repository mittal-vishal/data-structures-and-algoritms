package com.vishal;

public class Test {

    static class DSU{
        int n;
        int[] size;
        int[] parent;
        public DSU(int n){
            this.n = n;
            size = new int[n];
            parent = new int[n];
            for(int i = 0; i < n; i++){
                size[i] = 1;
                parent[i] = i;
            }
        }
        void union(int u, int v){
            int up = findParent(u);
            int vp = findParent(v);
            if(up == vp){
                return;
            }else if(size[up] <= size[vp]){
                size[vp] += size[up];
                parent[up] = parent[vp];
            }else{
                size[up] += size[vp];
                parent[vp] = parent[up];
            }
        }
        int findParent(int node){
            if(node == parent[node]){
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }
    }


    private static int[] getReachableServers(int n, int[][] connections, int[] queries){
        DSU dsu = new DSU(n);
        for(int i = 0; i < connections.length; i++){
            int u = connections[i][0]-1;
            int v = connections[i][1]-1;
            dsu.union(u,v);
        }
        int[] result = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int currentQuery = queries[i]-1;
            int ultimateParentCurrQuery = dsu.parent[currentQuery];
            result[i] = dsu.size[ultimateParentCurrQuery];
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] connections = {{1,2}, {2,3}, {4,5}};
        int[] queries = {2,5};
        int[] result = getReachableServers(n, connections, queries);
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }

}
