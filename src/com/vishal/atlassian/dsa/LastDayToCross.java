package com.vishal.atlassian.dsa;

import java.util.LinkedList;
import java.util.Queue;

public class LastDayToCross {

    public int latestDayToCross(int row, int col, int[][] cells) {
        int beg = 1;
        int end = row*col;
        int result = 0;
        while(beg <= end){
            int mid = beg + (end-beg)/2;
            if(isPossible(cells, mid, row, col)){
                result = mid;
                beg = mid+1;
            }else{
                end = mid-1;
            }
        }
        return result;
    }

    private boolean isPossible(int[][] cells, int day, int row, int col){
        int[][] island = new int[row][col];
        for(int i = 0; i < day; i++){
            island[cells[i][0]-1][cells[i][1]-1] = 1;
        }
        Queue<int[]> queue = new LinkedList<>();
        for(int j = 0; j < col; j++){
            if(island[0][j] == 0){
                queue.offer(new int[]{0,j});
            }
        }
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int[] currCell = queue.poll();
            if(!isValid(currCell[0], currCell[1], row, col) || island[currCell[0]][currCell[1]] == 1){
                continue;
            }
            island[currCell[0]][currCell[1]] = 1;
            if(currCell[0] == row-1){
                return true;
            }
            for(int[] dir: dirs){
                int newRow = currCell[0] + dir[0];
                int newCol = currCell[1] + dir[1];
                queue.offer(new int[]{newRow, newCol});
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, int m, int n){
        return i >= 0 && i < m && j >= 0 && j < n;
    }

}
