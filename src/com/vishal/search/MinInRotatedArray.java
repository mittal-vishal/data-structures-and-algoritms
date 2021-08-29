package com.vishal.search;

public class MinInRotatedArray {

    public int findMin(int[] nums) {
        int beg = 0;
        int end = nums.length - 1;

        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]){
                return mid;
            }
            if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]){
                return mid + 1;
            }
            if (nums[mid] > nums[end]){
                beg = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return 0;
    }

}
