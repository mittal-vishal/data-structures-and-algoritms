package com.vishal.search;

import java.util.Arrays;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        Arrays.fill(res, -1);
        if(nums == null || nums.length < 1){
            return res;
        }

        res[0] = binarySearch(nums, target, true);
        if(res[0] != -1){
            res[1] = binarySearch(nums, target, false);
        }
        return res;
    }

    private int binarySearch(int[] nums, int target, boolean isLeft){
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target > nums[mid]){
                start = mid + 1;
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                ans = mid;
                if(isLeft){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return ans;
    }

}
