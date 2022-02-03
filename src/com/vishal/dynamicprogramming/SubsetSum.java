package com.vishal.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubsetSum {

	public static void main(String[] args) {
		int sum = 9;
		int[] arr = { 3, 34, 4, 12, 5, 2 };
		System.out.println(isSubsetSum(sum, arr));
	}

	private static boolean isSubsetSum(int sum, int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n + 1][sum + 1];
		for(int i = 0; i < dp.length; i++){
			Arrays.fill(dp[i], -1);
		}
		return isSubsetSum(sum, arr, n-1, dp);
	}

	private static boolean isSubsetSum(int sum, int[] arr, int n, int[][] dp){
		if(sum < 0 || n < 0){
			return false;
		}else if(sum == 0){
			return true;
		}else if(dp[n][sum] != -1){
			return dp[n][sum] == 1 ? true: false;
		}else if((sum - arr[n]) < 0){
			return isSubsetSum(sum, arr, n-1, dp);
		}else{
			boolean include = isSubsetSum(sum - arr[n], arr,n - 1, dp);
			boolean exclude = isSubsetSum(sum, arr, n - 1, dp);
			dp[n][sum] = (include || exclude) ? 1: 0;
			return dp[n][sum] == 1 ? true: false;
		}
	}

	/*
	* Tabulation
	* */
	private static boolean subsetSum(int sum, int[] arr) {
		int n = arr.length;
		boolean[][] dp = new boolean[n + 1][sum + 1];
		for(int i = 0; i < dp.length; i++){
			dp[i][0] = true;
		}
		for(int i = 1; i < dp.length; i++){
			for(int j = 1; j < dp[0].length; j++){
				if(j >= arr[i-1]){
					dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][sum];
	}

}
