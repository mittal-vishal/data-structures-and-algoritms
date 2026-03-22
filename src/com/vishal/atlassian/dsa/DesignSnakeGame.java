package com.vishal.atlassian.dsa;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;

public class DesignSnakeGame {

    private int width;
    private int height;
    private HashSet<Map.Entry<Integer,Integer>> body;
    private Queue<int[]> foodQueue;
    private Deque<Map.Entry<Integer,Integer>> snakeBodyQueue;
    private int score;

    public DesignSnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        foodQueue = new LinkedList<>(List.of(food));
        snakeBodyQueue = new ArrayDeque<>();
        body = new HashSet<>();
        snakeBodyQueue.add(Map.entry(0,0));
        body.add(Map.entry(0,0));
    }

    public int move(String direction) {
        int[] dir = getDirection(direction);
        Map.Entry<Integer,Integer> headPos = snakeBodyQueue.peekLast();
        int newRow = headPos.getKey() + dir[0];
        int newCol = headPos.getValue() + dir[1];
        if(!isValid(newRow, newCol, height, width)){
            return -1;
        }
        Map.Entry<Integer,Integer> newPos = Map.entry(newRow, newCol);
        Map.Entry<Integer,Integer> tailPos = snakeBodyQueue.peekFirst();
        //move tail
        body.remove(tailPos);
        if(body.contains(newPos)){
            return -1;
        }
        body.add(newPos);
        snakeBodyQueue.addLast(newPos);
        if(!foodQueue.isEmpty() && foodQueue.peek()[0] == newRow && foodQueue.peek()[1] == newCol){
            foodQueue.poll();
            body.add(tailPos);
            score++;
        }else{
            snakeBodyQueue.pollFirst();
        }
        return score;
    }

    private int[] getDirection(String direction){
        switch(direction){
            case "U" : return new int[]{-1,0};
            case "D" : return new int[]{1,0};
            case "L" : return new int[]{0,-1};
            default : return new int[]{0,1};
        }
    }

    private boolean isValid(int i, int j, int m, int n){
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
