package com.vishal.backtracking;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
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
