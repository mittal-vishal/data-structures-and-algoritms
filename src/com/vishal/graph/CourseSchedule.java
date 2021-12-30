package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
