package com.vishal.search;

public class ZeroArrayTransformationII {

    public int minZeroArray(int[] nums, int[][] queries) {
        int beg = 0;
        int end = queries.length;
        int result = -1;
        while(beg <= end){
            int mid = beg + (end-beg)/2;
            if(isPossible(mid, nums, queries)){
                end = mid-1;
                result = mid;
            }else{
                beg = mid+1;
            }
        }
        return result == -1 ? -1 : result;
    }

    private boolean isPossible(int k, int[] nums, int[][] queries){
        int[] range = new int[nums.length];
        for(int i = 0; i < k; i++){
            int[] query = queries[i];
            int u = query[0];
            int v = query[1];
            int val = query[2];
            range[u] += val;
            if(v+1 < range.length){
                range[v+1] -= val;
            }
        }
        for(int i = 1; i < nums.length; i++){
            range[i] += range[i-1];
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > range[i]){
                return false;
            }
        }
        return true;
    }

}
