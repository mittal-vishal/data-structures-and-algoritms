package com.vishal.google;

import java.util.Arrays;

public class JumpGameV {

    public int maxJumps(int[] arr, int d) {
        int maxJump = 1;
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        for(int i = 0; i < n; i++){
            maxJump = Math.max(maxJump, dfs(arr, i, d, dp));
        }
        return maxJump;
    }

    private int dfs(int[] arr, int curr, int d, int[] dp){
        if(dp[curr] != -1){
            return dp[curr];
        }
        int maxJump = 1;
        //right side
        for(int i = curr+1; i <= Math.min(curr+d, arr.length-1); i++){
            if(arr[i] < arr[curr]){
                maxJump = Math.max(maxJump, 1 + dfs(arr, i, d, dp));
            }else{
                break;
            }
        }
        //left side
        for(int i = curr-1; i >= Math.max(curr-d, 0); i--){
            if(arr[i] < arr[curr]){
                maxJump = Math.max(maxJump, 1 + dfs(arr, i, d, dp));
            }else{
                break;
            }
        }
        return dp[curr] = maxJump;
    }

}
