package com.vishal.graph;

import java.util.Arrays;

class NumberOfProvinces {

    private int result;

    class DSU{

        int[] size;
        int[] parent;

        DSU(int n){
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

        private void union(int u, int v){
            int up = findParent(u);
            int vp = findParent(v);
            if(up == vp){
                return;
            }else{
                if(size[up] > size[vp]){
                    parent[vp] = up;
                    size[up] += size[vp];
                }else{
                    parent[up] = vp;
                    size[vp] += size[up];
                }
                result--;
            }
        }

    }
    public int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;
        int col = isConnected[0].length;
        this.result = row;
        DSU dsu = new DSU(row);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(isConnected[i][j] == 1){
                    dsu.union(i, j);
                }
            }
        }
        return result;
    }

}

