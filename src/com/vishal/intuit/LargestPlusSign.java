package com.vishal.intuit;

import java.util.Arrays;

public class LargestPlusSign {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        buildGraph(grid, mines);
        int[][] lToR = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    lToR[i][j] = grid[i][j];
                }else if(grid[i][j] == 1){
                    lToR[i][j] = lToR[i][j-1]+grid[i][j];
                }else{
                    lToR[i][j] = 0;
                }
            }
        }
        int[][] rToL = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = n-1; j >= 0; j--){
                if(j == n-1){
                    rToL[i][j] = grid[i][j];
                }else if(grid[i][j] == 1){
                    rToL[i][j] = rToL[i][j+1] + grid[i][j];
                }else{
                    rToL[i][j] = 0;
                }
            }
        }
        int[][] tToB = new int[n][n];
        for(int j = 0; j < n; j++){
            for(int i = 0; i < n; i++){
                if(i == 0){
                    tToB[i][j] = grid[i][j];
                }else if(grid[i][j] == 1){
                    tToB[i][j] = tToB[i-1][j] + grid[i][j];
                }else{
                    tToB[i][j] = 0;
                }
            }
        }
        int[][] bToT = new int[n][n];
        for(int j = 0; j < n; j++){
            for(int i = n-1; i >= 0; i--){
                if(i == n-1){
                    bToT[i][j] = grid[i][j];
                }else if(grid[i][j] == 1){
                    bToT[i][j] = bToT[i+1][j] + grid[i][j];
                }else{
                    bToT[i][j] = 0;
                }
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int currRes = Math.min(rToL[i][j], Math.min(lToR[i][j], Math.min(tToB[i][j], bToT[i][j])));
                res = Math.max(res, currRes);
            }
        }
        return res;
    }

    private void buildGraph(int[][] grid, int[][] mines){
        for(int i = 0; i < grid.length; i++){
            Arrays.fill(grid[i], 1);
        }
        for(int[] mine: mines){
            grid[mine[0]][mine[1]] = 0;
        }
    }

}
