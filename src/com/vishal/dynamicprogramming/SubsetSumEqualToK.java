package com.vishal.dynamicprogramming;

public class SubsetSumEqualToK {

    public static boolean subsetSumToK(int n, int k, int arr[]){
        Boolean[][] dp = new Boolean[n][k+1];
        return isSubset(n-1, arr, k, dp);
    }

    private static boolean isSubset(int n, int[] arr, int k, Boolean[][] dp){
        if(k == 0){
            return true;
        }else if(n == 0){
            return arr[n] == k;
        }else if(dp[n][k] != null){
            return dp[n][k];
        }
        boolean include = isSubset(n-1, arr, k-arr[n], dp);
        boolean exclude = isSubset(n-1, arr, k, dp);
        return dp[n][k] = include || exclude;
    }

    public static boolean subsetSumToKTabulation(int n, int k, int arr[]){
        boolean[][] dp = new boolean[n][k+1];
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        if(arr[0] <= k){
            dp[0][arr[0]] = true;
        }
        for(int i = 1; i < n; i++){
            for(int target = 1; target <= k; target++){
                boolean include = false;
                if(target >= arr[i]){
                    include = dp[i-1][target-arr[i]];
                }
                boolean exclude = dp[i-1][target];
                dp[i][target] = include || exclude;
            }
        }
        return dp[n-1][k];
    }

}
