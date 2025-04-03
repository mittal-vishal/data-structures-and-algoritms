package com.vishal.slidingwindow;

public class LongestNiceSubarray {

    public static void main(String[] args) {
        LongestNiceSubarray longestNiceSubarray = new LongestNiceSubarray();
        int[] nums = {1,3,8,48,10};
        System.out.println(longestNiceSubarray.longestNiceSubarray(nums));
    }

    public int longestNiceSubarray(int[] nums) {
        int maxLength = 1;
        int left = 0;
        int right = 0;
        int mask = 0;
        while(right < nums.length){
            //keep on shrinking the window until satisfies
            while((left < right) && (mask & nums[right]) != 0){
                mask ^= nums[left++];
            }
            //keep expand the window
            mask |= nums[right++];
            //collect the answer
            maxLength = Math.max(maxLength, (right-left));
        }
        return maxLength;
    }

}
