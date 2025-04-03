package com.vishal.slidingwindow;

public class CountNiceSubarray {

    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int oddCount = 0;
        int result = 0;
        int count = 0;

        while(right < nums.length){
            if(nums[right] % 2 == 1){
                oddCount++;
                count = 0;
            }
            while(oddCount == k){
                count++;
                if(nums[left] % 2 == 1){
                    oddCount--;
                }
                left++;
            }
            result += count;
            right++;
        }
        return result;
    }

}
