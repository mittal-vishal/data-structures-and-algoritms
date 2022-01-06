package com.vishal.graph;

public class SurroundedRegions {

    private boolean isSurrounded;
    public void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 1; i < rows - 1; i++){
            for(int j = 1; j < cols - 1; j++){
                if(!visited[i][j] && board[i][j] == 'O'){
                    this.isSurrounded = true;
                    dfs(i, j, board, visited);
                    if(this.isSurrounded){
                        mark(i, j, board);
                    }
                }
            }
        }
    }

    private void mark(int i, int j, char[][] board){
        if(isValid(i, j, board) && board[i][j] == 'O'){
            board[i][j] = 'X';
            mark(i - 1, j, board);
            mark(i + 1, j, board);
            mark(i, j - 1, board);
            mark(i, j + 1, board);
        }
    }

    private void dfs(int i, int j, char[][] board, boolean[][] visited){
        if(!isValid(i, j, board) || visited[i][j] || board[i][j] != 'O'){
            return;
        }
        if((i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) && board[i][j] != 'X'){
            this.isSurrounded = false;
            return;
        }
        visited[i][j] = true;
        dfs(i - 1, j, board, visited);
        dfs(i + 1, j, board, visited);
        dfs(i, j + 1, board, visited);
        dfs(i, j - 1, board, visited);
    }

    private boolean isValid(int i, int j, char[][] board){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        return true;
    }

}
