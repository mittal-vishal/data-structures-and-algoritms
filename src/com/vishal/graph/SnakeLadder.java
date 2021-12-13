package com.vishal.graph;

import java.util.*;

public class SnakeLadder {

    public int snakesAndLadders(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return 0;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        Set<Integer> visitedSet = new HashSet<>();
        visitedSet.add(1);
        int moves = 0;
        int n = board.length;
        int dest = n * n;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        populateMapping(map, board);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Integer curr = queue.poll();
                if(curr == dest){
                    return moves;
                }
                for(int j = 1; j < 7 && (curr + j) <= dest; j++){
                    int nextNum = map.get(curr + j) == -1 ? curr + j: map.get(curr + j);
                    if(!visitedSet.contains(nextNum)){
                        queue.offer(nextNum);
                        visitedSet.add(nextNum);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private void populateMapping(HashMap<Integer, Integer> map, int[][] board){
        int n = board.length;
        int start = n * n;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                if ((n-i) % 2 == 0) {
                    map.put(start, board[i][j]);
                } else {
                    map.put(start, board[i][n - j - 1]);
                }
                start--;
            }
        }
    }
}