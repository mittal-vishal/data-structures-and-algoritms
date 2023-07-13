package com.vishal.tries;

public class DesignAddAndSearchWords {

    static class Node{
        Node[] childrens;
        boolean isWord;
        public Node(){
            childrens = new Node[26];
        }
    }

    private Node root;

    public DesignAddAndSearchWords() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(curr.childrens[ch-'a'] == null){
                curr.childrens[ch-'a'] = new Node();
            }
            curr = curr.childrens[ch-'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        Node curr = root;
        return search(word, 0, curr);
    }

    private boolean search(String word, int index, Node curr){
        for(int i = index; i < word.length(); i++){
            char ch = word.charAt(i);
            if(ch != '.' && curr.childrens[ch-'a'] == null){
                return false;
            }else if(ch == '.'){
                for(int j = 0; j < 26; j++){
                    if(curr.childrens[j] != null){
                        if(search(word, i+1, curr.childrens[j])){
                            return true;
                        }
                    }
                }
                return false;
            }else{
                curr = curr.childrens[ch-'a'];
            }
        }
        return curr.isWord;
    }

}
