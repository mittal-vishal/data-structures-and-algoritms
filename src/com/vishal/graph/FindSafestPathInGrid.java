package com.vishal.graph;

import java.util.*;

public class FindSafestPathInGrid {

    private final int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    static class Cell{
        int i;
        int j;
        public Cell(int i, int j){
            this.i = i;
            this.j = j;
        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] safeness = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(safeness[i], -1);
        }
        populateSafenessFactor(grid, safeness, m, n);
        //Run dijkstra
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.offer(new int[]{0, 0, safeness[0][0]});
        boolean[][] visited = new boolean[m][n];
        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            if(cell[0] == m-1 && cell[1] == n-1){
                return cell[2];
            }else if(visited[cell[0]][cell[1]]){
                continue;
            }
            visited[cell[0]][cell[1]] = true;
            for(int[] dir: dirs){
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                if(isValid(newRow, newCol, grid)){
                    int minSafeness = Math.min(cell[2], safeness[newRow][newCol]);
                    pq.offer(new int[]{newRow, newCol, minSafeness});
                }
            }
        }
        return -1;
    }

    private void populateSafenessFactor(List<List<Integer>> grid, int[][] safeness, int m, int n){
        Queue<Cell> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid.get(i).get(j) == 1){
                    queue.offer(new Cell(i, j));
                    safeness[i][j] = 0;
                }
            }
        }
        while(!queue.isEmpty()){
            Cell curr = queue.poll();
            for(int[] dir: dirs){
                int newRow = curr.i + dir[0];
                int newCol = curr.j + dir[1];
                if(isValid(newRow, newCol, grid) && safeness[newRow][newCol] == -1){
                    safeness[newRow][newCol] = safeness[curr.i][curr.j] + 1;
                    queue.offer(new Cell(newRow, newCol));
                }
            }
        }
    }

    private boolean isValid(int i, int j, List<List<Integer>> grid){
        if(i >= 0 && i < grid.size() && j >= 0 && j < grid.get(i).size()){
            return true;
        }else{
            return false;
        }
    }

}
