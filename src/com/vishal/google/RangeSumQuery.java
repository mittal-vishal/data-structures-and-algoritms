package com.vishal.google;

public class RangeSumQuery {

    private int[] nums;
    private int[] prefixSum;

    public RangeSumQuery(int[] nums) {
        this.nums = nums;
        this.prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        int rangeSum = prefixSum[right];
        if(left > 0){
            rangeSum -= prefixSum[left-1];
        }
        return rangeSum;
    }

}
