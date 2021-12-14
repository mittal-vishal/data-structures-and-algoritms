package com.vishal.graph;

import java.util.HashSet;

class UnionFind {
    private int[] parent;
    private int[] rank;

    public int countComponents(int n, int[][] edges) {
        if(edges == null || edges.length == 0){
            return n;
        }
        parent = new int[n];
        rank = new int[n];
        //Set default parent
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < edges.length; i++){
            int[] currEdge = edges[i];
            //Union
            union(currEdge[0], currEdge[1]);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i: parent){
            set.add(getParent(i));
        }

        return set.size();
    }

    public void union(int i, int j){
        int iParent = getParent(i);
        int jParent = getParent(j);
        if(iParent == jParent){
            return;
        }
        if(rank[iParent] > rank[jParent]){
            parent[jParent] = iParent;
        }else if(rank[jParent] > rank[iParent]){
            parent[iParent] = jParent;
        }else{
            parent[jParent] = iParent;
            rank[iParent]++;
        }
    }

    private int getParent(int i){
        if(i == parent[i]){
            return i;
        }else{
            parent[i] = getParent(parent[i]);
            return parent[i];
        }
    }
}
