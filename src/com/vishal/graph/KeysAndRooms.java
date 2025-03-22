package com.vishal.graph;

import java.util.List;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(0, rooms, visited);
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

    private void dfs(int src, List<List<Integer>> rooms, boolean[] visited){
        if(visited[src]){
            return;
        }
        visited[src] = true;
        for(int nextRoom: rooms.get(src)){
            dfs(nextRoom, rooms, visited);
        }
    }

}
