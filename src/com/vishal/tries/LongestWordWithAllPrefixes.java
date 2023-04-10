package com.vishal.tries;

import java.util.Arrays;

public class LongestWordWithAllPrefixes {

    class Node{
        Node[] childrens;
        boolean isWord;
        public Node(){
            childrens = new Node[26];
        }
    }

    private Node root;

    public String longestWord(String[] words) {
        root = new Node();
        Arrays.sort(words);
        String result = "";
        for(String word: words){
            int prefixCount = insert(word);
            if(prefixCount == word.length() - 1 && word.length() > result.length()){
                result = word;
            }
        }
        return result;
    }

    private int insert(String word){
        int prefixCount = 0;
        Node curr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(curr.childrens[ch-'a'] != null && curr.childrens[ch-'a'].isWord){
                prefixCount++;
            }else{
                curr.childrens[ch-'a'] = new Node();
            }
            curr = curr.childrens[ch-'a'];
        }
        curr.isWord = true;
        return prefixCount;
    }
}
