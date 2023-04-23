package com.vishal.graph;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;

public class DesignSnakeGame {

    private Deque<Entry<Integer,Integer>> bodyQueue;
    private HashSet<Entry<Integer,Integer>> body;
    private Queue<Entry<Integer,Integer>> foodQueue;
    private int foodUnit;
    private int width;
    private int height;

    public DesignSnakeGame(int width, int height, int[][] food) {
        this.bodyQueue = new LinkedList<>();
        this.foodQueue = new LinkedList<>();
        bodyQueue.add(new SimpleEntry<>(0,0));
        this.body = new HashSet<>();
        body.add(new SimpleEntry<>(0, 0));
        this.width = width-1;
        this.height = height-1;
        for(int[] foodItem: food){
            foodQueue.offer(new SimpleEntry<>(foodItem[0], foodItem[1]));
        }
    }

    public int move(String direction) {
        Map.Entry<Integer,Integer> head = bodyQueue.peekLast();
        Map.Entry<Integer,Integer> nextPos = getNextMove(head, direction);
        if(isSnakeDie(nextPos)){
            return -1;
        }
        if(!foodQueue.isEmpty() && !body.contains(nextPos) && nextPos.equals(foodQueue.peek())){
            Map.Entry<Integer,Integer> foodItem = foodQueue.poll();
            body.add(foodItem);
            bodyQueue.addLast(foodItem);
            ++foodUnit;
            return foodUnit;
        }
        body.remove(bodyQueue.pollFirst());
        body.add(nextPos);
        bodyQueue.addLast(nextPos);
        return foodUnit;
    }

    private Map.Entry<Integer,Integer> getNextMove(Map.Entry<Integer,Integer> currentMove, String direction){
        if(direction.equals("U")){
            return new SimpleEntry<>(currentMove.getKey() - 1, currentMove.getValue());
        }else if(direction.equals("D")){
            return new SimpleEntry<>(currentMove.getKey()+1, currentMove.getValue());
        }else if(direction.equals("L")){
            return new SimpleEntry<>(currentMove.getKey(), currentMove.getValue()-1);
        }else{
            return new SimpleEntry<>(currentMove.getKey(), currentMove.getValue()+1);
        }
    }

    private boolean isSnakeDie(Map.Entry<Integer,Integer> currentPos){
        int currentRow = currentPos.getKey();
        int currentCol = currentPos.getValue();
        boolean isDied = false;
        if(currentRow < 0 || currentRow > height || currentCol < 0 || currentCol > width){
            isDied = true;
        }
        if(!bodyQueue.peekFirst().equals(currentPos) && body.contains(currentPos)){
            isDied = true;
        }
        return isDied;
    }
}
