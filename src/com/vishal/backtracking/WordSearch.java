package com.vishal.backtracking;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0){
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, i , j, 0, word, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int idx, String word, boolean[][] visited){
        if(idx == word.length()){
            return true;
        }
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        if(isValid(i, j, board) && !visited[i][j] && board[i][j] == word.charAt(idx)){
            visited[i][j] = true;
            boolean isPossible = false;
            for(int[] dir: dirs){
                int newRow = i + dir[0];
                int newCol = j + dir[1];
                isPossible = isPossible || dfs(board, newRow, newCol, idx+1, word, visited);
            }
            visited[i][j] = false;
            return isPossible;
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
