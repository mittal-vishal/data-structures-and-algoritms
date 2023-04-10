package com.vishal.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcatenatedWords {

    class Node{
        Node[] childrens;
        boolean isEnd;
        public Node(){
            childrens = new Node[26];
        }
    }

    private Node root;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new Node();
        Arrays.sort(words, (a,b) -> a.length()-b.length());
        List<String> results = new ArrayList<>();
        for(String word: words){
            if(isExist(word)){
                results.add(word);
            }else{
                insert(word);
            }
        }
        return results;
    }

    private boolean isExist(String s){
        if(s.length() == 0){
            return true;
        }
        Node curr = root;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(curr.isEnd && i < s.length() && isExist(s.substring(i, s.length()))){
                return true;
            }else if(curr.childrens[ch-'a'] == null){
                return false;
            }
            curr = curr.childrens[ch-'a'];
        }
        return curr.isEnd;
    }

    private void insert(String s){
        Node curr = root;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(curr.childrens[ch-'a'] == null){
                curr.childrens[ch-'a'] = new Node();
            }
            curr = curr.childrens[ch-'a'];
        }
        curr.isEnd = true;
    }

    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        ConcatenatedWords concatenatedWords = new ConcatenatedWords();
        List<String> concatWordsList = concatenatedWords.findAllConcatenatedWordsInADict(words);
        System.out.print(concatWordsList);
    }
}
