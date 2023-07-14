package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        int[][] board = new int[n][n];
        solve(board, 0, results);
        return results;
    }

    private void solve(int[][] board, int col, List<List<String>> results){
        if(col == board.length){
            List<String> result = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == 1){
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                result.add(sb.toString());
            }
            results.add(result);
            return;
        }
        for(int row = 0; row < board.length; row++){
            if(isPossible(row, col, board)){
                board[row][col] = 1;
                solve(board, col+1, results);
                board[row][col] = 0;
            }
        }
    }

    private boolean isPossible(int i, int j, int[][] board){
        //left horizontal
        int row = i;
        int col = j;
        while(col >= 0){
            if(board[row][col] == 1){
                return false;
            }
            col--;
        }
        //left upper diagonal
        row = i;
        col = j;
        while(row >= 0 && col >= 0){
            if(board[row][col] == 1){
                return false;
            }
            row--;
            col--;
        }
        //left lower diagonal
        row = i;
        col = j;
        while(row < board.length && col >= 0){
            if(board[row][col] == 1){
                return false;
            }
            row++;
            col--;
        }
        return true;
    }

}
