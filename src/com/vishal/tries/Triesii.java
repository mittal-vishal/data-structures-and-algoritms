package com.vishal.tries;

class Triesii {

    class TrieNode{
        TrieNode childrens[];
        boolean isWord;
        int wordCount;
        int prefixCount;
        public TrieNode(){
            childrens = new TrieNode[26];
        }
    }

    private TrieNode root;
    public Triesii() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char currChar = word.charAt(i);
            if(curr.childrens[currChar-'a'] == null){
                curr.childrens[currChar-'a'] = new TrieNode();
            }
            curr = curr.childrens[currChar-'a'];
            curr.prefixCount += 1;
        }
        curr.wordCount += 1;
        curr.isWord = true;
    }

    public int countWordsEqualTo(String word) {
        TrieNode prefixNode = getNode(word);
        if(prefixNode != null && prefixNode.isWord){
            return prefixNode.wordCount;
        }else{
            return 0;
        }
    }

    private TrieNode getNode(String word){
        TrieNode curr = root;
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
        TrieNode prefixNode = getNode(prefix);
        if(prefixNode != null){
            return prefixNode.prefixCount;
        }else{
            return 0;
        }
    }

    public void erase(String word) {
        TrieNode curr = root;
        for(int i = 0;i < word.length();i++){
            char c = word.charAt(i);
            TrieNode child = curr.childrens[c-'a'];

            child.prefixCount -= 1;
            if(child.prefixCount == 0){
                curr.childrens[c-'a'] = null;
            }
            curr = child;
        }
        if(curr.wordCount > 0){
            curr.wordCount--;
        }
        if(curr.wordCount == 0){
            curr.isWord = false;
        }
    }
}