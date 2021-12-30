package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IslandII {

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

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> islandList = new ArrayList<>();
        int[][] grid = new int[m][n];
        int count = 0;
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0},{1, 0}};
        DSU dsu = new DSU(m*n);
        for(int[] pos: positions){
            int x = pos[0];
            int y = pos[1];
            if(grid[x][y] == 1){
                islandList.add(count);
                continue;
            }
            int u = (n * x) + y;
            grid[x][y] = 1;
            count++;
            for(int[] dir: dirs){
                int newX = x + dir[0];
                int newY = y + dir[1];
                if(isValid(newX, newY, m, n) && grid[newX][newY] == 1){
                    int v = (n * newX) + newY;
                    if(dsu.findParent(u) != dsu.findParent(v)){
                        count--;
                        dsu.union(u, v);
                    }
                }
            }
            islandList.add(count);
        }
        return islandList;
    }

    private boolean isValid(int row, int col, int rows, int cols){
        if(row >= 0 && row < rows && col >= 0 && col < cols){
            return true;
        }else{
            return false;
        }
    }
}
