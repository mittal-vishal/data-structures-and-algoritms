package com.vishal.tries;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    class Node{
        Node[] children;
        String word;
        public Node(){
            children = new Node[26];
        }
    }

    private Node root;

    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        for(String word: words){
            insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        List<String> result = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(i, j, board, result, root);
            }
        }
        return result;
    }

    private void dfs(int i, int j, char[][] board, List<String> result, Node curr){
        char ch = board[i][j];
        if(board[i][j] == '#' || curr.children[ch-'a'] == null){
            return;
        }
        curr = curr.children[ch-'a'];
        if(curr.word != null){
            result.add(curr.word);
            curr.word = null;
        }
        board[i][j] = '#';
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int[] dir: dirs){
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if(isValid(newRow, newCol, board)){
                dfs(newRow, newCol, board, result, curr);
            }
        }
        board[i][j] = ch;
    }

    private void insert(String s){
        Node curr = root;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(curr.children[ch-'a'] == null){
                curr.children[ch-'a'] = new Node();
            }
            curr = curr.children[ch-'a'];
        }
        curr.word = s;
    }

    private boolean isValid(int i, int j, char[][] board){
        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length){
            return true;
        }
        return false;
    }

}
