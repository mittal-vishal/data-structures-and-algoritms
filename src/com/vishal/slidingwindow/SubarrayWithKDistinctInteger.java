package com.vishal.slidingwindow;

import java.util.HashMap;

public class SubarrayWithKDistinctInteger {

    public int subarraysWithKDistinct(int[] nums, int k) {
        int subarrayCountK = countSubarrayWithDistinctK(nums, k);
        int subarrayCountKMinus1 = countSubarrayWithDistinctK(nums, k-1);
        return subarrayCountK - subarrayCountKMinus1;
    }

    private int countSubarrayWithDistinctK(int[] nums, int k){
        HashMap<Integer,Integer> occurances = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;
        while(right < nums.length){
            //expand
            int currNum = nums[right++];
            occurances.put(currNum, occurances.getOrDefault(currNum,0) + 1);
            //shrink
            while(occurances.size() > k){
                int leftNum = nums[left++];
                occurances.put(leftNum, occurances.get(leftNum) - 1);
                if(occurances.get(leftNum) == 0){
                    occurances.remove(leftNum);
                }
            }
            count += (right-left);
        }
        return count;
    }

}
