package com.vishal.graph;

import java.util.Arrays;
import java.util.HashSet;

public class MostStoneRemoved {

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

    public int removeStones(int[][] stones) {
        int n = stones.length;
        int row = 0;
        int col = 0;
        for(int[] stone: stones){
            row = Math.max(row, stone[0]);
            col = Math.max(col, stone[1]);
        }
        DSU dsu = new DSU(row+col+2);
        HashSet<Integer> uniqueStones = new HashSet<>();
        for(int[] stone: stones){
            int u = stone[0];
            int v = stone[1] + row + 1;
            dsu.unionBySize(u,v);
            uniqueStones.add(u);
            uniqueStones.add(v);
        }
        int componentCount = 0;
        for(int node: uniqueStones){
            if(node == dsu.parent[node]){
                componentCount++;
            }
        }
        return n-componentCount;
    }

}
