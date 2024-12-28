package com.vishal.search;

public class MinInRotatedArray {

    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int beg = 0;
        int end = nums.length-1;
        while(beg <= end){
            int mid = beg + (end-beg)/2;
            //first half is sorted
            if(nums[beg] <= nums[mid]){
                min = Math.min(min, nums[beg]);
                beg = mid+1;
            }
            //second half is sorted
            else{
                min = Math.min(min, nums[mid]);
                end = mid-1;
            }
        }
        return min;
    }

}
