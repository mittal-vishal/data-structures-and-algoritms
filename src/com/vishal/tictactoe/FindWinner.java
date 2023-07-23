package com.vishal.tictactoe;

public class FindWinner {

    public String tictactoe(int[][] moves) {
        char[][] board = new char[3][3];
        int count = 0;
        for(int[] move: moves){
            int i = move[0];
            int j = move[1];
            if(count % 2 == 0){
                board[i][j] = 'X';
            }else{
                board[i][j] = 'O';
            }
            count++;
        }
        boolean isAWin = isWinner(board, 'X');
        boolean isBWin = isWinner(board, 'O');
        return isAWin? "A": isBWin? "B": isPending(board)? "Pending": "Draw";
    }

    private boolean isPending(char[][] board){
        boolean isComplete = true;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(board[i][j] != 'X' && board[i][j] != 'O'){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isWinner(char[][] board, char ch){
        boolean isPossible = false;
        for(int j = 0; j < 3; j++){
            isPossible = true;
            for(int i = 0; i < 3; i++){
                if(board[i][j] != ch){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible){
                return true;
            }
        }
        for(int i = 0; i < 3; i++){
            isPossible = true;
            for(int j = 0; j < 3; j++){
                if(board[i][j] != ch){
                    isPossible = false;
                    break;
                }
            }
            if(isPossible){
                return true;
            }
        }

        isPossible = true;
        for(int i = 0; i < 3; i++){
            if(board[i][i] != ch){
                isPossible = false;
                break;
            }
        }
        if(isPossible){
            return true;
        }

        isPossible = true;
        for(int i = 0; i < 3; i++){
            if(board[i][2-i] != ch){
                isPossible = false;
                break;
            }
        }
        if(isPossible){
            return true;
        }

        return false;
    }

}
