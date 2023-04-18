package com.vishal.graph;

public class SurroundedRegions {

    public void solve(char[][] board) {
        //first row
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for(int j = 0; j < col; j++){
            if(board[0][j] == 'O' && !visited[0][j]) dfs(board, 0, j, visited);
        }
        //left col
        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O' && !visited[i][0]) dfs(board, i, 0, visited);
        }
        //last row
        for(int j = 0; j < col; j++){
            if(board[row-1][j] == 'O' && !visited[row-1][j]) dfs(board, row-1, j, visited);
        }
        //right col
        for(int i = 0; i < row; i++){
            if(board[i][col-1] == 'O' && !visited[i][col-1]) dfs(board, i, col-1, visited);
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited){
        if(!isValid(i, j, board)){
            return;
        }
        visited[i][j] = true;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int k = 0; k < dirs.length; k++){
            int newRow = i + dirs[k][0];
            int newCol = j + dirs[k][1];
            if(isValid(newRow, newCol, board) && !visited[newRow][newCol] && board[newRow][newCol] == 'O'){
                dfs(board, newRow, newCol, visited);
            }
        }
    }

    private boolean isValid(int i, int j, char[][] board){
        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length){
            return true;
        }
        return false;
    }

}
