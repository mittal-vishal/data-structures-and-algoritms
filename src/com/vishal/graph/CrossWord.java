package com.vishal.graph;

public class CrossWord {

    public boolean placeWordInCrossword(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        String reverseWord = new StringBuilder(word).reverse().toString();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == '#'){
                    continue;
                }
                if(horizontally(board, i, j, word)){
                    return true;
                }else if(horizontally(board, i, j, reverseWord)){
                    return true;
                }else if(vertically(board, i, j, word)){
                    return true;
                }else if(vertically(board, i, j, reverseWord)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean horizontally(char[][] board, int i, int j, String word){
        if(j > 0 && board[i][j-1] != '#'){
            return false;
        }
        for(char ch: word.toCharArray()){
            if(j == board[0].length){
                return false;
            }
            if(board[i][j] != ' ' && board[i][j] != ch){
                return false;
            }
            j++;
        }
        if(j < board[0].length && board[i][j] != '#'){
            return false;
        }
        return true;
    }

    private boolean vertically(char[][] board, int i, int j, String word){
        if(i > 0 && board[i-1][j] != '#'){
            return false;
        }
        for(char ch: word.toCharArray()){
            if(i == board.length){
                return false;
            }
            if(board[i][j] != ' ' && board[i][j] != ch){
                return false;
            }
            i++;
        }
        if(i < board.length && board[i][j] != '#'){
            return false;
        }
        return true;
    }

}
