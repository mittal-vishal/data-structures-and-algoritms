package com.vishal.linkedlist;

public class MaxTwinSumInLinkedList {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
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
