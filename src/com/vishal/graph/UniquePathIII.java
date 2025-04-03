package com.vishal.graph;

public class UniquePathIII {

    private int emptyCellCount;
    private final int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

    public int uniquePathsIII(int[][] grid) {
        //initialize graph
        int m = grid.length;
        int n = grid[0].length;
        int[] source = null;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    source = new int[]{i,j};
                }else if (grid[i][j] == 0){
                    emptyCellCount++;
                }
            }
        }
        boolean[][] visited = new boolean[m][n];
        return dfs(grid, source[0], source[1], 0, visited);
    }

    private int dfs(int[][] grid, int i, int j, int emptyCount, boolean[][] visited){
        if(!isValid(i, j, grid) || grid[i][j] == -1 || visited[i][j]){
            return 0;
        }else if(grid[i][j] == 2 && emptyCount-1 == emptyCellCount){
            return 1;
        }
        visited[i][j] = true;
        int result = 0;
        for(int[] dir: dirs){
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            result += dfs(grid, newRow, newCol, emptyCount+1, visited);
        }
        visited[i][j] = false;
        return result;
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[i].length){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        UniquePathIII uniquePathIII = new UniquePathIII();
        System.out.println(uniquePathIII.uniquePathsIII(grid));
    }

}
