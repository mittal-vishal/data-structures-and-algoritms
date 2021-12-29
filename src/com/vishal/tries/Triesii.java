package com.vishal.tries;

class Triesii {

    static class Node{
        Node[] childrens;
        int wordCount;
        int prefixCount;
        public Node(){
            childrens = new Node[26];
            wordCount = 0;
            prefixCount = 0;
        }
    }

    private Node root;

    public Triesii() {
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
            curr.prefixCount++;
        }
        curr.wordCount++;
    }

    public int countWordsEqualTo(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char currChar = word.charAt(i);
            if(curr.childrens[currChar-'a'] == null){
                return 0;
            }
            curr = curr.childrens[currChar-'a'];
        }
        return curr.wordCount;
    }

    public int countWordsStartingWith(String prefix) {
        Node curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char currChar = prefix.charAt(i);
            if(curr.childrens[currChar-'a'] == null){
                return 0;
            }
            curr = curr.childrens[currChar-'a'];
        }
        return curr.prefixCount;
    }

    public void erase(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char currChar = word.charAt(i);
            if(curr.childrens[currChar-'a'] == null){
                return;
            }
            curr = curr.childrens[currChar-'a'];
            if(curr.prefixCount > 0){
                curr.prefixCount--;
            }
        }
        if(curr.wordCount > 0){
            curr.wordCount--;
        }
    }
}