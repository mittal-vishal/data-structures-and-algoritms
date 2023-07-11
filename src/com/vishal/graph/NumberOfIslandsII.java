package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII {

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
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        boolean[][] visited = new boolean[m][n];
        DSU dsu = new DSU(m*n);
        List<Integer> result = new ArrayList<>();
        int count = 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int[] position: positions){
            int i = position[0];
            int j = position[1];
            if(visited[i][j]){
                result.add(count);
                continue;
            }
            count++;
            visited[i][j] = true;
            for(int[] dir: dirs){
                int newX = i + dir[0];
                int newY = j + dir[1];
                if(isValid(newX, newY, m, n) && visited[newX][newY]){
                    int node = (i * n) + j;
                    int adjNode = (newX * n) + newY;
                    if(dsu.findParent(node) != dsu.findParent(adjNode)){
                        count--;
                        dsu.union(node, adjNode);
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    private boolean isValid(int i, int j, int m, int n){
        if(i >= 0 && i < m && j >= 0 && j < n){
            return true;
        }
        return false;
    }

}
