package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;

public class Minesweeper {

    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{-1,1},{1,1},{-1,-1},{1,-1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0];
        int j = click[1];
        boolean[][] visited = new boolean[board.length][board[0].length];
        visited[i][j] = true;
        if(board[i][j] == 'M'){
            board[i][j] = 'X';
        }else if(board[i][j] == 'E'){
            dfs(board, i, j, visited);
        }
        return board;
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited){
        char mines = '0';
        List<int[]> neighbours = new ArrayList<>();
        for(int[] dir: dirs){
            int newRow = i+dir[0];
            int newCol = j+dir[1];
            if(isValid(newRow, newCol, board) && board[newRow][newCol] == 'M'){
                mines++;
            }else if(isValid(newRow, newCol, board) && board[newRow][newCol] == 'E'){
                neighbours.add(new int[]{newRow, newCol});
            }
        }
        if(mines == '0'){
            board[i][j] = 'B';
        }else{
            board[i][j] = mines;
            return;
        }
        for(int[] neighbour: neighbours){
            if(!visited[neighbour[0]][neighbour[1]]){
                visited[neighbour[0]][neighbour[1]] = true;
                dfs(board, neighbour[0], neighbour[1], visited);
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
