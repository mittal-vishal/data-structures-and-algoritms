package com.vishal.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinCostToCutStick {

    public int minCost(int n, int[] cuts) {
        List<Integer> cutsList = new ArrayList<>();
        cutsList.add(0);
        for(int i = 0; i < cuts.length; i++){
            cutsList.add(cuts[i]);
        }
        cutsList.add(n);
        Collections.sort(cutsList);
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return minCost(1, cutsList.size()-2, cutsList, dp);
    }

    private int minCost(int i, int j, List<Integer> cuts, int[][] dp){
        if(i > j){
            return 0;
        }else if(dp[i][j] != -1){
            return dp[i][j];
        }
        int minimum = Integer.MAX_VALUE;
        for(int cut = i; cut <= j; cut++){
            int currCost = cuts.get(j+1) - cuts.get(i-1);
            int left = minCost(i, cut-1, cuts, dp);
            int right = minCost(cut+1, j, cuts, dp);
            int totalCost = currCost + left + right;
            minimum = Math.min(minimum, totalCost);
        }
        return dp[i][j] = minimum;
    }

}
