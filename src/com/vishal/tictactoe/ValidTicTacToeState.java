package com.vishal.tictactoe;

public class ValidTicTacToeState {

    private int xCount;
    private int oCount;

    public boolean validTicTacToe(String[] board) {
        doCounts(board);
        if((xCount-oCount) != 0 && (xCount-oCount) != 1){
            return false;
        }
        boolean xWins = isWinner(board, 'X');
        boolean oWins = isWinner(board, 'O');
        if(xWins && oWins){
            return false;
        }else if(xWins && (xCount-oCount) != 1){
            return false;
        }else if(oWins && (xCount-oCount) != 0){
            return false;
        }
        return true;
    }

    private void doCounts(String[] board){
        for(String line: board){
            for(int i = 0; i < line.length(); i++){
                if(line.charAt(i) == 'X'){
                    xCount++;
                }else if(line.charAt(i) == 'O'){
                    oCount++;
                }
            }
        }
    }

    private boolean isWinner(String[] board, char ch){
        char[][] charBoard = new char[3][3];
        for(int i = 0; i < board.length; i++){
            charBoard[i] = board[i].toCharArray();
        }
        boolean isPossible = false;
        for(int j = 0; j < 3; j++){
            isPossible = true;
            for(int i = 0; i < 3; i++){
                if(charBoard[i][j] != ch){
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
                if(charBoard[i][j] != ch){
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
            if(charBoard[i][i] != ch){
                isPossible = false;
                break;
            }
        }
        if(isPossible){
            return true;
        }

        isPossible = true;
        for(int i = 0; i < 3; i++){
            if(charBoard[i][2-i] != ch){
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
