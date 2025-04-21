package com.vishal.tries;

import java.util.ArrayList;
import java.util.List;

public class SearchSuggestionSystem {

    static class Node{
        String word;
        Node childrens[];
        public Node(){
            childrens = new Node[26];
        }
    }

    private Node root;

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new Node();
        for(String product: products){
            insert(product);
        }
        List<List<String>> results = new ArrayList<>();
        for(int i = 0; i < searchWord.length(); i++){
            Node curr = root;
            List<String> result = new ArrayList<>();
            getTopKResult(curr, result, i, searchWord);
            results.add(result);
        }
        return results;
    }

    private void getTopKResult(Node curr, List<String> result, int i, String searchWord){
        if(curr == null){
            return;
        }
        for(int j = 0; j <= i; j++){
            if(curr.childrens[searchWord.charAt(j) - 'a'] == null){
                return;
            }
            curr = curr.childrens[searchWord.charAt(j) - 'a'];
        }
        dfs(curr, result);
    }

    private void dfs(Node curr, List<String> result){
        if(curr == null || result.size() == 3){
            return;
        }
        if(curr.word != null){
            result.add(curr.word);
        }
        for(int i = 0; i < 26; i++){
            if(curr.childrens[i] != null){
                dfs(curr.childrens[i], result);
            }
        }
    }

    private void insert(String prod){
        Node curr = root;
        for(char ch: prod.toCharArray()){
            if(curr.childrens[ch-'a'] == null){
                curr.childrens[ch-'a'] = new Node();
            }
            curr = curr.childrens[ch-'a'];
        }
        curr.word = prod;
    }

}
