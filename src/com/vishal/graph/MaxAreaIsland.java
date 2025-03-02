package com.vishal.graph;

public class MaxAreaIsland {

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        MaxAreaIsland maxAreaIsland = new MaxAreaIsland();
        int ans = maxAreaIsland.maxAreaOfIsland(grid);
        System.out.println(ans);
    }

    private int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int area = dfs(i, j, grid);
                    result = Math.max(result, area);
                }
            }
        }
        return result;
    }

    private int dfs(int i, int j, int[][] grid){
        if(!isValid(i, j, grid) || grid[i][j] == 0){
            return 0;
        }
        //mark current as visited
        grid[i][j] = 0;
        int area = 1;
        for(int[] dir: dirs){
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            area += dfs(newRow, newCol, grid);
        }
        return area;
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[i].length){
            return true;
        }else{
            return false;
        }
    }

}
