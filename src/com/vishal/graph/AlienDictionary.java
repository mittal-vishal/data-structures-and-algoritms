package com.vishal.graph;

import java.util.*;

public class AlienDictionary {

    public String alienOrder(String[] words) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            adjList.add(new ArrayList<>());
        }
        Set<Integer> charSet = new HashSet<>();
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                charSet.add(words[i].charAt(j)-'a');
            }
        }
        for(int i = 0; i < words.length - 1; i++){
            String firstWord = words[i];
            String secondWord = words[i+1];
            for(int j = 0; j < firstWord.length(); j++){
                if(secondWord.length() <= j){
                    return "";
                }
                if(firstWord.charAt(j) != secondWord.charAt(j)){
                    int u = getCharInt(firstWord.charAt(j));
                    int v = getCharInt(secondWord.charAt(j));
                    adjList.get(u).add(v);
                    break;
                }
            }
        }
        boolean[] visited = new boolean[26];
        boolean[] recStack = new boolean[26];
        Stack<Integer> stack = new Stack<>();
        for(int node: charSet){
            if(!visited[node] && isCycle(adjList, node, visited, recStack, stack)){
                return "";
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!stack.isEmpty()){
            sb.append((char)(stack.pop() + 97));
        }

        return sb.toString();
    }

    private int getCharInt(char ch){
        return ch-'a';
    }

    private boolean isCycle(List<List<Integer>> adjList, int src, boolean[] visited, boolean[] recStack, Stack<Integer> stack){
        visited[src] = true;
        for(int neighbour: adjList.get(src)){
            if(!visited[neighbour] && isCycle(adjList, neighbour, visited, recStack, stack)){
                return true;
            }else if(visited[neighbour] && !recStack[neighbour]){
                return true;
            }
        }
        recStack[src] = true;
        stack.push(src);
        return false;
    }

}
