package com.vishal.search;

public class CheckArrayIsSortedAndRotated {

    public boolean check(int[] nums) {
        int min = findMin(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == min){
                boolean isCyclicSorted = true;
                Integer prev = null;
                for(int j = i; j < i + nums.length; j++){
                    int cyclicIdx = j % nums.length;
                    if(prev != null && prev > nums[cyclicIdx]){
                        isCyclicSorted = false;
                    }
                    prev = nums[cyclicIdx];
                }
                if(isCyclicSorted){
                    return true;
                }
            }
        }
        return false;
    }

    private int findMin(int[] nums){
        int left = 0;
        int right = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[left] == nums[mid] && nums[mid] == nums[right]){
                min = Math.min(min, nums[mid]);
                left++;
                right--;
            }else if(nums[left] <= nums[mid]){
                min = Math.min(min, nums[left]);
                left = mid+1;
            }else{
                min = Math.min(min, nums[mid]);
                right = mid-1;
            }
        }
        return min;
    }

}
