package com.vishal.search;

public class SingleNonDuplicate {

    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid > 0 && nums[mid] == nums[mid - 1]){
                if(mid % 2 == 1){
                    mid++;
                }
                else{
                    mid--;
                }
            }
            if((mid < nums.length - 1 && nums[mid] != nums[mid+1]) || (mid == nums.length - 1)){
                return nums[mid];
            }
            if(mid % 2 == 0){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return -1;
    }

}
