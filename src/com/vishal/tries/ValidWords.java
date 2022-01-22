package com.vishal.tries;

import java.util.*;

public class ValidWords {

    static class TrieNode{
        Map<Character,TrieNode> children;
        boolean isWord;

        public TrieNode(){
            children = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        System.out.println(new ValidWords().getPossibleInputs("can s r n ", Arrays.asList("can", "canes", "serene", "rene", "sam")));
        System.out.println(new ValidWords().getPossibleInputs("i lik  to  xplor  univ rs ", Arrays.asList("i", "like", "explore", "to", "universe", "rse")));
    }

    public List<String> getPossibleInputs(String s, List<String> dict){
        List<String> res =  new ArrayList<>();
        TrieNode root = new TrieNode();

        buildTrie(root,dict);
        getPossibleStrings(0,s,new StringBuilder(),root,res);
        return res;
    }

    private void getPossibleStrings(int pos, String s, StringBuilder sb, TrieNode root, List<String> res){

        TrieNode curr = root;
        for(int i=pos; i<s.length();i++){
            char c = s.charAt(i);
            Map<Character,TrieNode> children = curr.children;
            if(c == ' '){
                if(curr.isWord){
                    int size = sb.length();
                    sb.append(' ');
                    getPossibleStrings(i+1,s,sb,root,res);
                    sb.setLength(size);
                    c = 'e';
                }else{
                    c = 'e';
                }
            }

            if(children.containsKey(c)){
                sb.append(c);
                curr = children.get(c);
            }else{
                return;
            }
        }

        if(curr.isWord){
            res.add(sb.toString());
        }
    }

    private void buildTrie(TrieNode root, List<String> dict){
        for(String s : dict){
            TrieNode curr = root;
            for(char c : s.toCharArray()){
                Map<Character,TrieNode> children = curr.children;
                children.putIfAbsent(c,new TrieNode());
                curr = children.get(c);
            }
            curr.isWord = true;
        }
    }
}