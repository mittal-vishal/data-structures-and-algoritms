package com.vishal.graph;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        int srcColor = image[sr][sc];
        dfs(image, sr, sc, newColor, visited, srcColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, boolean[][] visited, int srcColor){
        if(isValid(image, sr, sc) && (!visited[sr][sc]) && image[sr][sc] == srcColor){
            visited[sr][sc] = true;
            image[sr][sc] = newColor;
            dfs(image, sr + 1, sc, newColor, visited, srcColor);
            dfs(image, sr - 1, sc, newColor, visited, srcColor);
            dfs(image, sr, sc + 1, newColor, visited, srcColor);
            dfs(image, sr, sc - 1, newColor, visited, srcColor);
        }
    }

    private boolean isValid(int[][] image, int sr, int sc){
        if(sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length){
            return true;
        }else{
            return false;
        }
    }

}
