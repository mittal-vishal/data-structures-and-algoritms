package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

public class MinMovesToMoveBoxToTargetLocation {

    private int row;
    private int col;
    private int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    private char[][] grid;

    public int minPushBox(char[][] grid) {
        this.grid = grid;
        row = grid.length;
        col = grid[0].length;
        Queue<int[]> boxQueue = new LinkedList<>();
        Queue<int[]> personQueue = new LinkedList<>();
        int[] target = new int[2];
        //initialize boxQueue, personQueue and target
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 'T'){
                    target[0] = i;
                    target[1] = j;
                }
                if(grid[i][j] == 'B'){
                    boxQueue.offer(new int[]{i,j});
                }
                if(grid[i][j] == 'S'){
                    personQueue.offer(new int[]{i,j});
                }
            }
        }
        boolean[][][] visited = new boolean[row][col][4];
        int steps = 0;
        while(!boxQueue.isEmpty()){
            int size = boxQueue.size();
            for(int i = 0; i < size; i++){
                int[] currBoxLoc = boxQueue.poll();
                int[] currPersonLoc = personQueue.poll();
                if(currBoxLoc[0] == target[0] && currBoxLoc[1] == target[1]){
                    return steps;
                }
                for(int j = 0; j < dirs.length; j++){
                    int newPersonRow = currBoxLoc[0] - dirs[j][0];
                    int newPersonCol = currBoxLoc[1] - dirs[j][1];
                    if(!isValid(newPersonRow, newPersonCol, row, col) || grid[newPersonRow][newPersonCol] == '#'){
                        continue;
                    }
                    int newBoxRow = currBoxLoc[0] + dirs[j][0];
                    int newBoxCol = currBoxLoc[1] + dirs[j][1];
                    if(!isValid(newBoxRow, newBoxCol, row, col) || grid[newBoxRow][newBoxCol] == '#'){
                        continue;
                    }
                    if(isReachable(newPersonRow, newPersonCol, currBoxLoc, currPersonLoc)
                            && !visited[newBoxRow][newBoxRow][j]){
                        visited[newBoxRow][newBoxRow][j] = true;
                        boxQueue.offer(new int[]{newBoxRow,newBoxCol});
                        personQueue.offer(new int[]{newPersonRow,newPersonCol});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private boolean isReachable(int targetRow, int targetCol, int[] currBoxLoc, int[] currPersonLoc){
        boolean[][] visited = new boolean[row][col];
        visited[currBoxLoc[0]][currBoxLoc[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{currPersonLoc[0],currPersonLoc[1]});
        while(!queue.isEmpty()){
            int[] currLoc = queue.poll();
            if(currLoc[0] == targetRow && currLoc[1] == targetCol){
                return true;
            }
            if(visited[currLoc[0]][currLoc[1]]){
                continue;
            }
            visited[currLoc[0]][currLoc[1]] = true;
            for(int[] dir: dirs){
                int newRow = currLoc[0] + dir[0];
                int newCol = currLoc[1] + dir[1];
                if(!isValid(newRow, newCol, row, col) || grid[newRow][newCol] == '#'){
                    continue;
                }
                queue.offer(new int[]{newRow, newCol});
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, int row, int col){
        if(i >= 0 && i < row && j >= 0 && j < col){
            return true;
        }
        return false;
    }

}
