package com.vishal.amazon;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                int up = i-1 >= 0 && grid[i-1][j] == 1 ? 1 : 0;
                int down = i+1 < m && grid[i+1][j] == 1 ? 1 : 0;
                int left = j-1 >= 0 && grid[i][j-1] == 1 ? 1 : 0;
                int right = j+1 < n && grid[i][j+1] == 1 ? 1 : 0;
                result += (4 - (up+down+left+right));
            }
        }
        return result;
    }

}
