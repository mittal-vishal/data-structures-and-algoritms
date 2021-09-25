package com.vishal.google;

public class JumpGameII {

    public static int minJumps(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        int jumps = 1;
        int currJumpReach = nums[0];
        int maxReach = nums[0];
        for(int  i = 1; i < nums.length; i++){
            if(currJumpReach < i){
                currJumpReach = maxReach;
                jumps++;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        int jumps = minJumps(nums);
        System.out.print(jumps);
    }

}
