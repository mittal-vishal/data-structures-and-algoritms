package com.vishal.search;

public class FIndPeakElement {

    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int beg = 0;
        int end = nums.length - 1;

        while(beg < end){
            int mid = beg + (end - beg) / 2;
            if(nums[mid] < nums[mid + 1]){
                beg = mid + 1;
            }else{
                end = mid;
            }
        }

        return beg;
    }

}
