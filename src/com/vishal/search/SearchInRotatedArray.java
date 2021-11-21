package com.vishal.search;

class RotatedArray {
    public int search(int[] nums, int target) {
        int minIndex = findMin(nums);
        int searchFirst = binarySearch(nums, 0, minIndex - 1, target);
        if(searchFirst == -1){
            return binarySearch(nums, minIndex, nums.length - 1, target);
        }else{
            return searchFirst;
        }
    }

    private int findMin(int[] nums){
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

    private int binarySearch(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target){
                return mid;
            }else if(target > nums[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}