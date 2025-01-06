package com.vishal.google;

import java.util.Arrays;

public class JumpGameII {

    private int INT_MAX = (int)1e8;
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return minJumps(nums, 0, dp);
    }

    private int minJumps(int[] nums, int index, int[] dp){
        if(index >= nums.length - 1){
            return 0;
        }else if(dp[index] != -1){
            return dp[index];
        }
        int maxJump = nums[index];
        int minJump = INT_MAX;
        for(int i = 1; i <= maxJump; i++){
            minJump = Math.min(minJump, 1 + minJumps(nums, index+i, dp));
        }
        return dp[index] = minJump;
    }

}
