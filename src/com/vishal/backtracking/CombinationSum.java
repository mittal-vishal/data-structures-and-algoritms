package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        combinationSum(candidates, 0, 0, target, new ArrayList<>(), results);
        return results;
    }

    private void combinationSum(int[] candidates, int idx, int sum, int target, List<Integer> result, List<List<Integer>> results){
        if(idx == candidates.length || sum > target){
            if(sum == target){
                results.add(new ArrayList<>(result));
            }
            return;
        }
        //pick
        result.add(candidates[idx]);
        sum += candidates[idx];
        combinationSum(candidates, idx, sum, target, result, results);
        //non pick
        result.remove(result.size()-1);
        sum -= candidates[idx];
        combinationSum(candidates, idx+1, sum, target, result, results);
    }

}
