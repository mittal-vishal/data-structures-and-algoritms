package com.vishal.graph;

import java.util.*;

public class RaceCar {

    private int target;

    public int racecar(int target) {

        Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        HashSet<Map.Entry<Integer, Integer>> visited = new HashSet<>();

        this.target = target;
        //pos, speed
        queue.add(new AbstractMap.SimpleEntry<>(0,1));
        visited.add(queue.peek());
        int instructions = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0;i<size;i++){
                Map.Entry<Integer, Integer> node = queue.poll();
                int position = node.getKey();
                int speed = node.getValue();

                //once we hit target, return instructions count
                if(position == target)
                    return instructions;

                //we have 2 possibilities
                //accelerate
                addNextPossibilities(queue, visited, position+speed, speed*2);
                int reverseSpeed = speed > 0 ? -1: 1;
                addNextPossibilities(queue, visited, position, reverseSpeed);
            }

            //increase instruction
            instructions++;
        }

        return -1;
    }

    private void addNextPossibilities(Queue<Map.Entry<Integer,Integer>>queue, HashSet<Map.Entry<Integer, Integer>> visited, int pos, int speed){
        Map.Entry<Integer,Integer> pair = new AbstractMap.SimpleEntry<>(pos, speed);
        if(pos >= 0 && pos <= 2*target && !visited.contains(pair)){
            visited.add(pair);
            queue.add(pair);
        }
    }

}
