package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums, 0, new ArrayList<>(), results);
        return results;
    }

    private void subset(int[] nums, int idx, List<Integer> result, List<List<Integer>> results){
        results.add(new ArrayList<>(result));
        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i-1]){
                continue;
            }
            result.add(nums[i]);
            subset(nums, i+1, result, results);
            result.remove(result.size()-1);
        }
    }

}
