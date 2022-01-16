package com.vishal.google;

public class RemoveOnesFlipping10 {

    public boolean removeOnes(int[][] grid) {
        if(grid.length < 2){
            return true;
        }
        int m = grid.length;
        int n = grid[0].length;
        for(int rows = 1; rows < m; rows++){
            boolean isSame = true;
            if(grid[rows-1][0] != grid[rows][0]){
                isSame = false;
            }
            for(int cols = 1; cols < n; cols++){
                if(grid[rows-1][cols] == grid[rows][cols] && !isSame){
                    return false;
                }else if(grid[rows-1][cols] != grid[rows][cols] && isSame){
                    return false;
                }
            }
        }
        return true;
    }

}
