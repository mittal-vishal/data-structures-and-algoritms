package com.vishal.graph;

import java.util.Arrays;

public class EarliestMomentWhenEveryoneBecomeFriends {

    static class Dsu{
        private int[] size;
        private int[] parent;
        public Dsu(int n){
            this.size = new int[n];
            this.parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        private boolean union(int u, int v){
            int up = findParent(u);
            int vp = findParent(v);
            if(up == vp){
                return false;
            }
            if(size[up] >= size[vp]){
                parent[vp] = up;
                size[up] += size[vp];
            }else{
                parent[up] = vp;
                size[vp] += size[up];
            }
            return true;
        }
        private int findParent(int node){
            if(node == parent[node]){
                return node;
            }
            return findParent(parent[node]);
        }
    }

    public int earliestAcq(int[][] logs, int n) {
        Dsu dsu = new Dsu(n);
        int groups = 0;
        Arrays.sort(logs, (a, b) -> a[0]-b[0]);
        for(int[] log: logs){
            int ts = log[0];
            int u = log[1];
            int v = log[2];
            if(dsu.union(u,v)){
                groups++;
            }
            if(groups == n-1){
                return ts;
            }
        }
        return -1;
    }

}
