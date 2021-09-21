package com.vishal.google;

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

    public static void main(String[] args) {
        JumpGameIII game = new JumpGameIII();
        int[] nums = {4, 2, 3, 0, 3, 1, 2};
        boolean canJump = game.canReach(nums, 5);
        System.out.print(canJump);
    }

}
