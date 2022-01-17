package com.vishal.graph;

import java.util.*;

public class SentenceSimilarityII {

    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        //base case
        if(sentence1.length != sentence2.length){
            return false;
        }
        //build graph
        Map<String, List<String>> graph = new HashMap<>();
        for(List<String> pair: similarPairs){
            graph.putIfAbsent(pair.get(0), new ArrayList<>());
            graph.putIfAbsent(pair.get(1), new ArrayList<>());
            graph.get(pair.get(0)).add(pair.get(1));
            graph.get(pair.get(1)).add(pair.get(0));
        }
        for(int i = 0; i < sentence1.length; i++){
            if(sentence1[i].equals(sentence2[i])){
                continue;
            }
            if(!dfs(graph, sentence1[i], sentence2[i], new HashSet<>())){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Map<String, List<String>> graph, String source, String target, Set<String> visited){
        if(visited.contains(source) || !graph.containsKey(source)){
            return false;
        }
        visited.add(source);
        if(source.equals(target)){
            return true;
        }
        for(String word: graph.get(source)){
            if(!visited.contains(word) && dfs(graph, word, target, visited)){
                return true;
            }
        }
        return false;
    }

}
