package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(k, n, result, new ArrayList<>(), 1);
        return result;
    }

    private void combinationSum(int k, int n, List<List<Integer>> result, List<Integer> ans, int num){
        if(k == 0 && n == 0){
            result.add(new ArrayList<>(ans));
            return;
        }else if(k == 0 || num > 9){
            return;
        }
        if(n >= num){
            ans.add(num);
            combinationSum(k-1, n-num, result, ans, num+1);
            ans.remove(ans.size()-1);
        }
        combinationSum(k, n, result, ans, num+1);
    }

}
