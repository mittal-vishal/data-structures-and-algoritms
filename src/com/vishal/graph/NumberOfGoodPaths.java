package com.vishal.graph;

import java.util.*;

public class NumberOfGoodPaths {

    class UnionFind{
        private int[] size;
        private int[] parent;
        private int n;
        public UnionFind(int n){
            this.n = n;
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

        private void unionBySize(int u, int v){
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
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        //build the graph
        int n = vals.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        //maintain mapping of values and number of nodes in increasing order
        TreeMap<Integer,List<Integer>> valueToNodes = new TreeMap<>();
        for(int i = 0; i < n; i++){
            valueToNodes.putIfAbsent(vals[i], new ArrayList<>());
            valueToNodes.get(vals[i]).add(i);
        }
        //start joining the nodes from treemap, if neighbour is of less value
        UnionFind uf = new UnionFind(n);
        int goodPaths = 0;
        for(int key: valueToNodes.keySet()){
            for(int node: valueToNodes.get(key)){
                for(int neighbour: graph.get(node)){
                    if(vals[node] >= vals[neighbour]){
                        uf.unionBySize(node, neighbour);
                    }
                }
            }
            Map<Integer,Integer> groups = new HashMap<>();
            for(int node: valueToNodes.get(key)){
                int ultimateParent = uf.findParent(node);
                groups.put(ultimateParent, groups.getOrDefault(ultimateParent, 0) + 1);
            }
            //with respect to all values, we will have size of number of nodes with good path, accumulate n(n+1)/2
            for(Map.Entry<Integer,Integer> entry: groups.entrySet()){
                int size = entry.getValue();
                goodPaths += size * (size-1)/2;
                goodPaths += size;
            }
        }
        return goodPaths;
    }

}
