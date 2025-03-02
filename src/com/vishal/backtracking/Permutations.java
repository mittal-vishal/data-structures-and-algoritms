package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> permute = new ArrayList<>();
        permute(nums, 0, permute, result);
        return result;
    }

    private void permute(int[] nums, int i, List<Integer> permute, List<List<Integer>> result){
        if(i == nums.length){
            result.add(new ArrayList<>(permute));
            return;
        }
        for(int j = i; j < nums.length; j++){
            swap(nums, i, j);
            permute.add(nums[i]);
            permute(nums, i+1, permute, result);
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
