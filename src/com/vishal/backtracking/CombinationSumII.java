package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, 0, 0, target, new ArrayList<>(), results);
        return results;
    }

    private void combinationSum(int[] candidates, int idx, int sum, int target, List<Integer> result, List<List<Integer>> results){
        if(sum >= target){
            if(sum == target){
                results.add(new ArrayList<>(result));
            }
            return;
        }
        for(int i = idx; i < candidates.length; i++){
            //skip duplicate cases
            if((i > idx) && candidates[i] == candidates[i-1]){
                continue;
            }
            result.add(candidates[i]);
            sum += candidates[i];
            combinationSum(candidates, i+1, sum, target, result, results);
            //backtrack
            sum -= candidates[i];
            result.remove(result.size()-1);
        }
    }

}
