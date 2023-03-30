package com.vishal.search;

class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int min = findMin(nums);
        int searchElement = binarySearch(nums, 0, min-1, target);
        if(searchElement == -1){
            return binarySearch(nums, min, nums.length - 1, target);
        }
        return searchElement;
    }

    private int findMin(int[] nums){
        int beg = 0;
        int end = nums.length - 1;
        while(beg < end){
            int mid = beg + (end-beg)/2;
            if(nums[mid] > nums[end]){
                beg = mid+1;
            }else{
                end = mid;
            }
        }
        return beg;
    }

    private int binarySearch(int[] nums, int beg, int end, int target){
        while(beg <= end){
            int mid = beg + (end-beg)/2;
            if(nums[mid] == target){
                return mid;
            }else if(target > nums[mid]){
                beg = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}