package com.vishal.tries;

public class MagicDictionary {

    class Node{
        Node[] childrens;
        boolean isWord;
        public Node(){
            childrens = new Node[26];
        }
    }

    private Node root;

    public MagicDictionary() {
        root = new Node();
    }

    public void buildDict(String[] dictionary) {
        for(String word: dictionary){
            insert(word);
        }
    }

    private void insert(String word){
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

    public boolean search(String searchWord) {
        Node curr = root;
        char[] s = searchWord.toCharArray();
        for(int i = 0; i < s.length; i++){
            char ch = s[i];
            for(int j = 0; j < 26; j++){
                if(j == ch-'a'){
                    continue;
                }
                s[i] = (char)('a' + j);
                if(isExist(s)){
                    return true;
                }
            }
            s[i] = ch;
        }
        return false;
    }

    private boolean isExist(char[] s){
        Node curr = root;
        for(int i = 0; i < s.length; i++){
            char ch = s[i];
            if(curr.childrens[ch-'a'] == null){
                return false;
            }
            curr = curr.childrens[ch-'a'];
        }
        return curr.isWord;
    }

}
