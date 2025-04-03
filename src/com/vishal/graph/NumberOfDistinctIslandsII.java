package com.vishal.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NumberOfDistinctIslandsII {

    private List<int[]> islandCoordinates;
    private final int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

    public int numDistinctIslands2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        HashSet<String> distinctIslands = new HashSet<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    islandCoordinates = new ArrayList<>();
                    dfs(i, j, grid, visited);
                    String hash = transform(islandCoordinates);
                    distinctIslands.add(hash);
                }
            }
        }
        return distinctIslands.size();
    }

    private String transform(List<int[]> coordinates){
        int[][][] reflectionPoints = new int[8][coordinates.size()][2];
        for(int i = 0; i < coordinates.size(); i++){
            int x = coordinates.get(i)[0];
            int y = coordinates.get(i)[1];
            reflectionPoints[0][i] = new int[]{x,y};
            reflectionPoints[1][i] = new int[]{-x,y};
            reflectionPoints[2][i] = new int[]{x,-y};
            reflectionPoints[3][i] = new int[]{-x,-y};
            reflectionPoints[4][i] = new int[]{y,x};
            reflectionPoints[5][i] = new int[]{-y,x};
            reflectionPoints[6][i] = new int[]{y,-x};
            reflectionPoints[7][i] = new int[]{-y,-x};
        }
        String ans = "";
        for(int[][] reflectionPoint : reflectionPoints){
            Arrays.sort(reflectionPoint, (a, b) -> {
                if(a[0] != b[0]){
                    return a[0] - b[0];
                }else{
                    return a[1] - b[1];
                }
            });
            StringBuilder sb = new StringBuilder();
            for(int i = reflectionPoint.length-1; i >= 0; i--){
                String s = String.format("(%d %d)", reflectionPoint[i][0] - reflectionPoint[0][0], reflectionPoint[i][1] - reflectionPoint[0][1]);
                sb.append(s);
            }
            if(ans.isEmpty() || ans.compareTo(sb.toString()) > 0){
                ans = sb.toString();
            }
        }
        return ans;
    }

    private void dfs(int i, int j, int[][] grid, boolean[][] visited){
        if(!isValid(i, j, grid) || visited[i][j] || grid[i][j] == 0){
            return;
        }
        visited[i][j] = true;
        islandCoordinates.add(new int[]{i, j});
        for(int[] dir: dirs){
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            dfs(newRow, newCol, grid, visited);
        }
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[i].length){
            return true;
        }else{
            return false;
        }
    }

}
