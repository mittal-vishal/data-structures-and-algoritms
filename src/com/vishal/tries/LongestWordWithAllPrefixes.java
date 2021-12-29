package com.vishal.tries;

import java.util.Arrays;

public class LongestWordWithAllPrefixes {

    static class Node{
        Node[] childrens;
        boolean isEnd;
        public Node(){
            this.childrens = new Node[26];
            this.isEnd = false;
        }
    }

    private Node root;

    public String longestWord(String[] words) {
        root = new Node();
        Arrays.sort(words);
        String longestWord = "";
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            int prefixCount = insert(word);
            if(prefixCount == word.length() - 1 && word.length() > longestWord.length()){
                longestWord = word;
            }
        }
        return longestWord;
    }

    private int insert(String word){
        Node curr = root;
        int prefixCount = 0;
        for(int i = 0; i < word.length(); i++){
            char currChar = word.charAt(i);
            if(curr.childrens[currChar-'a'] != null && curr.childrens[currChar-'a'].isEnd){
                prefixCount++;
            }else if(curr.childrens[currChar-'a'] != null && !curr.childrens[currChar-'a'].isEnd){
                return 0;
            }else{
                curr.childrens[currChar-'a'] = new Node();
            }
            curr = curr.childrens[currChar-'a'];
        }
        curr.isEnd = true;
        return prefixCount;
    }
}
