package com.vishal.graph;

import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //build graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: prerequisites){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
        }
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int neighbour: graph.get(i)){
                indegree[neighbour]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()){
            int polled = queue.poll();
            stack.push(polled);
            for(int neighbour: graph.get(polled)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
        int index = 0;
        int[] res = new int[numCourses];
        while(!stack.isEmpty()){
            res[index++] = stack.pop();
        }
        return index == numCourses? res: new int[0];
    }

}
