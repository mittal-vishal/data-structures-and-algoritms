package com.vishal.tries;

class Tries2 {
    private Node root;
    public Tries2() {
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
            curr.prefixCount += 1;
        }
        curr.wordCount += 1;
        curr.isWord = true;
    }

    public int countWordsEqualTo(String word) {
        Node prefixNode = getNode(word);
        if(prefixNode != null && prefixNode.isWord){
            return prefixNode.wordCount;
        }else{
            return 0;
        }
    }

    private Node getNode(String word){
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char currChar = word.charAt(i);
            if(curr.childrens[currChar-'a'] != null){
                curr = curr.childrens[currChar-'a'];
            }else{
                return null;
            }
        }
        return curr;
    }

    public int countWordsStartingWith(String prefix) {
        Node prefixNode = getNode(prefix);
        if(prefixNode != null){
            return prefixNode.prefixCount;
        }else{
            return 0;
        }
    }

    public void erase(String word) {
        Node curr = root;
        for(int i = 0;i < word.length();i++){
            char c = word.charAt(i);
            Node child = curr.childrens[c-'a'];

            child.prefixCount -= 1;
            if(child.prefixCount == 0){
                curr.childrens[c-'a'] = null;
                return;
            }
            curr = child;
        }
        if(curr.wordCount > 0){
            curr.wordCount--;
        }
    }

    class Node{
        Node childrens[];
        boolean isWord;
        int wordCount;
        int prefixCount;
        public Node(){
            childrens = new Node[26];
        }
    }
}