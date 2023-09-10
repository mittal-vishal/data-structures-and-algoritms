package com.vishal.backtracking;

import java.util.HashSet;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];
        for(int i = 0; i < 9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char currNum = board[i][j];
                if(currNum != '.'){
                    //validate row
                    if(rows[i].contains(currNum)){
                        return false;
                    }
                    rows[i].add(currNum);
                    //validate col
                    if(cols[j].contains(currNum)){
                        return false;
                    }
                    cols[j].add(currNum);
                    //validate box
                    int boxIndex = (i/3)*3+(j/3);
                    if(boxes[boxIndex].contains(currNum)){
                        return false;
                    }
                    boxes[boxIndex].add(currNum);
                }
            }
        }
        return true;
    }

}
