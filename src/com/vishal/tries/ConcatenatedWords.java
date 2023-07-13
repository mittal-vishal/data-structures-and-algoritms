package com.vishal.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcatenatedWords {

    static class Node{
        Node[] children;
        boolean isWord;
        public Node(){
            children = new Node[26];
        }
    }

    private Node root;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new Node();
        List<String> result = new ArrayList<>();
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        for(String word: words){
            if(isExist(word, 0)){
                result.add(word);
            }else{
                insert(word);
            }
        }
        return result;
    }

    private void insert(String s){
        Node curr = root;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new Node();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isWord = true;
    }

    private boolean isExist(String s, int index){
        if(index == s.length()){
            return true;
        }
        Node curr = root;
        for(int i = index; i < s.length(); i++){
            char ch = s.charAt(i);
            if(curr.isWord && isExist(s, i)){
                return true;
            }else if(curr.children[ch-'a'] == null){
                return false;
            }else{
                curr = curr.children[ch-'a'];
            }
        }
        return curr.isWord;
    }
}
