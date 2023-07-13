package com.vishal.tries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class AutoCompleteSystem {

    static class Node{
        Node[] children;
        List<Node> hotList;
        int time;
        String searchWord;
        public Node(){
            children = new Node[128];
            hotList = new ArrayList<>();
        }

        private void update(Node node){
            if(!hotList.contains(node)){
                hotList.add(node);
            }
            Collections.sort(hotList, (a,b) ->{
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

    private Node root;
    private Node curr;
    private StringBuilder sb;

    public AutoCompleteSystem(String[] sentences, int[] times) {
        root = new Node();
        curr = root;
        sb = new StringBuilder();
        for(int i = 0; i < sentences.length; i++){
            insert(sentences[i], times[i]);
        }
    }

    private void insert(String word, int time){
        Node curr = root;
        HashSet<Node> visited = new HashSet<>();
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(curr.children[ch] == null){
                curr.children[ch] = new Node();
            }
            curr = curr.children[ch];
            visited.add(curr);
        }
        curr.searchWord = word;
        curr.time += time;
        for(Node node: visited){
            node.update(curr);
        }
    }

    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        if(c == '#'){
            curr = root;
            insert(sb.toString(), 1);
            sb.setLength(0);
            return result;
        }
        sb.append(c);
        if(curr == null){
            return result;
        }
        curr = curr.children[c];
        if(curr == null){
            return result;
        }else{
            for(Node node: curr.hotList){
                result.add(node.searchWord);
            }
            return result;
        }
    }

}
