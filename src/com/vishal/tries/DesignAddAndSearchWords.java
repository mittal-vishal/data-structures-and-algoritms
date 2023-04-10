package com.vishal.tries;

public class DesignAddAndSearchWords {

    class Node{
        Node[] childrens;
        boolean isEnd;
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
        curr.isEnd = true;
    }

    public boolean search(String word){
        char[] words = word.toCharArray();
        Node curr = root;
        return search(curr, words, 0);
    }

    public boolean search(Node curr, char[] words, int beg) {
        for(int i = beg; i < words.length; i++){
            char ch = words[i];
            if(ch == '.'){
                for(int j = 0; j < 26; j++){
                    if(curr.childrens[j] != null){
                        if(search(curr.childrens[j], words, i+1)){
                            return true;
                        }
                    }
                }
                return false;
            }else{
                if(curr.childrens[ch-'a'] == null){
                    return false;
                }
                curr = curr.childrens[ch-'a'];
            }
        }
        return curr.isEnd;
    }

}
