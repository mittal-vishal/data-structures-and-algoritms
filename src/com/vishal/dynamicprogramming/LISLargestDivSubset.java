package com.vishal.dynamicprogramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LISLargestDivSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        int maxDivLength = 1;
        int maxDivIndex = 0;
        for(int i = 1; i < n; i++){
            prev[i] = i;
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0 && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                    prev[i] = j;
                }
            }
            if(dp[i] > maxDivLength){
                maxDivLength = dp[i];
                maxDivIndex = i;
            }
        }
        LinkedList<Integer> results = new LinkedList<>();
        results.add(nums[maxDivIndex]);
        while(prev[maxDivIndex] != maxDivIndex){
            maxDivIndex = prev[maxDivIndex];
            results.addFirst(nums[maxDivIndex]);
        }
        return results;
    }

}
