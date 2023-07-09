package com.vishal.graph;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(image, sr, sc, image[sr][sc], color, visited);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor, boolean[][] visited){
        if(!isValid(sr, sc, image) || image[sr][sc] != oldColor || visited[sr][sc]){
            return;
        }
        visited[sr][sc] = true;
        image[sr][sc] = newColor;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int[] dir: dirs){
            int newRow = sr + dir[0];
            int newCol = sc + dir[1];
            dfs(image, newRow, newCol, oldColor, newColor, visited);
        }
    }

    private boolean isValid(int i, int j, int[][] image){
        if(i >= 0 && i < image.length && j >= 0 && j < image[0].length){
            return true;
        }
        return false;
    }

}
