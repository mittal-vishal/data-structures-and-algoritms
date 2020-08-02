package com.vishal.goldmansachs;

import java.util.Arrays;

public class WaysForClimbingStairs {
	
	public int climbStairs(int n) {
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return climbStairs(memo, 0, n);
    }
    
    private int climbStairs(int[] memo, int beg, int end){
        if(beg > end){
            return 0;
        }else if(beg == end){
            return 1;
        }else if(memo[beg] != -1){
            return memo[beg];
        }else{
            memo[beg] = climbStairs(memo, beg + 1, end) + climbStairs(memo, beg + 2, end);
            return memo[beg];
        }
    }
}
