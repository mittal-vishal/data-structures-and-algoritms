package com.vishal.graph;

import java.util.*;

public class AlienDictionary {

    public String alienOrder(String[] words) {
        int n = words.length;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            graph.add(new ArrayList<>());
        }
        HashSet<Integer> uniqueNodes = new HashSet<>();
        for(String word: words){
            for(int i = 0; i < word.length(); i++){
                uniqueNodes.add(word.charAt(i)-'a');
            }
        }
        for(int i = 0; i < n-1; i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int len = Math.min(s1.length(), s2.length());
            for(int j = 0; j < len; j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    buildGraph(graph, s1.charAt(j)-'a', s2.charAt(j)-'a');
                    break;
                }
                if(j == len - 1 && s1.length() > s2.length()){
                    return "";
                }
            }
        }
        boolean[] visited = new boolean[26];
        boolean[] pathVisited = new boolean[26];
        Stack<Integer> st = new Stack<>();
        for(int i: uniqueNodes){
            if(!visited[i] && dfs(i, graph, st, visited, pathVisited)){
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append((char)(st.pop()+'a'));
        }
        return sb.toString();
    }

    private void buildGraph(List<List<Integer>> graph, int u, int v){
        graph.get(u).add(v);
    }

    private boolean dfs(int src, List<List<Integer>> graph, Stack<Integer> st, boolean[] visited, boolean[] pathVisited){
        visited[src] = true;
        pathVisited[src] = true;
        for(int neighbour: graph.get(src)){
            if(visited[neighbour] && pathVisited[neighbour]){
                return true;
            }else if(!visited[neighbour] && dfs(neighbour, graph, st, visited, pathVisited)){
                return true;
            }
        }
        pathVisited[src] = false;
        st.push(src);
        return false;
    }

}
