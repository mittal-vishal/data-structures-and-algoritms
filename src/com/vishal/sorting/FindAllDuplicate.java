package com.vishal.sorting;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicate {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> dupList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] - 1 != i){
                dupList.add(nums[i]);
            }
        }
        return dupList;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
