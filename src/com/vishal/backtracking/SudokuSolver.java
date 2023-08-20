package com.vishal.backtracking;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == '.'){
                    for(char ch = '1'; ch <= '9'; ch++){
                        if(isPossible(i, j, ch, board)){
                            board[i][j] = ch;
                            if(solve(board)){
                                return true;
                            }
                            //backtrack
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isPossible(int i, int j, char ch, char[][] board){
        for(int k = 0; k < 9; k++){
            //check for row
            if(board[i][k] == ch){
                return false;
            }
            //check for col
            if(board[k][j] == ch){
                return false;
            }
            //check for submatrix
            if(board[3*(i/3)+(k/3)][3*(j/3)+(k%3)] == ch){
                return false;
            }
        }
        return true;
    }

}
