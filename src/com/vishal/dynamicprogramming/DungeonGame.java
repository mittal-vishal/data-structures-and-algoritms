package com.vishal.dynamicprogramming;

public class DungeonGame {

    public int calculateMinimumHP(int[][] dungeon) {
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        return minimum(0, 0, dungeon, dp);
    }

    private int minimum(int i, int j, int[][] dungeon, int[][] dp){
        if(i == dungeon.length-1 && j == dungeon[i].length-1){
            return Math.max(1, 1-dungeon[i][j]);
        } else if(!isValid(i, j, dungeon)){
            return Integer.MAX_VALUE;
        }else if(dp[i][j] != 0){
            return dp[i][j];
        }
        int right = minimum(i, j+1, dungeon, dp);
        int down = minimum(i+1, j, dungeon, dp);
        return dp[i][j] = Math.max(1, Math.min(right, down) - dungeon[i][j]);
    }

    private boolean isValid(int i, int j, int[][] dungeon){
        if(i >= 0 && i < dungeon.length && j >= 0 && j < dungeon[i].length){
            return true;
        }else{
            return false;
        }
    }

}
