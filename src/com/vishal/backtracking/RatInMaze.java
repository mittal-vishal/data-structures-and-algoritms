package com.vishal.backtracking;

import java.util.ArrayList;

public class RatInMaze {

    public static ArrayList<String> findPath(int[][] m, int n) {
        if(m == null || m.length == 0 || m[0].length == 0 || m[0][0] == 0){
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        backtrack(0, 0, n, "", result, m, visited);
        return result;
    }

    private static void backtrack(int i, int j, int n, String ans, ArrayList<String> result, int[][] m, boolean[][] visited){
        if(i == n-1 && j == n-1){
            result.add(ans);
            return;
        }
        String path = "DLRU";
        int[][] dirs = {{1,0},{0,-1},{0,1},{-1,0}};
        for(int k = 0; k < dirs.length; k++){
            int newRow = i + dirs[k][0];
            int newCol = j + dirs[k][1];
            if(isValid(newRow, newCol, n) && m[newRow][newCol] == 1 && !visited[newRow][newCol]){
                visited[i][j] = true;
                backtrack(newRow, newCol, n, ans+path.charAt(k), result, m, visited);
                visited[i][j] = false;
            }
        }
    }

    private static boolean isValid(int i, int j, int n){
        if(i >= 0 && i < n && j >= 0 && j < n){
            return true;
        }
        return false;
    }

}
