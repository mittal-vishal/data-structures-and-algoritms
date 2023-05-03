package com.vishal.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target){
            return 0;
        }
        //Create map of routes and buses
        HashMap<Integer, HashSet<Integer>> busRoutes = new HashMap<>();
        for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                HashSet<Integer> buses = busRoutes.containsKey(routes[i][j])? busRoutes.get(routes[i][j]): new HashSet<>();
                buses.add(i);
                busRoutes.put(routes[i][j], buses);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        int count = 0;
        HashSet<Integer> visited = new HashSet<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int currStop = queue.poll();
                if(currStop == target){
                    return count;
                }
                HashSet<Integer> buses = busRoutes.get(currStop);
                for(Integer bus: buses){
                    if(visited.contains(bus)){
                        continue;
                    }
                    visited.add(bus);
                    for(int nextStop: routes[bus]){
                        queue.offer(nextStop);
                    }
                }
            }
            count++;
        }
        return -1;
    }

}
