package com.vishal.graph;

class NumberOfProvinces {

    private int[] parent;
    private int[] rank;
    private int provinceCount;

    public int findCircleNum(int[][] isConnected) {
        if(isConnected == null || isConnected.length == 0){
            return 0;
        }
        int n = isConnected.length;
        parent = new int[n];
        rank = new int[n];
        provinceCount = n;
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    union(i, j);
                }
            }
        }
        return provinceCount;
    }

    private void union(int i, int j){
        int iParent = findParent(i);
        int jParent = findParent(j);
        if(iParent == jParent){
            return;
        }
        if(rank[iParent] > rank[jParent]){
            parent[jParent] = iParent;
        }else if(jParent > iParent){
            parent[iParent] = jParent;
        }else{
            parent[jParent] = iParent;
            rank[iParent]++;
        }
        provinceCount--;
    }

    private int findParent(int i){
        if(i == parent[i]){
            return i;
        }
        parent[i] = findParent(parent[i]);
        return parent[i];
    }
}

