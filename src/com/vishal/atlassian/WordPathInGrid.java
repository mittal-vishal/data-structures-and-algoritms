package com.vishal.atlassian;


/*
* You're working on a word search problem, where you need to find
* the path of a given word in a 2D character grid.
* The goal is to return the list of coordinates (row, column) corresponding to the letters forming the word,
* if the word is present in the grid.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordPathInGrid {

    public static void main(String[] args) {
        char[][] grid1 = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        };

        System.out.print("abc: ");
        printPath(findWord(grid1, "abc"));  // Expected: [(1,1), (1,2), (1,3), (2,3), (3,3), (3,4)]

        System.out.print("ghi: ");
        printPath(findWord(grid1, "ghi")); // Expected: [(0,2), (0,3), (0,4), (0,5), (0,6), (0,7), (1,7)]
    }

    public static List<int[]> findWord(char[][] grid, String word) {
        List<int[]> result = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(word.charAt(0) == grid[i][j] && dfs(i, j, grid, word, 0, result, visited)){
                    return result;
                }
            }
        }
        return Collections.emptyList();
    }

    private static boolean dfs(int i, int j, char[][] grid, String word, int index, List<int[]> result, boolean[][] visited) {
        int[][] dirs = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
        if(index == word.length()){
            return true;
        }else if(!isValid(i, j, grid) || visited[i][j] || word.charAt(index) != grid[i][j]){
            return false;
        }
        result.add(new int[]{i,j});
        visited[i][j] = true;
        for(int[] dir: dirs){
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if(dfs(newRow, newCol, grid, word, index+1, result, visited)){
                return true;
            }
        }
        result.remove(result.size()-1);
        visited[i][j] = false;
        return false;
    }

    private static boolean isValid(int i, int j, char[][] grid) {
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[i].length){
            return true;
        }else{
            return false;
        }
    }

    private static void printPath(List<int[]> path) {
        for (int[] coord : path) {
            System.out.print(Arrays.toString(coord) + " ");
        }
        System.out.println();
    }

}
