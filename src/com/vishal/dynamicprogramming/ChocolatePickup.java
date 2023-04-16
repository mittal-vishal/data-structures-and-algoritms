package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class ChocolatePickup {

    private static int INT_MIN = -100000000;
    public static int maximumChocolates(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return maximumChocolates(0, 0, c-1, grid, dp);
    }

    private static int maximumChocolates(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        if(j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length){
            return INT_MIN;
        }else if(i == grid.length-1){
            if(j1 == j2){
                return grid[i][j1];
            }else{
                return grid[i][j1] + grid[i][j2];
            }
        }else if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }
        int answer = INT_MIN;
        for(int dc1 = -1; dc1 <= 1; dc1++){
            for(int dc2 = -1; dc2 <= 1; dc2++){
                int maximum = 0;
                if(j1 == j2){
                    maximum = grid[i][j1] + maximumChocolates(i+1, j1+dc1, j2+dc2 , grid, dp);
                }else{
                    maximum =  grid[i][j1] + grid[i][j2] + maximumChocolates(i+1, j1+dc1, j2+dc2 , grid, dp);
                }
                answer = Math.max(answer, maximum);
            }
        }
        dp[i][j1][j2] = answer;
        return dp[i][j1][j2];
    }

    public static int maximumChocolatesTabulation(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        for(int j1 = 0; j1 < c; j1++){
            for(int j2 = 0; j2 < c; j2++){
                if(j1 == j2){
                    dp[r-1][j1][j2] = grid[r-1][j1];
                }else{
                    dp[r-1][j1][j2] = grid[r-1][j1] + grid[r-1][j2];
                }
            }
        }
        for(int i = r-2; i >= 0; i--){
            for(int j1 = 0; j1 < c; j1++){
                for(int j2 = 0; j2 < c; j2++){
                    int answer = INT_MIN;
                    for(int dc1 = -1; dc1 <= 1; dc1++){
                        for(int dc2 = -1; dc2 <= 1; dc2++){
                            int maximum = 0;
                            if(j1 == j2){
                                if((j1+dc1) >= 0 && (j2+dc2) >= 0 && (j1+dc1) < c && (j2+dc2) < c){
                                    maximum = grid[i][j1] + dp[i+1][j1+dc1][j2+dc2];
                                }else{
                                    maximum = INT_MIN;
                                }
                            }else{
                                if((j1+dc1) >= 0 && (j2+dc2) >= 0 && (j1+dc1) < c && (j2+dc2) < c){
                                    maximum =  grid[i][j1] + grid[i][j2] + dp[i+1][j1+dc1][j2+dc2];
                                }else{
                                    maximum = INT_MIN;
                                }
                            }
                            answer = Math.max(answer, maximum);
                        }
                    }
                    dp[i][j1][j2] = answer;
                }
            }
        }
        return dp[0][0][c-1];
    }

}
