package com.vishal.tries;

import java.util.List;

public class WordBreak {

    class Node{
        Node[] childrens;
        boolean isEnd;
        public Node(){
            childrens = new Node[26];
        }
    }

    private Node root;

    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Node();
        //store all words of dictionary in trie
        for(String dicWord: wordDict){
            insert(dicWord);
        }
        return canBreak(s);
    }

    private boolean canBreak(String s){
        if(s.length() == 0){
            return true;
        }
        for(int i=1; i <= s.length(); i++){
            if(isExist(s.substring(0,i)) && canBreak(s.substring(i, s.length()))){
                return true;
            }
        }
        return false;
    }

    private boolean isExist(String s){
        Node curr = root;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(curr.childrens[ch-'a'] == null){
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

}
