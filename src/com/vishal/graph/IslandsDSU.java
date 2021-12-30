package com.vishal.graph;

import java.util.Arrays;
import java.util.HashSet;

public class IslandsDSU {

    class DSU{
        int[] size;
        int[] parent;

        public DSU(int n){
            size = new int[n];
            parent = new int[n];
            Arrays.fill(size, 1);
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        public void union(int u, int v){
            int uParent = findParent(u);
            int vParent = findParent(v);
            if(uParent == vParent){
                return;
            }
            if(size[uParent] > size[vParent]){
                parent[vParent] = u;
                size[uParent] += size[vParent];
            }else{
                parent[uParent] = v;
                size[vParent] += size[uParent];
            }
        }

        public int findParent(int node){
            if(parent[node]  == node){
                return node;
            }
            //path compression
            parent[node] = findParent(parent[node]);
            return parent[node];
        }
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        DSU dsu = new DSU(rows*cols);

        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    int u = (i*cols) + j;
                    for(int k = 0; k < dirs.length; k++){
                        int newX = i + dirs[k][0];
                        int newY = j + dirs[k][1];
                        if(isValid(newX, newY, rows, cols) && grid[newX][newY] == '1'){
                            int v = (newX*cols) + newY;
                            dsu.union(u, v);
                        }
                    }
                }
            }
        }
        HashSet<Integer> uniqueParentSet = new HashSet<>();
        for(int i = 0; i < (rows*cols); i++){
            int row = i / cols;
            int col = i % cols;
            if(grid[row][col] == '1'){
                int uniqueParent = dsu.findParent(i);
                uniqueParentSet.add(uniqueParent);
            }
        }

        return uniqueParentSet.size();
    }

    private boolean isValid(int row, int col, int rows, int cols){
        if(row >= 0 && row < rows && col >= 0 && col < cols){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},{'1','1','0','0','0'},
                {'0','0','1','0','0'},{'0','0','0','1','1'}};
        IslandsDSU islands = new IslandsDSU();
        int numIslands = islands.numIslands(grid);
        System.out.println(numIslands);
    }
}
