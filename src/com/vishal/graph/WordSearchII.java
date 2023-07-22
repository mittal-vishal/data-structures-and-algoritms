package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        WordSearchII wordSearchII = new WordSearchII();
        List<String> result = wordSearchII.findWords(board, words);
        System.out.println(result);
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> wordsExistList = new ArrayList<>();
        for(String word: words){
            if(exist(board, word)){
                wordsExistList.add(word);
            }
        }
        return wordsExistList;
    }

    private boolean exist(char[][] board, String word) {
        boolean isExist = false;
        if(board == null || board.length == 0){
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, i , j, 0, word, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int idx, String word, boolean[][] visited){
        if(idx == word.length()){
            return true;
        }
        if(isValid(i, j, board) && !visited[i][j]){
            if(word.charAt(idx) == board[i][j]){
                visited[i][j] = true;
                boolean left = dfs(board, i, j-1, idx+1, word, visited);
                boolean right = dfs(board, i, j+1, idx+1, word, visited);
                boolean up = dfs(board, i-1, j, idx+1, word, visited);
                boolean down = dfs(board, i+1, j, idx+1, word, visited);
                if(left || right || up || down){
                    return true;
                }
                visited[i][j] = false;
            }
        }
        return false;
    }

    private boolean isValid(int i , int j, char[][] board){
        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length){
            return true;
        }else{
            return false;
        }
    }

}
