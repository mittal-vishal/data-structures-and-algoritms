package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class SubsetSumEqualToK {

    public static boolean subsetSumToK(int n, int k, int arr[]){
        int[][] dp = new int[n][k+1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return isSubsetExist(arr, n-1, k, dp) == 1? true: false;
    }

    private static int isSubsetExist(int[] arr, int index, int target, int[][] dp){
        if(target == 0){
            return 1;
        }else if(index == 0){
            return arr[0] == target? 1: 0;
        }else if(dp[index][target] != -1){
            return dp[index][target];
        }else{
            int include = 0;
            if(target >= arr[index]){
                include = isSubsetExist(arr, index-1, target-arr[index], dp);
            }
            int exclude = isSubsetExist(arr, index-1, target, dp);
            dp[index][target] = (include == 1 || exclude == 1)? 1: 0;
            return dp[index][target];
        }
    }

    public static boolean subsetSumToKTabulation(int n, int k, int arr[]){
        int[][] dp = new int[n][k+1];
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        if(arr[0] <= k){
            dp[0][arr[0]] = 1;
        }
        for(int i = 1; i < n; i++){
            for(int target = 1; target <= k; target++){
                int include = 0;
                if(target >= arr[i]){
                    include = dp[i-1][target-arr[i]];
                }
                int exclude = dp[i-1][target];
                dp[i][target] = (include == 1 || exclude == 1)? 1: 0;
            }
        }
        return dp[n-1][k] == 1? true: false;
    }

}
