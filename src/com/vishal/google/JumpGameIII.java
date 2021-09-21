package com.vishal.google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        if(arr == null || arr.length == 0){
            return false;
        }
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int currIdx, boolean[] visited){
        if(currIdx < 0 || currIdx >= arr.length){
            return false;
        }
        if(arr[currIdx] == 0){
            return true;
        }
        if(!visited[currIdx]){
            visited[currIdx] = true;
            return dfs(arr, currIdx - arr[currIdx], visited) || dfs(arr, currIdx + arr[currIdx], visited);
        }
        return false;
    }

    public boolean bfs(int[] arr, int start) {
        if(arr == null || arr.length == 0){
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        Set<Integer> visitedSet = new HashSet<>();
        visitedSet.add(start);
        while(!queue.isEmpty()){
            Integer polled = queue.poll();
            if(arr[polled] == 0){
                return true;
            }
            visitedSet.add(polled);
            int leftElement = polled - arr[polled];
            if(leftElement >= 0 && !visitedSet.contains(leftElement)){
                queue.offer(leftElement);
            }
            int rightElement = polled + arr[polled];
            if(rightElement < arr.length && !visitedSet.contains(rightElement)){
                queue.offer(rightElement);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        JumpGameIII game = new JumpGameIII();
        int[] nums = {4, 2, 3, 0, 3, 1, 2};
        boolean canJump = game.canReach(nums, 5);
        System.out.print(canJump);
    }

}
