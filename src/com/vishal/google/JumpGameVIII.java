package com.vishal.google;

import java.util.Arrays;
import java.util.Stack;

public class JumpGameVIII {

    public static void main(String[] args) {
        int[] nums = {3,2,4,4,1};
        int[] costs = {3,7,6,4,2};
        long res = minCost(nums, costs);
        System.out.println(res);
    }

    public static long minCost(int[] nums, int[] costs) {
        int n = nums.length;
        long[] minJumpCost = new long[n];
        Arrays.fill(minJumpCost, Long.MAX_VALUE);
        minJumpCost[0] = 0;
        Stack<Integer> monoIncreasing = new Stack<>();
        Stack<Integer> monoDecreasing = new Stack<>();
        for(int i = 0; i < n; i++){
            //First condition, mono decreasing stack
            while(!monoDecreasing.isEmpty() && nums[i] >= nums[monoDecreasing.peek()]){
                int idx = monoDecreasing.pop();
                minJumpCost[i] = Math.min(minJumpCost[i], minJumpCost[idx] + costs[i]);
            }
            monoDecreasing.push(i);
            //First condition, mono increasing stack
            while(!monoIncreasing.isEmpty() && nums[i] < nums[monoIncreasing.peek()]){
                int idx = monoIncreasing.pop();
                minJumpCost[i] = Math.min(minJumpCost[i], minJumpCost[idx] + costs[i]);
            }
            monoIncreasing.push(i);
        }
        return minJumpCost[n-1];
    }
}
