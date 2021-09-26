package com.vishal.google;

import java.util.Arrays;

public class JumpGameV {

    public int maxJumps(int[] arr, int d) {
        int max = 1;
        int[] memo = new int[arr.length];
        Arrays.fill(memo, -1);
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, dfs(arr, d, i, memo));
        }
        return max;
    }

    private int dfs(int[] arr, int d, int curr, int[] memo){
        if(memo[curr] != -1){
            return memo[curr];
        }
        int maxJumps = 1;
        //Left
        for(int i = curr - 1; i >= 0 && curr-i <= d; i--){
            if(arr[i] < arr[curr]){
                maxJumps =  Math.max(maxJumps, 1 + dfs(arr, d, i, memo));
            }else{
                break;
            }
        }
        //right
        for(int i = curr + 1; i < arr.length && i-curr <= d; i++){
            if(arr[i] < arr[curr]){
                maxJumps =  Math.max(maxJumps, 1 + dfs(arr, d, i, memo));
            }else{
                break;
            }
        }
        memo[curr] = maxJumps;
        return memo[curr];
    }

}
