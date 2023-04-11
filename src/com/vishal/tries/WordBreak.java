package com.vishal.tries;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBreak {

    static class Node{
        Node[] childrens;
        boolean isWord;
        public Node(){
            childrens = new Node[26];
        }
    }

    private static Node root;

    public static int wordBreak(String A, ArrayList<String> B ) {
        root = new Node();
        for(String word: B){
            insert(word);
        }
        return isExist(root, A, 0) ? 1: 0;
    }

    private static boolean isExist(Node curr, String s, int pos){
        if(pos >= s.length()){
            return true;
        }
        for(int i = pos; i < s.length(); i++){
            char ch = s.charAt(i);
            if(curr.childrens[ch-'a'] != null && curr.childrens[ch-'a'].isWord && isExist(root, s, i+1)){
                return true;
            }
            if(curr.childrens[ch-'a'] == null){
                return false;
            }else if(curr.childrens[ch-'a'] != null){
                curr = curr.childrens[ch-'a'];
            }else{
                return false;
            }
        }
        return curr.isWord;
    }

    private static void insert(String word){
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

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>(Arrays.asList("lrbbmqb", "owkk", "cd", "r"));
        String word = "lrbbmqbabowkkab";
        int res = wordBreak(word, words);
        System.out.println(res);
    }

}
