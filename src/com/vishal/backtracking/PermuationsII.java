package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PermuationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();
        List<Integer> permute = new ArrayList<>();
        permuteUnique(nums, 0, permute, result);
        return new ArrayList<>(result);
    }

    private void permuteUnique(int[] nums, int i, List<Integer> permute, HashSet<List<Integer>> result){
        if(i == nums.length){
            result.add(new ArrayList<>(permute));
            return;
        }
        for(int j = i; j < nums.length; j++){
            swap(nums, i, j);
            permute.add(nums[i]);
            permuteUnique(nums, i+1, permute, result);
            //backtrack
            permute.remove(permute.size()-1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
