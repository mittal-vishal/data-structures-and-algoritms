package com.vishal.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinCostToCutStick {

    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> cutList = new ArrayList<>();
        cutList.add(0);
        for(int cut: cuts){
            cutList.add(cut);
        }
        cutList.add(n);
        int[][] dp = new int[cutList.size()][cutList.size()];
        Collections.sort(cutList);
        return minCost(cutList, 1, cutList.size()-2, dp);
    }

    private int minCost(List<Integer> cuts, int cutStart, int cutEnd, int[][] dp){
        if(cutStart > cutEnd){
            return 0;
        }else if(dp[cutStart][cutEnd] != 0){
            return dp[cutStart][cutEnd];
        }
        int res = Integer.MAX_VALUE;
        for(int i = cutStart; i <= cutEnd; i++){
            int leftCost = minCost(cuts, cutStart, i-1, dp);
            int rightCost = minCost(cuts, i+1, cutEnd, dp);
            int totalCost = (cuts.get(cutEnd+1) - cuts.get(cutStart-1)) + leftCost + rightCost;
            res = Math.min(res, totalCost);
        }
        return dp[cutStart][cutEnd] = res;
    }

}
