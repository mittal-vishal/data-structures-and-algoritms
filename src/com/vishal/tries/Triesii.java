package com.vishal.tries;

class Triesii {

    static class Node{
        Node[] childrens;
        int wordCount;
        int prefixCount;
        boolean isWord;
        public Node(){
            this.childrens = new Node[26];
        }
    }

    private Node root;

    public Triesii() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(curr.childrens[ch-'a'] == null){
                curr.childrens[ch-'a'] = new Node();
            }
            curr = curr.childrens[ch-'a'];
            curr.prefixCount++;
        }
        curr.isWord = true;
        curr.wordCount++;
    }

    public int countWordsEqualTo(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(curr.childrens[ch-'a'] == null){
                return 0;
            }
            curr = curr.childrens[ch-'a'];
        }
        return curr.isWord? curr.wordCount: 0;
    }

    public int countWordsStartingWith(String prefix) {
        Node curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(curr.childrens[ch-'a'] == null){
                return 0;
            }
            curr = curr.childrens[ch-'a'];
        }
        return curr.prefixCount;
    }

    public void erase(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(curr.childrens[ch-'a'] == null){
                return;
            }
            curr = curr.childrens[ch-'a'];
            curr.prefixCount--;
        }
        if(curr.isWord){
            curr.wordCount--;
        }
    }
}