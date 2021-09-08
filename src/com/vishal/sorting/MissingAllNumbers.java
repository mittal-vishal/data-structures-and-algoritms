package com.vishal.sorting;

import java.util.ArrayList;
import java.util.List;

public class MissingAllNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingList = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(i != nums[i] - 1){
                missingList.add(i + 1);
            }
        }
        return missingList;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
