package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        getCombinations(candidates, 0, target, combinations, new ArrayList<>());
        return combinations;
    }

    private void getCombinations(int[] nums, int idx, int target, List<List<Integer>> combinations, List<Integer> combination){
        if(target == 0){
            combinations.add(new ArrayList<>(combination));
            return;
        }
        if(idx == nums.length || target < 0){
            return;
        }
        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i-1]){
                continue;
            }
            combination.add(nums[i]);
            getCombinations(nums, i + 1, target - nums[i], combinations, combination);
            combination.remove(combination.size() - 1);
        }
    }

}
