package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum(int[] candidates, int index, int target, List<Integer> ans, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<>(ans));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            if(target >= candidates[i]){
                ans.add(candidates[i]);
                combinationSum(candidates, i+1, target-candidates[i], ans, result);
                ans.remove(ans.size()-1);
            }
        }
    }

}
