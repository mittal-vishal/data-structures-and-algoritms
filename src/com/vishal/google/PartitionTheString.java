package com.vishal.google;

/*
*
* You are given a string S of length N of digits 0 - 9. You need to partition strings into K substrings such that
Each substring has a minimum length of M
Substring must start with even digit and ends with odd digit number
Determine the number of ways to partition in the strings which satisfy the above condition
You should find answer modulo 1e9 + 7
*
* */

import java.util.Arrays;

public class PartitionTheString {

    public static void main(String[] args) {
        int n = 9;
        int m = 2;
        int k = 3;
        String s = "232387421";
        PartitionTheString partition = new PartitionTheString();
        int ways = partition.ways(s, n, k, m);
        System.out.println(ways);
    }

    private int ways(String s, int n, int k, int m){
        int[][] dp = new int[n+1][k+1];
        for(int i = 0; i <= n; i++){
            Arrays.fill(dp[i], -1);
        }
        return countWays(s, 0, 0, k, m, dp);
    }

    private int countWays(String s, int i, int partition, int k, int m, int[][] dp){
        if(i == s.length()-1){
            if(partition == k && (s.charAt(i)-'0')%2 == 1) return 1;
            else return 0;
        }else if(dp[i][partition] != -1){
            return dp[i][partition];
        }
        int ways = 0;
        for(int j = i+2; j < s.length(); j++){
            String left = s.substring(i, j);
            if((left.charAt(0)-'0')%2==0){
                ways += countWays(s, j, partition+1, k, m, dp);
            }
        }
        return dp[i][partition] = ways;
    }

}
