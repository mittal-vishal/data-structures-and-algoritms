package com.vishal.tries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode{
    char ch;
    boolean isEnd;
    TreeNode[] childrens;
    public TreeNode(){
        this.ch = '\0';
        this.childrens = new TreeNode[26];
    }
}

public class ConcatenatedWords {
    private TreeNode root;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length()-b.length());
        root = new TreeNode();
        List<String> returnList = new ArrayList<>();
        for(String word: words){
            if(isExist(word, root, 0)){
                returnList.add(word);
            }else{
                addWord(word);
            }
        }
        return returnList;
    }

    private boolean isExist(String word, TreeNode root, int index){
        TreeNode curr = root;
        for(int i = index; i < word.length(); i++){
            char ch = word.charAt(i);
            if(curr.childrens[ch-'a'] == null){
                return false;
            }
            if(curr.childrens[ch-'a'].isEnd){
                if(i == word.length() - 1){
                    return true;
                }else if(isExist(word, root, i + 1)){
                    return true;
                }
            }
            curr = curr.childrens[ch-'a'];
        }

        return false;
    }

    private void addWord(String word){
        TreeNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(curr.childrens[ch-'a'] == null){
                curr.childrens[ch-'a'] = new TreeNode();
            }
            curr = curr.childrens[ch-'a'];
        }
        curr.isEnd = true;
    }

    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        ConcatenatedWords concatenatedWords = new ConcatenatedWords();
        List<String> concatWordsList = concatenatedWords.findAllConcatenatedWordsInADict(words);
        System.out.print(concatWordsList);
    }
}
