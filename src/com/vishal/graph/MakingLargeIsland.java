package com.vishal.graph;

import java.util.Arrays;
import java.util.HashSet;

public class MakingLargeIsland {

    class DSU{

        int[] size;
        int[] parent;

        DSU(int n){
            size = new int[n];
            parent = new int[n];
            Arrays.fill(size, 1);
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        private int findParent(int i){
            if(i == parent[i]){
                return i;
            }
            return parent[i] = findParent(parent[i]);
        }

        private void union(int u, int v){
            int up = findParent(u);
            int vp = findParent(v);
            if(up == vp){
                return;
            }else{
                if(size[up] > size[vp]){
                    parent[vp] = up;
                    size[up] += size[vp];
                }else{
                    parent[up] = vp;
                    size[vp] += size[up];
                }
            }
        }

    }

    public int largestIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        DSU dsu = new DSU(row*col);
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 0){
                    continue;
                }
                int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
                for(int[] dir: dirs){
                    int newRow = i + dir[0];
                    int newCol = j + dir[1];
                    if(isValid(newRow, newCol, grid) && grid[newRow][newCol] == 1){
                        int cell = (i*row)+j;
                        int adjacentCell = (newRow*row)+newCol;
                        dsu.union(cell, adjacentCell);
                    }
                }
            }
        }
        int maxSize = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    continue;
                }
                int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
                HashSet<Integer> components = new HashSet<>();
                for(int[] dir: dirs){
                    int newRow = i + dir[0];
                    int newCol = j + dir[1];
                    if(isValid(newRow, newCol, grid) && grid[newRow][newCol] == 1){
                        int cell = (newRow*row)+newCol;
                        components.add(dsu.findParent(cell));
                    }
                }
                int totalSize = 0;
                for(Integer parent: components){
                    totalSize += dsu.size[parent];
                }
                maxSize = Math.max(maxSize, totalSize + 1);
            }
        }

        for(int cell = 0; cell < row*col; cell++){
            maxSize = Math.max(maxSize, dsu.size[dsu.parent[cell]]);
        }

        return maxSize;
    }

    private boolean isValid(int i, int j, int[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }
        return false;
    }

}
