package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GetFood {

    public int getFood(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        int[] src = new int[2];
        int[] dest = new int[2];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '*'){
                    src[0] = i;
                    src[1] = j;
                    break;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(src);
        int steps = 0;
        int[][] dirs = {{0,-1}, {0,1}, {-1, 0}, {1,0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                int[] polled = queue.poll();
                if(!isValid(polled[0], polled[1], grid) || visited[polled[0]][polled[1]]){
                    continue;
                }else if(grid[polled[0]][polled[1]] == '#'){
                    return steps;
                }
                visited[polled[0]][polled[1]] = true;
                for(int[] dir: dirs){
                    int newI = polled[0] + dir[0];
                    int newJ = polled[1] + dir[1];
                    if(isValid(newI, newJ, grid) && !visited[newI][newJ] && grid[newI][newJ] != 'X'){
                        queue.offer(new int[]{newI, newJ});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private boolean isValid(int i, int j, char[][] grid){
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'X','X','X','X','X','X'}
                ,{'X','*','O','O','O','X'},
                {'X','O','O','#','O','X'},
        {'X','X','X','X','X','X'}};
        GetFood food = new GetFood();
        int steps = food.getFood(grid);
        System.out.println(steps);
    }

}
