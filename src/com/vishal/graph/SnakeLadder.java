package com.vishal.graph;

import java.util.*;

public class SnakeLadder {

    public static void main(String[] args) {
        int[][] board = {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}};
        SnakeLadder snakeLadder = new SnakeLadder();
        int steps = snakeLadder.snakesAndLadders(board);
        System.out.println(steps);
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Map<Integer,Integer> graph = new HashMap<>();
        initializeGraph(graph, board, n);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int steps = 0;
        HashSet<Integer> visited = new HashSet<>();
        visited.add(1);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int polled = queue.poll();
                if(polled == n*n){
                    return steps;
                }
                for(int j = 1; j <= 6 && (polled+j) <= n*n; j++){
                    int neighbour = graph.get(polled+j) != -1? graph.get(polled+j): polled+j;
                    if(!visited.contains(neighbour)){
                        visited.add(neighbour);
                        queue.offer(neighbour);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private void initializeGraph(Map<Integer,Integer> graph, int[][] board, int n){
        int node = n*n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                //If even start from left to right
                if((n-i) % 2 == 0){
                    graph.put(node, board[i][j]);
                }else{
                    //If odd start from right to left
                    graph.put(node, board[i][n-j-1]);
                }
                node--;
            }
        }
    }
}