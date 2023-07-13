package com.vishal.backtracking;

import java.util.ArrayList;

public class SubsetSumGFG {

    public ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> result = new ArrayList<>();
        subsetSum(arr, 0, 0, result);
        return result;
    }

    private void subsetSum(ArrayList<Integer> arr, int index, int sum, ArrayList<Integer> result){
        if(index == arr.size()){
            result.add(sum);
            return;
        }
        //pick
        sum += arr.get(index);
        subsetSum(arr, index+1, sum, result);
        //non pick
        sum -= arr.get(index);
        subsetSum(arr, index+1, sum, result);
    }

}
