package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PossiblePermutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        permute(nums, 0, results);
        return results;
    }

    private void permute(int[] nums, int index, List<List<Integer>> results){
        //base case
        if(index == nums.length){
            List<Integer> result = new ArrayList<>();
            for(int i: nums){
                result.add(i);
            }
            results.add(result);
        }
        for(int i = index; i < nums.length; i++){
            swap(index, i, nums);
            permute(nums, index+1, results);
            swap(index, i, nums);
        }
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
