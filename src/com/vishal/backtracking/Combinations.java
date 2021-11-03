package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        int start = 1;
        int end = n;
        List<List<Integer>> combinationList = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>();
        combination(start, end, k, combinationList, innerList);
        return combinationList;
    }

    private void combination(int start, int end, int k, List<List<Integer>> combinationList, List<Integer> innerList){
        if(innerList.size() == k){
            combinationList.add(new ArrayList<>(innerList));
        }
        for(int i = start; i <= end; i++){
            innerList.add(i);
            combination(i + 1, end, k, combinationList, innerList);
            innerList.remove(innerList.size()-1);
        }
    }

}
