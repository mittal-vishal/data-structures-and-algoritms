package com.vishal.graph;

import java.util.*;
import java.util.stream.Collectors;

public class AccountMerge {

    class DisjointUnion{
        int[] size;
        int[] parent;
        int n;
        DisjointUnion(int n){
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

        private void unionBySize(int u, int v){
            int up = findParent(u);
            int vp = findParent(v);
            if(vp == up){
                return;
            }else if(size[up] > size[vp]){
                parent[vp] = up;
                size[up] += size[vp];
            }else{
                parent[up] = vp;
                size[vp] += size[up];
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> emailNode = new HashMap<>();
        int n = accounts.size();
        DisjointUnion dsu = new DisjointUnion(n);
        for(int i = 0; i < n; i++){
            List<String> emails = accounts.get(i);
            for(int j = 1; j < emails.size(); j++){
                String email = emails.get(j);
                if(!emailNode.containsKey(email)){
                    emailNode.put(email, i);
                }else{
                    dsu.unionBySize(i, emailNode.get(email));
                }
            }
        }

        Map<Integer, List<String>> nodeEmails = new HashMap<>();
        for(Map.Entry<String, Integer> entry: emailNode.entrySet()){
            int up = dsu.findParent(entry.getValue());
            nodeEmails.putIfAbsent(up, new ArrayList<>());
            nodeEmails.get(up).add(entry.getKey());
        }

        List<List<String>> results = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry: nodeEmails.entrySet()){
            List<String> mergeEmails = entry.getValue();
            Collections.sort(mergeEmails);
            mergeEmails.add(0, accounts.get(entry.getKey()).get(0));
            results.add(mergeEmails);
        }
        return results;
    }
}
