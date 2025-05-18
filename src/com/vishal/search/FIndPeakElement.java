package com.vishal.search;

public class FIndPeakElement {

    public int findPeakElement(int[] nums) {
        int beg = 0;
        int end = nums.length-1;
        while(beg <= end){
            int mid = beg + (end-beg)/2;
            if(mid < nums.length-1 && nums[mid] < nums[mid+1]){
                beg = mid+1;
            }else if(mid > 0 && nums[mid-1] > nums[mid]){
                end = mid-1;
            }else {
                return mid;
            }
        }
        return beg;
    }

}
