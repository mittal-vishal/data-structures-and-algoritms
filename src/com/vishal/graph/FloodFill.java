package com.vishal.graph;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int row = image.length;
        int col = image[0].length;
        boolean[][] visited = new boolean[row][col];
        int oldColor = image[sr][sc];
        dfs(image, sr, sc, newColor, oldColor, visited);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor, boolean[][] visited){
        if(!isValid(sr, sc, image)){
            return;
        }
        if(!visited[sr][sc] && image[sr][sc] == oldColor){
            visited[sr][sc] = true;
            image[sr][sc] = newColor;
            dfs(image, sr-1, sc, newColor, oldColor, visited);
            dfs(image, sr+1, sc, newColor, oldColor, visited);
            dfs(image, sr, sc-1, newColor, oldColor, visited);
            dfs(image, sr, sc+1, newColor, oldColor, visited);
        }
    }

    private boolean isValid(int i, int j, int[][] image){
        if(i >= 0 && i < image.length && j >= 0 && j < image[0].length){
            return true;
        }
        return false;
    }

}
