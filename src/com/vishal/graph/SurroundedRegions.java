package com.vishal.graph;

public class SurroundedRegions {

    public void solve(char[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 1; i < rows - 1; i++){
            for(int j = 1; j < cols - 1; j++){
                if(!visited[i][j] && board[i][j] == 'O'){
                    boolean isSurrounded = dfs(i, j, board, visited);
                    if(isSurrounded){
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

    private boolean dfs(int i, int j, char[][] board, boolean[][] visited){
        if(!isValid(i, j, board)){
            return false;
        }
        if(!visited[i][j] && board[i][j] == 'O'){
            visited[i][j] = true;
            boolean up = dfs(i - 1, j, board, visited);
            boolean down = dfs(i + 1, j, board, visited);
            boolean left = dfs(i, j - 1, board, visited);
            boolean right = dfs(i, j + 1, board, visited);
            if(!up || !down || !left || !right){
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int i, int j, char[][] board){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        if((i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) && board[i][j] == 'O'){
            return false;
        }
        return true;
    }

}
