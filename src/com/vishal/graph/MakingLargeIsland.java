package com.vishal.graph;

import java.util.Arrays;
import java.util.HashSet;

public class MakingLargeIsland {

    static class DSU{
        int n;
        int[] size;
        int[] parent;
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

    public int largestIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        DSU dsu = new DSU(row*col);
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                for(int[] dir: dirs){
                    int newX = i + dir[0];
                    int newY = j + dir[1];
                    if(isValid(newX, newY, row, col) && grid[newX][newY] == 1){
                        int node = (i * col) + j;
                        int adjNode = (newX * col) + newY;
                        dsu.union(node, adjNode);
                    }
                }
            }
        }
        int result = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    continue;
                }
                HashSet<Integer> uniqueAdjParent = new HashSet<>();
                for(int[] dir: dirs){
                    int newX = i + dir[0];
                    int newY = j + dir[1];
                    if(isValid(newX, newY, row, col) && grid[newX][newY] == 1){
                        int adjNode = (newX * col) + newY;
                        uniqueAdjParent.add(dsu.findParent(adjNode));
                    }
                }
                int size = 0;
                for(int parent: uniqueAdjParent){
                    size += dsu.size[parent];
                }
                result = Math.max(result, size + 1);
            }
        }
        for(int node = 0; node < (row*col); node++){
            if(node == dsu.findParent(node)){
                result = Math.max(result, dsu.size[node]);
            }
        }
        return result;
    }

    private boolean isValid(int i, int j, int row, int col){
        if(i >= 0 && i < row && j >= 0 && j < col){
            return true;
        }
        return false;
    }

}
