package com.vishal.graph;

import java.util.Arrays;
import java.util.HashSet;

public class MostStoneRemoved {

    static class DSU{
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

        private void union(int u, int v){
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
        int maxRow = -1;
        int maxCol = -1;
        for(int[] stone: stones){
            int row = stone[0];
            int col = stone[1];
            maxRow = Math.max(maxRow, row);
            maxCol = Math.max(maxCol, col);
        }
        DSU dsu = new DSU(maxRow+maxCol+2);
        HashSet<Integer> uniqueStones = new HashSet<>();
        for(int[] stone: stones){
            int u = stone[0];
            int v = stone[1] + maxRow + 1;
            dsu.union(u, v);
            uniqueStones.add(u);
            uniqueStones.add(v);
        }
        int count = 0;
        for(int stone: uniqueStones){
            if(stone == dsu.findParent(stone)){
                count++;
            }
        }
        return stones.length - count;
    }

}
