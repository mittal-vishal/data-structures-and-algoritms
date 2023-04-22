package com.vishal.graph;

import java.util.Arrays;

public class IslandsDSU {

    class DSU{
        private int[] size;
        private int[] parent;
        private int n;
        public DSU(int n){
            this.n = n;
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

        private void unionBySize(int u, int v){
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

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        DSU dsu = new DSU(row*col+1);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '0'){
                    continue;
                }
                int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
                for(int[] dir: dirs){
                    int newRow = i+dir[0];
                    int newCol = j+dir[1];
                    if(isValid(newRow, newCol, grid) && grid[newRow][newCol] == '1'){
                        int u = (i*col)+j;
                        int v = (newRow*col)+newCol;
                        dsu.unionBySize(u,v);
                    }
                }
            }
        }
        int islands = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    int node = (i*col)+j;
                    if(node == dsu.parent[node]){
                        islands++;
                    }
                }
            }
        }
        return islands;
    }

    private boolean isValid(int i, int j, char[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }
}
