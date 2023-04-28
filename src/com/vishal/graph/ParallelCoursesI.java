package com.vishal.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParallelCoursesI {

    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] relation: relations){
            graph.get(relation[0]).add(relation[1]);
        }
        int[] indegree = new int[n+1];
        for(int i = 1; i <= n; i++){
            for(int neighbour: graph.get(i)){
                indegree[neighbour]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int semester = 0;
        int studiedCount = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            semester++;
            for(int i = 0; i < size; i++){
                int polled = queue.poll();
                studiedCount++;
                for(int neighbour: graph.get(polled)){
                    indegree[neighbour]--;
                    if(indegree[neighbour] == 0){
                        queue.offer(neighbour);
                    }
                }
            }
        }
        return studiedCount == n ? semester: -1;
    }

}
