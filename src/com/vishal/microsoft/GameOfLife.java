package com.vishal.microsoft;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int[][] copyBoard = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                copyBoard[i][j] = board[i][j];
            }
        }
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int neighLiveCells = 0;
                int neighDeadCells = 0;
                for(int k = 0; k < 8; k++){
                    int[] currDir = dirs[k];
                    int newI = i + currDir[0];
                    int newJ = j + currDir[1];
                    if(isValid(newI, newJ, row, col)){
                        if(copyBoard[newI][newJ] == 1){
                            neighLiveCells++;
                        }else{
                            neighDeadCells++;
                        }
                    }
                }
                if(copyBoard[i][j] == 1 && !(neighLiveCells == 2 || neighLiveCells == 3)){
                    board[i][j] = 0;
                }else if(copyBoard[i][j] == 0 && neighLiveCells == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    private boolean isValid(int i, int j, int row, int col){
        if(i >= 0 && i < row && j >= 0 && j < col){
            return true;
        }
        return false;
    }

}
