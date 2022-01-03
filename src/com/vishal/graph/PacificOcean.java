package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;

public class PacificOcean {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights == null || heights[0].length == 0){
            return new ArrayList<>();
        }
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        //populate pacific and atlantic for top and bottom
        for(int i = 0; i < cols; i++){
            dfs(0, i, heights, pacific, Integer.MIN_VALUE);
            dfs(rows - 1, i, heights, atlantic, Integer.MIN_VALUE);
        }
        //populate pacific and atlantic for left and right side
        for(int i = 0; i < rows; i++){
            dfs(i, 0, heights, pacific, Integer.MIN_VALUE);
            dfs(i, cols - 1, heights, atlantic, Integer.MIN_VALUE);
        }
        List<List<Integer>> cordinates = new ArrayList<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> cordinate = new ArrayList<>();
                    cordinate.add(i);
                    cordinate.add(j);
                    cordinates.add(cordinate);
                }
            }
        }
        return cordinates;
    }

    private void dfs(int i, int j, int[][] heights, boolean[][] ocean, int prev){
        if(!isValid(i, j, heights)){
            return;
        }else if(heights[i][j] < prev){
            return;
        }else if(ocean[i][j]){
            return;
        }
        ocean[i][j] = true;
        dfs(i - 1, j, heights, ocean, heights[i][j]);
        dfs(i + 1, j, heights, ocean, heights[i][j]);
        dfs(i, j - 1, heights, ocean, heights[i][j]);
        dfs(i, j + 1, heights, ocean, heights[i][j]);
    }

    private boolean isValid(int i, int j, int[][]heights){
        if(i >= 0 && i < heights.length && j >= 0 && j < heights[0].length){
            return true;
        }
        return false;
    }

}
