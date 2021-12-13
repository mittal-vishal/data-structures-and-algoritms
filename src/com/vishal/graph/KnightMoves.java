package com.vishal.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class KnightMoves {

    static class Cell{
        int x;
        int y;
        public Cell(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int minKnightMoves(int x, int y) {
        int[][] directions = {{-2, -1},{-2, 1}, {-1, -2}, {-1, 2}, {2, -1}, {2, 1}, {1, -2}, {1, 2}};
        Cell src = new Cell(0, 0);
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(src);
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(src.x + "," + src.y);
        int moves = 0;
        x = Math.abs(x);
        y = Math.abs(y);
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                Cell currCell = queue.poll();
                if(currCell.x == x && currCell.y == y){
                    return moves;
                }
                for(int j = 0; j < directions.length; j++){
                    int[] adjDir = directions[j];
                    int nx = currCell.x + adjDir[0];
                    int ny = currCell.y + adjDir[1];
                    String key = nx + "," + ny;
                    if (nx >= -1 && ny >= -1 && !visitedSet.contains(key)) {
                        visitedSet.add(key);
                        queue.offer(new Cell(nx, ny));
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}