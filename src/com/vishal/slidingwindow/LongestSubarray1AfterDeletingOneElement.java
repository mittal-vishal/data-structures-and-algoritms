package com.vishal.slidingwindow;

public class LongestSubarray1AfterDeletingOneElement {

    public int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int left = 0;
        int right = 0;
        int result = 0;
        boolean isZero = false;
        while(right < nums.length){
            while(zeroCount > 1 && left < right){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            if(nums[right] == 0){
                isZero = true;
                zeroCount++;
            }
            if(isZero && zeroCount < 2){
                result = Math.max(result, right-left);
            }else if(zeroCount < 2){
                result = Math.max(result, right-left+1);
            }
            right++;
        }
        if(!isZero){
            result--;
        }
        return result;
    }

}
