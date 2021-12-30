package com.vishal.graph;

import java.util.*;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] orderedCourse = new int[numCourses];
        List<List<Integer>> courseList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            courseList.add(new ArrayList<>());
        }
        for(int[] course: prerequisites){
            courseList.get(course[0]).add(course[1]);
        }
        //Initialize indegrees
        int[] indegree = new int[numCourses];
        for(int i = 0; i < courseList.size(); i++){
            for(int neighbour: courseList.get(i)){
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
            for(int neighbour: courseList.get(polled)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }
        int i = 0;
        if(stack.isEmpty() || stack.size() != numCourses){
            return new int[]{};
        }
        while(!stack.isEmpty()){
            orderedCourse[i++] = stack.pop();
        }
        return orderedCourse;
    }

}
