package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.List;

public class OnlyOneSubsequenceSumEqualToK {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int sum = 2;
        List<List<Integer>> results = new ArrayList<>();
        getSubSequenceSum(arr, 0, 0, sum, new ArrayList<>(), results);
        System.out.println(results);
    }

    private static boolean getSubSequenceSum(int[] arr, int index, int sum, int targetSum, ArrayList<Integer> result, List<List<Integer>> results) {
        if(index == arr.length){
            if(sum == targetSum){
                results.add(new ArrayList<>(result));
                return true;
            }
            return false;
        }
        //pick
        result.add(arr[index]);
        sum += arr[index];
        if(getSubSequenceSum(arr, index+1, sum, targetSum, result, results)){
            return true;
        }
        //not pick
        result.remove(result.size()-1);
        sum -= arr[index];
        if(getSubSequenceSum(arr, index+1, sum, targetSum, result, results)){
            return true;
        }
        return false;
    }

}
