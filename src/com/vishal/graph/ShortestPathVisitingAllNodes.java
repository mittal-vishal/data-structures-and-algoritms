package com.vishal.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {

    public int shortestPathLength(int[][] graph) {
        Queue<int[]> queue = new LinkedList<>();
        int n = graph.length;
        for(int i = 0; i < n; i++){
            queue.offer(new int[]{i, 1 << i});
        }
        int pathLength = 0;
        boolean[][] visited = new boolean[n][1 << n];
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i = 0; i < queueSize; i++){
                int[] currNodeMask = queue.poll();
                int currNode = currNodeMask[0];
                int currMask = currNodeMask[1];
                if(currMask == ((1 << n)-1)){
                    return pathLength;
                }else if(visited[currNode][currMask]){
                    continue;
                }
                visited[currNode][currMask] = true;
                for(int neighbor: graph[currNode]){
                    int neighborMask = (1 << neighbor) | currMask;
                    queue.offer(new int[]{neighbor, neighborMask});
                }
            }
            pathLength++;
        }
        return -1;
    }

}
