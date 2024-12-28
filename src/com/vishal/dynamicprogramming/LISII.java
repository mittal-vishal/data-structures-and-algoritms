package com.vishal.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LISII {

    public static void main(String[] args) {
        int[] nums = {5,4,11,1,16,8};
        System.out.println(lengthOfLIS(nums.length, nums));
    }

    public static ArrayList<Integer> lengthOfLIS(int n, int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        int maxLenIdx = 0;
        int maxLen = 1;
        for(int i = 1; i < n; i++){
            prev[i] = i;
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if(maxLen < dp[i]){
                maxLen = dp[i];
                maxLenIdx = i;
            }
        }
        result.add(arr[maxLenIdx]);
        while(prev[maxLenIdx] != maxLenIdx){
            maxLenIdx = prev[maxLenIdx];
            result.add(arr[maxLenIdx]);
        }

        Collections.reverse(result);
        return result;
    }

}
