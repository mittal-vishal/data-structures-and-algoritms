package com.vishal.tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoCompleteSystem {

    class TrieNode{
        TrieNode[] childrens;
        String searchWord;
        int time;
        List<TrieNode> hotList;
        public TrieNode(){
            childrens = new TrieNode[128];
            searchWord = null;
            time = 0;
            hotList = new ArrayList<>();
        }
        private void update(TrieNode node){
            if(!hotList.contains(node)){
                hotList.add(node);
            }
            Collections.sort(hotList, (a, b) -> {
                if(a.time != b.time){
                    return b.time-a.time;
                }else{
                    return a.searchWord.compareTo(b.searchWord);
                }
            });
            if(hotList.size() > 3){
                hotList.remove(hotList.size()-1);
            }
        }
    }

    private TrieNode root;
    private TrieNode curr;
    private StringBuilder sb;

    public AutoCompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        curr = root;
        sb = new StringBuilder();
        for(int i = 0; i < sentences.length; i++){
            add(sentences[i], times[i]);
        }
    }

    private void add(String sentence, int time){
        TrieNode temp = root;
        List<TrieNode> visited = new ArrayList<>();
        for(char ch: sentence.toCharArray()){
            if(temp.childrens[ch] == null){
                temp.childrens[ch] = new TrieNode();
            }
            temp = temp.childrens[ch];
            visited.add(temp);
        }
        temp.searchWord = sentence;
        temp.time += time;
        for(TrieNode node: visited){
            node.update(temp);
        }
    }

    public List<String> input(char c) {
        List<String> results = new ArrayList<>();
        if(c == '#'){
            add(sb.toString(), 1);
            curr = root;
            sb = new StringBuilder();
            return results;
        }
        sb.append(c);
        if(curr != null){
            curr = curr.childrens[c];
            if(curr != null){
                for(TrieNode node: curr.hotList){
                    results.add(node.searchWord);
                }
            }
        }
        return results;
    }

}
