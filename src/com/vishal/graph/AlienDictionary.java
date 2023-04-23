package com.vishal.graph;

import java.util.*;

public class AlienDictionary {

    public String alienOrder(String[] words) {
        //get unique chars count for graph size
        HashSet<Character> uniqueChars = new HashSet<>();
        for(String word: words){
            for(int i = 0; i < word.length(); i++){
                uniqueChars.add(word.charAt(i));
            }
        }
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < words.length-1; i++){
            String str1 = words[i];
            String str2 = words[i+1];
            int len = Math.min(str1.length(), str2.length());
            for(int k = 0; k < len; k++){
                if(str1.charAt(k) != str2.charAt(k)){
                    int u = str1.charAt(k)-'a';
                    int v = str2.charAt(k)-'a';
                    graph.get(u).add(v);
                    break;
                }else if(k == len-1 && str1.length() > str2.length()){
                    return "";
                }
            }
        }
        int[] order = topoSort(graph, uniqueChars);
        StringBuilder sb = new StringBuilder();
        for(int i: order){
            sb.append((char)(i+97));
        }
        return sb.length() == uniqueChars.size()? sb.toString(): "";
    }

    private int[] topoSort(List<List<Integer>> graph, HashSet<Character> uniqueChars){
        boolean[] visited = new boolean[26];
        boolean[] pathVisited = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        for(Character vertex: uniqueChars){
            int node = vertex-'a';
            if(!visited[node] && dfs(graph, node, visited, pathVisited, stack)){
                break;
            }
        }
        int[] result = new int[stack.size()];
        int index = 0;
        while(!stack.isEmpty()){
            result[index++] = stack.pop();
        }
        return result;
    }

    private boolean dfs(List<List<Integer>> graph, int src, boolean[] visited, boolean[] pathVisited, Stack<Integer> stack){
        visited[src] = true;
        pathVisited[src] = true;
        for(int neighbour: graph.get(src)){
            if(!visited[neighbour] && dfs(graph, neighbour, visited, pathVisited, stack)){
                return true;
            }else if(pathVisited[neighbour]){
                return true;
            }
        }
        stack.push(src);
        pathVisited[src] = false;
        return false;
    }

}
