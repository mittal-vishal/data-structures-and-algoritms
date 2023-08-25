package com.vishal.graph;

import java.util.Arrays;

public class SimilarStringGroups {

    public static void main(String[] args) {
        String[] strs = {"tars","rats","arts","star"};
        SimilarStringGroups groups = new SimilarStringGroups();
        System.out.println(groups.numSimilarGroups(strs));
    }

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

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        DSU dsu = new DSU(n);
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                int count = 0;
                for(int k = 0; k < strs[i].length(); k++){
                    if(strs[i].charAt(k) != strs[j].charAt(k)){
                        count++;
                    }
                }
                if(count == 0 || count == 2){
                    dsu.unionBySize(i,j);
                }
            }
        }
        int result = 0;
        for(int i = 0; i < n; i++){
            if(i == dsu.findParent(i)){
                result++;
            }
        }
        return result;
    }

}
