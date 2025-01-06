package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, candidates.length-1, target, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum(int[] candidates, int i, int target, List<Integer> ans, List<List<Integer>> result){
        if(i < 0){
            return;
        }else if(target == 0){
            result.add(new ArrayList<>(ans));
            return;
        }
        if(target >= candidates[i]){
            ans.add(candidates[i]);
            combinationSum(candidates, i, target-candidates[i], ans, result);
            ans.remove(ans.size()-1);
        }
        combinationSum(candidates, i-1, target, ans, result);
    }

}
