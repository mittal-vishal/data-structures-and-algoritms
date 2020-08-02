package com.vishal.dynamicprogramming;

import java.util.Arrays;

public class RobHouses {
	
	public static void main(String[] args) {
		int house[] = {1,2,3,1};
		System.out.println(rob(house));
	}
	
	public static int rob(int[] nums) {
        int memo[] = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(memo, nums, nums.length - 1);
    }
    
    private static int rob(int[] memo, int[] nums, int n){
        if(n < 0){
            return 0;
        }else if(memo[n] != -1){
            return memo[n];
        }else{
            int include = nums[n] + rob(memo, nums, n - 2);
            int exclude = rob(memo, nums, n - 1);
            memo[n] = Math.max(include, exclude);
            return memo[n];
        }
        
    }

}
