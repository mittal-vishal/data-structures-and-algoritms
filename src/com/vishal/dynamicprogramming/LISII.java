package com.vishal.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LISII {

    public static void main(String[] args) {
        int[] nums = {5,4,11,1,16,8};
        System.out.println(lengthOfLIS(nums));
    }

    public static List<Integer> lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        int maxLIS = 1;
        int maxIndex = 0;
        for(int i = 1; i < n; i++){
            prev[i] = i;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j] && 1+dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                    prev[i] = j;
                }
            }
            if(dp[i] > maxLIS){
                maxLIS = dp[i];
                maxIndex = i;
            }
        }
        List<Integer> results = new ArrayList<>();
        while(maxIndex != prev[maxIndex]){
            results.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        results.add(nums[maxIndex]);
        Collections.reverse(results);
        return results;
    }

}
