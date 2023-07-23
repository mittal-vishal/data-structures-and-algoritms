package com.vishal.tictactoe;

public class DesignTicTacToe {

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;
    private int n;

    public DesignTicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        int increment = 1;
        if(player == 2){
            increment = -1;
        }
        rows[row] += increment;
        if(rows[row] == n || rows[row] == -n){
            return player;
        }
        cols[col] += increment;
        if(cols[col] == n || cols[col] == -n){
            return player;
        }
        if(row == col){
            diagonal += increment;
            if(diagonal == n || diagonal == -n){
                return player;
            }
        }
        if(row+col == n-1){
            antiDiagonal += increment;
            if(antiDiagonal == n || antiDiagonal == -n){
                return player;
            }
        }
        return 0;
    }

}
