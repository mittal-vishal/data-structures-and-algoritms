package com.vishal.graph;

class UnionFind {
    private int[] parent;
    private int[] rank;
    private int count;
    public int countComponents(int n, int[][] edges) {
        if(edges == null || edges.length == 0){
            return n;
        }
        parent = new int[n];
        rank = new int[n];
        count = n;
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < edges.length; i++){
            int[] edge = edges[i];
            union(edge[0], edge[1]);
        }
        return count;
    }

    public void union(int i, int j){
        int iParent = findParent(i);
        int jParent = findParent(j);
        if(iParent == jParent){
            return;
        }else{
            int iRank = rank[iParent];
            int jRank = rank[jParent];
            if(iRank > jRank){
                parent[jParent] = iParent;
            }else if(jRank > iRank){
                parent[iParent] = jParent;
            }else{
                parent[jParent] = iParent;
                rank[iParent]++;
            }
        }
        count--;
    }

    private int findParent(int i){
        if(i == parent[i]){
            return i;
        }
        parent[i] = findParent(parent[i]);
        return parent[i];
    }
}
