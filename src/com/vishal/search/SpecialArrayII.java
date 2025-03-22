package com.vishal.search;

import java.util.ArrayList;

public class SpecialArrayII {

    private ArrayList<Integer> violateIndices;
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        violateIndices = new ArrayList<>();
        for(int i = 1; i < nums.length; i++){
            if(nums[i]%2==nums[i-1]%2){
                violateIndices.add(i);
            }
        }
        boolean[] result = new boolean[queries.length];
        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            if(isViolating(query)){
                result[i] = false;
            }else{
                result[i] = true;
            }
        }
        return result;
    }

    private boolean isViolating(int[] query){
        int beg = 0;
        int end = violateIndices.size()-1;
        int left = query[0] + 1;
        int right = query[1];
        while(beg <= end){
            int mid = beg + (end-beg)/2;
            if(violateIndices.get(mid) >= left && violateIndices.get(mid) <= right){
                return true;
            }else if(violateIndices.get(mid) > right){
                end = mid-1;
            }else{
                beg = mid+1;
            }
        }
        return false;
    }

    public boolean[] isArraySpecialOptimal(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n];
        for(int i = 1; i < n; i++){
            if(nums[i] % 2 == nums[i-1] % 2){
                prefix[i] = prefix[i-1] + 1;
            }else{
                prefix[i] = prefix[i-1];
            }
        }
        boolean[] result = new boolean[queries.length];
        for(int i = 0; i < queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            result[i] = prefix[end] - prefix[start] == 0 ? true : false;
        }
        return result;
    }

}
