package com.vishal.google;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }

    private boolean dfs(int[] arr, int start, boolean[] visited){
        if(!isValid(start, arr.length) || visited[start]){
            return false;
        }else if(arr[start] == 0){
            return true;
        }
        visited[start] = true;
        boolean left = dfs(arr, start - arr[start], visited);
        boolean right = dfs(arr, start + arr[start], visited);
        return left || right;
    }

    private boolean isValid(int index, int n){
        if(index >= 0 && index < n){
            return true;
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
