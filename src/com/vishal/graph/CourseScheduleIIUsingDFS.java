package com.vishal.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleIIUsingDFS {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] orderedCourse = new int[numCourses];
        List<List<Integer>> courseList = new ArrayList<>();
        initializeGraph(courseList, prerequisites, numCourses);

        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < numCourses; i++){
            if(!visited[i] && dfs(courseList, i, visited, recStack, stack)){
                return new int[]{};
            }
        }

        if(stack.isEmpty() || stack.size() != numCourses){
            return new int[]{};
        }
        int i = 0;
        while(!stack.isEmpty()){
            orderedCourse[i++] = stack.pop();
        }
        if(i != numCourses){
            return new int[]{};
        }
        return orderedCourse;
    }

    private boolean dfs(List<List<Integer>> courseList, int src, boolean[] visited, boolean[] recStack, Stack<Integer> stack){
        visited[src] = true;
        for(int neighbour: courseList.get(src)){
            if(!visited[neighbour] && dfs(courseList, neighbour, visited, recStack, stack)){
                return true;
            }else if(visited[neighbour] && !recStack[neighbour]){
                return true;
            }
        }
        recStack[src] = true;
        stack.push(src);
        return false;
    }

    private void initializeGraph(List<List<Integer>> courseList, int[][] prerequisites, int numCourses){
        for(int i = 0; i < numCourses; i++){
            courseList.add(new ArrayList<>());
        }
        for(int[] course: prerequisites){
            courseList.get(course[1]).add(course[0]);
        }
    }
}