package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsequence {

    private void getSubsequence(int[] arr, int index, List<Integer> result, List<List<Integer>> results){
        if(index == arr.length){
            results.add(new ArrayList<>(result));
            return;
        }
        //take
        result.add(arr[index]);
        getSubsequence(arr, index+1, result, results);
        //not take
        result.remove(result.size()-1);
        getSubsequence(arr, index+1, result, results);
    }

    public static void main(String[] args) {
        Subsequence subsequence = new Subsequence();
        int[] arr = {3, 1, 2};
        List<List<Integer>> results = new ArrayList<>();
        subsequence.getSubsequence(arr, 0, new ArrayList<>(), results);
        System.out.println(results);
    }

}
