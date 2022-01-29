package com.vishal.graph;

import java.util.*;
import java.util.stream.Collectors;

public class AccountMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int totalAccounts = accounts.size();
        DSU dsu = new DSU(totalAccounts);
        Map<String, Integer> emailAccIdMap = new HashMap<>();
        for (int i = 0; i < totalAccounts; i++) {
            List<String> emails = accounts.get(i).subList(1, accounts.get(i).size());
            for (String email : emails) {
                if (!emailAccIdMap.containsKey(email)) {
                    emailAccIdMap.put(email, i);
                } else {
                    int prevAccId = emailAccIdMap.get(email);
                    dsu.union(prevAccId, i);
                }
            }
        }
        // iterate account and prepare ans
        Map<Integer, Account> aggregateMap = new HashMap<>();
        for (int i = 0; i < totalAccounts; i++) {
            List<String> currAccount = accounts.get(i);
            List<String> emails = currAccount.subList(1, currAccount.size());
            int ultimateAccId = dsu.findParent(i);
            if (!aggregateMap.containsKey(ultimateAccId)) {
                String accName = accounts.get(i).get(0);
                aggregateMap.put(ultimateAccId, new Account(accName));
                aggregateMap.get(ultimateAccId).emails.addAll(emails);
            } else {
                aggregateMap.get(ultimateAccId).emails.addAll(emails);
            }
        }
        List<List<String>> aggregateList = aggregateMap.values()
                .stream().map(acc -> acc.getSortedEmails())
                .collect(Collectors.toList());
        return aggregateList;
    }

    static class Account{
        String name;
        TreeSet<String> emails;
        public Account(String name){
            this.name = name;
            this.emails = new TreeSet<>();
        }

        public List<String> getSortedEmails(){
            List<String> emailList = new ArrayList<>();
            emailList.add(name);
            emailList.addAll(emails);
            return emailList;
        }

    }

    static class DSU{
        private int[] size;
        private int[] parent;
        public DSU(int n){
            size = new int[n];
            parent = new int[n];
            for(int i = 0; i < parent.length; i++){
                parent[i] = i;
            }
        }

        public void union(int u, int v){
            int pu = findParent(u);
            int pv = findParent(v);
            if(pu == pv){
                return;
            }else{
                if(size[pu] > size[pv]){
                    parent[pv] = pu;
                    size[pu]++;
                }else{
                    parent[pu] = pv;
                    size[pv]++;
                }
            }
        }

        public int findParent(int node){
            if(parent[node] == node){
                return node;
            }
            parent[node] = findParent(parent[node]);
            return parent[node];
        }
    }
}
