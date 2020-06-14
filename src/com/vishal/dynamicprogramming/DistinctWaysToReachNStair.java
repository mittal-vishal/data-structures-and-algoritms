package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class DistinctWaysToReachNStair {
	
	public int climbStairs(int n) {
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return climbStairs(n, memo);
    }
    
    private int climbStairs(int n, int[] memo){
	    if(n < 0){
	        return 0;
	    }else if(n == 0){
	        return 1;
	    }else if(memo[n-1] != -1){
	        return memo[n-1];
	    }else{
	        memo[n-1] = climbStairs(n-1, memo) + climbStairs(n-2, memo);
	        return memo[n-1];
	    }
	}

}
