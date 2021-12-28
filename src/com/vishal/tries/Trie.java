package com.vishal.tries;

class Trie {

    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char currChar = word.charAt(i);
            if(curr.childrens[currChar-'a'] == null){
                curr.childrens[currChar-'a'] = new Node();
            }
            curr = curr.childrens[currChar-'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char currChar = word.charAt(i);
            if(curr.childrens[currChar-'a'] == null){
                return false;
            }
            curr = curr.childrens[currChar-'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char currChar = prefix.charAt(i);
            if(curr.childrens[currChar-'a'] == null){
                return false;
            }
            curr = curr.childrens[currChar-'a'];
        }
        return true;
    }
}

class Node{
    Node[] childrens;
    boolean isEnd;
    Node(){
        this.childrens = new Node[26];
        this.isEnd = false;
    }
}