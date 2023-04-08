package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class WaysToCutPizza {

    private int MOD = 1000000007;

    public int ways(String[] pizza, int k) {
        int numRows = pizza.length;
        int numCols = pizza[0].length();
        if(!hasApple(pizza, 0, numRows-1, 0, numCols-1)){
            return 0;
        }
        int[][][]dp = new int[numRows][numCols][k];
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        int ans = waysToCutPizza(pizza, 0, 0, k - 1, dp);
        return ans;
    }

    private int waysToCutPizza(String[] pizza, int startRow, int startCol, int cutsLeft, int[][][]dp) {
        int numRows = pizza.length - 1;
        int numCols = pizza[0].length() - 1;
        if (cutsLeft == 0){
            return 1;
        }else if(dp[startRow][startCol][cutsLeft] != -1){
            return dp[startRow][startCol][cutsLeft];
        }
        int ans = 0;
        //make a cut below the row with index 'row'
        for (int row = startRow; row < numRows; row++) {
            boolean upperHalfHasApple = hasApple(pizza, startRow, row, startCol, numCols);
            boolean lowerHalfHasApple = hasApple(pizza, row + 1, numRows, startCol, numCols);
            //give away upper half
            if (upperHalfHasApple && lowerHalfHasApple) {
                int nextWays = waysToCutPizza(pizza, row + 1, startCol, cutsLeft - 1, dp); //cut lower half
                ans = (ans + nextWays) % MOD;
            }
        }
        //make a cut to the right of column with index 'col'
        for (int col = startCol; col < numCols; col++) {
            boolean leftHalfHasApple = hasApple(pizza, startRow, numRows, startCol, col);
            boolean rightHalfHasApple = hasApple(pizza, startRow, numRows, col + 1, numCols);
            //give away left half
            if (leftHalfHasApple && rightHalfHasApple) {
                int nextWays = waysToCutPizza(pizza, startRow, col + 1, cutsLeft - 1, dp); //cut right half
                ans = (ans + nextWays) % MOD;
            }
        }
        dp[startRow][startCol][cutsLeft] = ans;
        return dp[startRow][startCol][cutsLeft];
    }

    private boolean hasApple(String[] pizza, int startRow, int endRow, int startCol, int endCol) {
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (pizza[i].charAt(j) == 'A')
                    return true;
            }
        }
        return false;
    }

}
