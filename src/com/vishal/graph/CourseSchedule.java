package com.vishal.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < prerequisites.length; i++){
            int[] edge = prerequisites[i];
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            indegree[v]++;
        }
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int canCompletedCourseCount = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            canCompletedCourseCount++;
            for(int neighbour: graph.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
        return canCompletedCourseCount == numCourses? true: false;
    }

    public boolean canFinishDFS(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] callstack = new boolean[numCourses];
        List<List<Integer>> courseList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            courseList.add(new ArrayList<>());
        }
        for(int[] course: prerequisites){
            courseList.get(course[0]).add(course[1]);
        }
        for(int i = 0; i < numCourses; i++){
            if(!visited[i] && dfs(courseList, visited, callstack, i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> prerequisites, boolean[] visited, boolean[] callstack, int src){
        visited[src] = true;
        for(int neighbour: prerequisites.get(src)){
            if(visited[neighbour] && !callstack[neighbour]){
                return true;
            }else if(!visited[neighbour] && dfs(prerequisites, visited, callstack, neighbour)){
                return true;
            }
        }
        callstack[src] = true;
        return false;
    }

}
