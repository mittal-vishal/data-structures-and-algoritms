package com.vishal.backtracking;

/*
* Round 5: DSA (Hard)
Problem: Longest Constrained Path in a Matrix
You are given an m x n grid of positive integers.
Rules:
You can start from any cell.
Move in 4 directions (up, down, left, right).
From A → B: grid[B] <= A
From B → C: grid[C] <= B OR grid[C] <= A
Cannot revisit cells.

Input: grid = [[10, 4, 8],
               [2, 9, 3]]
Output: 6
Explanation: 10 -> 2 -> 9 -> 4 -> 8 -> 3
* */

public class LongestConstrainedPath {

    private final int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};

    public static void main(String[] args) {
        int[][] grid = {{10,4,8},{2,9,3}};
        LongestConstrainedPath path = new LongestConstrainedPath();
        int res = path.getLongestPath(grid);
        System.out.println(res);
    }

    private int getLongestPath(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int longestPath = dfs(i, j, grid, -1, visited);
                res = Math.max(res, longestPath);
            }
        }
        return res;
    }

    private int dfs(int i, int j, int[][] grid, int prev, boolean[][] visited) {
        visited[i][j] = true;
        int path = 0;
        for(int[] dir: dirs){
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if(isValid(newRow, newCol, grid) && !visited[newRow][newCol]){
                boolean canMove = false;
                if(prev == -1 && grid[newRow][newCol] <= grid[i][j]){
                    canMove = true;
                }else if(grid[newRow][newCol] <= grid[i][j] || grid[newRow][newCol] <= prev){
                    canMove = true;
                }
                if(canMove){
                    path = Math.max(path, dfs(newRow, newCol, grid, grid[i][j], visited));
                }
            }
        }
        visited[i][j] = false;
        return 1 + path;
    }

    private boolean isValid(int i, int j, int[][] grid){
        return i >= 0 && i < grid.length && j >= 0 && j < grid[i].length;
    }
}
