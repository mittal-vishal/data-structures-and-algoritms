package com.vishal.arrays;

public class SpecialPosInBinaryMatrix {

    public int numSpecial(int[][] mat) {
        int specialPos = 0;
        int specialJ = -1;
        int specialI = -1;
        for(int i = 0; i < mat.length; i++){
            boolean isSpecial = true;
            int occuranceCount = 0;
            for(int j = 0; j < mat[i].length; j++){
                if(mat[i][j] == 1){
                    occuranceCount++;
                    specialJ = j;
                    specialI = i;
                }
            }
            if(occuranceCount == 1){
                for(int k = 0; k < mat.length; k++){
                    if(k != specialI && mat[k][specialJ] != 0){
                        isSpecial = false;
                    }
                }
            }else{
                isSpecial = false;
            }
            if(isSpecial){
                specialPos++;
            }
        }
        return specialPos;
    }

}
