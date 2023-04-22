package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII {

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

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        DSU dsu = new DSU(m*n);
        int count = 0;
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[m][n];
        for(int[] pos: positions){
            int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
            int row = pos[0];
            int col = pos[1];
            if(visited[row][col]){
                result.add(count);
                continue;
            }
            count++;
            visited[row][col] = true;
            for(int[] dir: dirs){
                int newRow = row+dir[0];
                int newCol = col+dir[1];
                if(isValid(newRow, newCol, m, n) && visited[newRow][newCol]){
                    int u = (row*n)+col;
                    int v = (newRow*n)+newCol;
                    if(dsu.findParent(u) != dsu.findParent(v)){
                        count--;
                        dsu.unionBySize(u,v);
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
