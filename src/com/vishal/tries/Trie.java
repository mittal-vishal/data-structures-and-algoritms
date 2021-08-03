package com.vishal.tries;

class Trie {

    class TrieNode{
        boolean isWord;
        TrieNode[] childrens;
        public TrieNode(){
            childrens = new TrieNode[26];
            isWord = false;
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char currChar = word.charAt(i);
            if(curr.childrens[currChar-'a'] == null){
                TrieNode newNode = new TrieNode();
                curr.childrens[currChar-'a'] = newNode;
            }
            curr = curr.childrens[currChar-'a'];
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode searchNode = getNode(word);
        if(searchNode != null && searchNode.isWord){
            return true;
        }else{
            return false;
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode prefixNode = getNode(prefix);
        return prefixNode != null;
    }

    private TrieNode getNode(String word){
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(curr.childrens[ch-'a'] == null){
                return null;
            }
            curr = curr.childrens[ch-'a'];
        }
        return curr;
    }
}